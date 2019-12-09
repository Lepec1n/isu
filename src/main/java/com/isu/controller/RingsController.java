package com.isu.controller;


import com.isu.model.User;
import com.isu.service.interfaces.IRingService;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ring")
public class RingsController {

    @Autowired
    private IRingService ringService;
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/{ringId}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("ringId") long ringId) {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userService.findByRing(ringService.findById(ringId));

        modelAndView.addObject("users", users);
        modelAndView.setViewName("private/rings/detail");
        return modelAndView;
    }
}
