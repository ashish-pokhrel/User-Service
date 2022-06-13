package com.user.userservice.controllers;

import com.user.userservice.models.Admin;
import com.user.userservice.models.Normal;
import com.user.userservice.models.User;
import com.user.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestBody Admin user) {
        userService.save(user);
        return "Saved Successfully";
    }

    @PutMapping("/edit")
    public String edit(@RequestBody User user) {
        User editUser = userService.getById(user.getId());
        editUser.setUsername(user.getUsername());
        userService.save(user);
        return "Saved Successfully";
    }
    @PostMapping("/saveNormal")
    public String saveNormal(@RequestBody Normal user) {
        userService.save(user);
        return "Saved Successfully";
    }
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/getRoleById/{id}")
    public String getRoleById(@PathVariable Long id) {
        return userService.getRoleById(id);
    }

    @GetMapping("/getUserByName/{userName}")
    public User getUserByName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/loadUserByUsername/{userName}")
    public UserDetails loadUserByUsername(@PathVariable String userName) {
        var result = userService.loadUserByUsername(userName);
        return  result;
    }

}
