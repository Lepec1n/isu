package com.isu.controller;

import com.isu.model.User;
import com.isu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> findCities() {
        return userService.findAll();
    }
}
