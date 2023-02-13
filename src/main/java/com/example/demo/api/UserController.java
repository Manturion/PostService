package com.example.demo.api;

import com.example.demo.infrastructure.User.UserDto;
import com.example.demo.infrastructure.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping()
    @ResponseBody
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    @ResponseBody
    public UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public Optional<UserDto> editUser(@PathVariable Long id,@RequestBody UserDto userDto){
        return userService.editUser(id, userDto);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
