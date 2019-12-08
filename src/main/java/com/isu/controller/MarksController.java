package com.isu.controller;


import com.isu.model.User;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("userId") long userId) {
        ModelAndView modelAndView = new ModelAndView();

        User user = userService.findUserById(userId);

        modelAndView.addObject("marks", user.getMarks());
        modelAndView.setViewName("marks/{userId}");
        return modelAndView;
    }
}
