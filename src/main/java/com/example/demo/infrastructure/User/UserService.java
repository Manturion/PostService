package com.example.demo.infrastructure.User;

import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.repositories.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositry userRepositry;

    public UserDto createUser(UserDto userDto) {
        userRepositry.save(UserDto.mapToEntity(userDto));
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        return userRepositry.findAll().stream().map(UserDto::new).toList();
    }

    public UserDto getUserById(Long id) {
        UserEntity user = userRepositry.findById(id).orElseThrow();
        return new UserDto(user);
    }

    public Optional<UserDto> editUser(Long id, UserDto userDto) {
        return userRepositry.findById(id).map((user -> {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            userRepositry.save(user);
            return null;
        }));
    }

    public String deleteUser(Long id) {
        userRepositry.deleteById(id);
        return "User which id is " + id + " was deleted succesfully";
    }
}
