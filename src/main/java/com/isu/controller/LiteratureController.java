package com.isu.controller;

import com.isu.model.Literature;
import com.isu.service.interfaces.ILiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/literature")
public class LiteratureController {

    @Autowired
    private ILiteratureService literatureService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Literature> books = literatureService.findAll();

        modelAndView.addObject("literature", books);
        modelAndView.setViewName("private/literature/list");
        return modelAndView;
    }

    @RequestMapping(value = "/{literatureId}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("literatureId") long liteartureId) {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = literatureService.findLiterature(liteartureId);

        modelAndView.addObject("literature", literature);
        modelAndView.setViewName("private/literature/detail");
        return modelAndView;
    }
}
