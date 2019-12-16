package com.isu.controller.common;


import com.isu.model.User;
import com.isu.service.interfaces.IRingService;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/public/ring")
public class PublicRingsController {

    @Autowired
    private IRingService ringService;
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam(name = "ringId", required = false) String ringId) {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users;
        String error = null;

        if (ringId != null) {
            try {
                long ringIdLong = Long.parseLong(ringId);
                users = userService.findByRing(ringService.findById(ringIdLong));
            } catch (NumberFormatException exception) {
                users = null;
                error = "Некорректный ID кольца!";
            }
        } else {
            users = null;
        }

        modelAndView.addObject("users", users);
        modelAndView.addObject("error", error);
        modelAndView.addObject("ringId", ringId);
        modelAndView.setViewName("public/rings/detail");
        return modelAndView;
    }
}
