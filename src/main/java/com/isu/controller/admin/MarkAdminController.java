package com.isu.controller.admin;

import com.isu.model.Discipline;
import com.isu.model.Mark;
import com.isu.service.interfaces.IDisciplineService;
import com.isu.service.interfaces.IMarkService;
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
@RequestMapping("/admin/mark")
public class MarkAdminController {

    @Autowired
    private IMarkService markService;
    @Autowired
    private IDisciplineService disciplineService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Mark> marks = markService.findAll();

        modelAndView.addObject("marks", marks);
        modelAndView.setViewName("admin/mark/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Mark mark = new Mark();

        modelAndView.addObject("mark", mark);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("disciplines", disciplineService.findAll());
        modelAndView.setViewName("admin/mark/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Mark mark) {
        markService.create(mark);
        return new ModelAndView("redirect:/admin/mark/");

    }

    @RequestMapping(value = "/edit/{markId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("markId") long markId) {
        ModelAndView modelAndView = new ModelAndView();

        Mark mark = markService.findById(markId);

        modelAndView.addObject("mark", mark);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("disciplines", disciplineService.findAll());
        modelAndView.setViewName("admin/mark/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{markId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("markId") long markId, @Valid Mark newMark) {
        newMark.setId(markId);
        markService.update(newMark);
        return new ModelAndView("redirect:/admin/mark/");
    }

    @RequestMapping(value = "/delete/{markId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("markId") long markId) {
        markService.delete(markId);
        return new ModelAndView("redirect:/admin/mark/");
    }

}
