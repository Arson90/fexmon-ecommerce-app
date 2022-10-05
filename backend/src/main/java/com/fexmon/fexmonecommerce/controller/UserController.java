package com.fexmon.fexmonecommerce.controller;

import com.fexmon.fexmonecommerce.dto.UserDTO;
import com.fexmon.fexmonecommerce.model.UserModel;
import com.fexmon.fexmonecommerce.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fexmon")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping ("/user/{userId}")
    public UserModel getUserById(@PathVariable final Long userId) {
        return userService.fetchUser(userId);
    }

    @GetMapping("/user")
    public List<UserModel> getAllUsers() {
        return userService.fetchUserList();
    }

    @PostMapping("/user")
    public UserModel addUser(@RequestBody final UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @PutMapping


    @DeleteMapping
}
