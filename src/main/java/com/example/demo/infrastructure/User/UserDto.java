package com.example.demo.infrastructure.User;

import com.example.demo.domain.entities.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public static UserEntity mapToEntity (UserDto user){
       UserEntity userEntity = new UserEntity();
       userEntity.setPassword(user.getPassword());
       userEntity.setUsername(user.getUsername());
       userEntity.setLastName(user.getLastName());
       userEntity.setFirstName(user.getFirstName());
       return userEntity;
    }

    public UserDto(UserEntity user){
        this.firstName = user.getFirstName();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.lastName = user.getLastName();
        this.id = user.getId();
    }
}
