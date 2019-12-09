package com.isu.controller.admin;

import com.isu.model.Group;
import com.isu.model.User;
import com.isu.service.interfaces.IGroupService;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();

        modelAndView.addObject("users", users);
        modelAndView.setViewName("admin/user/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();

        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/user/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid User user) {
        userService.create(user);
        return new ModelAndView("redirect:/admin/user/");

    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("userId") long userId) {
        ModelAndView modelAndView = new ModelAndView();

        User user = userService.findById(userId);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/user/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("userId") long userId, @Valid User newUser) {
        newUser.setId(userId);
        userService.update(newUser);
        return new ModelAndView("redirect:/admin/user/");
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("userId") long userId) {
        userService.delete(userId);
        return new ModelAndView("redirect:/admin/user/");
    }

}
