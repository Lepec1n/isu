package com.isu.controller.admin;

import com.isu.model.Literature;
import com.isu.service.ILiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/literature")
public class LiteratureController {

    @Autowired
    private ILiteratureService literatureService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Literature> books = literatureService.findAll();

        modelAndView.addObject("literatures", books);
        modelAndView.setViewName("admin/literature/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = new Literature();

        modelAndView.addObject("literature", literature);
        modelAndView.setViewName("admin/literature/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Literature literature) {
        literatureService.create(literature);
        return new ModelAndView("redirect:/admin/literature/");

    }

    @RequestMapping(value = "/edit/{literatureId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("literatureId") long liteartureId) {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = literatureService.findLiterature(liteartureId);

        modelAndView.addObject("literature", literature);
        modelAndView.setViewName("admin/literature/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{literatureId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("literatureId") long literatureId, @Valid Literature newLiterature) {
        newLiterature.setId(literatureId);
        literatureService.update(newLiterature);
        return new ModelAndView("redirect:/admin/literature/");
    }

    @RequestMapping(value = "/delete/{literatureId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("literatureId") long literatureId) {
        literatureService.delete(literatureId);
        return new ModelAndView("redirect:/admin/literature/");
    }

}
