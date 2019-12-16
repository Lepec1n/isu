package com.isu.controller;

import com.isu.model.Literature;
import com.isu.model.User;
import com.isu.service.interfaces.ILiteratureService;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/literature")
public class LiteratureController {

    @Autowired
    private ILiteratureService literatureService;
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(name = "name", required = false) String name) {
        ModelAndView modelAndView = new ModelAndView();

        List<Literature> books;
        if (name != null) {
            books = literatureService.searchLiterature(name);
        } else {
            books = literatureService.findAll();
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("literature", books);
        modelAndView.setViewName("private/literature/list");
        return modelAndView;
    }

    @RequestMapping(value = "/{literatureId}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("literatureId") long literatureId) {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = literatureService.findLiterature(literatureId);

        modelAndView.addObject("literature", literature);
        modelAndView.setViewName("private/literature/detail");
        return modelAndView;
    }

    @RequestMapping(value = "/request/{literatureId}", method = RequestMethod.PUT)
    public ModelAndView addRequest(@PathVariable("literatureId") long literatureId) {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = literatureService.findLiterature(literatureId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        literatureService.createRequest(literature, user);
        modelAndView.addObject("literature", literature);
        modelAndView.setViewName("private/literature/detail");
        return modelAndView;
    }
}
