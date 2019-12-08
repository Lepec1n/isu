package com.isu.controller.admin;

import com.isu.model.Faculty;
import com.isu.model.Ring;
import com.isu.service.IFacultyService;
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
public class FacultyAdminController {

    @Autowired
    private IFacultyService facultyService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Faculty> faculties = facultyService.findAll();

        modelAndView.addObject("faculties", faculties);
        modelAndView.setViewName("admin/faculty/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Faculty faculty = new Faculty();

        modelAndView.addObject("faculty", faculty);
        modelAndView.setViewName("admin/faculty/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Faculty faculty) {
        facultyService.create(faculty);
        return new ModelAndView("redirect:/admin/faculty/");

    }

    @RequestMapping(value = "/edit/{facultyId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("facultyId") long facultyId) {
        ModelAndView modelAndView = new ModelAndView();

        Faculty faculty = facultyService.findById(facultyId);

        modelAndView.addObject("faculty", faculty);
        modelAndView.setViewName("admin/faculty/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{facultyId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("facultyId") long facultyId, @Valid Faculty newFaculty) {
        newFaculty.setId(facultyId);
        facultyService.update(newFaculty);
        return new ModelAndView("redirect:/admin/faculty/");
    }

    @RequestMapping(value = "/delete/{facultyId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("facultyId") long facultyId) {
        facultyService.delete(facultyId);
        return new ModelAndView("redirect:/admin/faculty/");
    }

}
