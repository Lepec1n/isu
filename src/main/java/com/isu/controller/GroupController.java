package com.isu.controller;

import com.isu.model.Group;
import com.isu.model.User;
import com.isu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/my_group", method = RequestMethod.GET)
    public ModelAndView myGroup() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Group group = new Group();
        List<User> students = new ArrayList<>();
        if (user != null) {
            group = user.getGroup();
            if (group != null) {
                students = group.getStudents();
            }
        }
        modelAndView.addObject("group", group);
        modelAndView.addObject("students", students);
        modelAndView.setViewName("group");
        return modelAndView;
    }

    
}