package com.isu.controller.admin;

import com.isu.model.Discipline;
import com.isu.model.Ring;
import com.isu.service.IRingService;
import com.isu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/ring")
public class RingAdminController {

    @Autowired
    private IRingService ringService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Ring> rings = ringService.findAll();

        modelAndView.addObject("rings", rings);
        modelAndView.setViewName("admin/ring/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Ring ring = new Ring();

        modelAndView.addObject("ring", ring);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("admin/ring/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Ring ring) {
        ringService.create(ring);
        return new ModelAndView("redirect:/admin/ring/");

    }

    @RequestMapping(value = "/edit/{ringId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("ringId") long ringId) {
        ModelAndView modelAndView = new ModelAndView();

        Ring ring = ringService.findById(ringId);

        modelAndView.addObject("ring", ring);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("admin/ring/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{ringId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("ringId") long ringId, @Valid Ring newRing) {
        newRing.setId(ringId);
        ringService.update(newRing);
        return new ModelAndView("redirect:/admin/ring/");
    }

    @RequestMapping(value = "/delete/{ringId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("ringId") long ringId) {
        ringService.delete(ringId);
        return new ModelAndView("redirect:/admin/ring/");
    }

}
