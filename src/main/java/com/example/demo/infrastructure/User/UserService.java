package com.example.demo.infrastructure.User;

import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.repositories.UserRepository;
import com.example.demo.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerUser(RegisterRequest request) {
        boolean userExists = userRepository.findByUsername(request.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("email is already taken");
        }
        var user = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }

    public UserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        return new UserDto(user);
    }

    public Optional<UserDto> editUser(Long id, UserDto userDto) {
        UserVerificationProvider.compabilityVerificator(id);
        return userRepository.findById(id).map((user -> {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            return null;
        }));
    }

    public String deleteUser(Long id) {
        UserVerificationProvider.compabilityVerificator(id);
        userRepository.deleteById(id);
        return "User which id is " + id + " was deleted succesfully";
    }
}
