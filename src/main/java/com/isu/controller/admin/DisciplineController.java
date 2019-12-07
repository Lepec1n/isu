package com.isu.controller.admin;

import com.isu.model.Discipline;
import com.isu.service.IDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/discipline")
public class DisciplineController {

    @Autowired
    private IDisciplineService disciplineService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Discipline> disciplines = disciplineService.findAll();

        modelAndView.addObject("disciplines", disciplines);
        modelAndView.setViewName("admin/discipline/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Discipline discipline = new Discipline();

        modelAndView.addObject("discipline", discipline);
        modelAndView.setViewName("admin/discipline/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Discipline discipline) {
        disciplineService.create(discipline);
        return new ModelAndView("redirect:/admin/discipline/");

    }

    @RequestMapping(value = "/edit/{disciplineId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("disciplineId") long disciplineId) {
        ModelAndView modelAndView = new ModelAndView();

        Discipline discipline = disciplineService.findById(disciplineId);

        modelAndView.addObject("discipline", discipline);
        modelAndView.setViewName("admin/discipline/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{disciplineId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("disciplineId") long disciplineId, @Valid Discipline newDiscipline) {
        newDiscipline.setId(disciplineId);
        disciplineService.update(newDiscipline);
        return new ModelAndView("redirect:/admin/discipline/");
    }

    @RequestMapping(value = "/delete/{disciplineId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("disciplineId") long disciplineId) {
        disciplineService.delete(disciplineId);
        return new ModelAndView("redirect:/admin/discipline/");
    }

}
