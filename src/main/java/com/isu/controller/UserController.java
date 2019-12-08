package com.isu.controller;

import com.isu.model.Literature;
import com.isu.service.interfaces.ILiteratureService;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView getStudents() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users", userService.findAllStudents());
        modelAndView.setViewName("private/users/list");
        return modelAndView;
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ModelAndView getTeachers() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users", userService.findAllTeachers());
        modelAndView.setViewName("private/users/list");
        return modelAndView;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getTeachers(@PathVariable("userId") long userId) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users", userService.findById(userId));
        modelAndView.setViewName("private/users/detail");
        return modelAndView;
    }
}
