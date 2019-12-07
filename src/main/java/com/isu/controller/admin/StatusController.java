package com.isu.controller.admin;

import com.isu.exception.StatusNotFoundException;
import com.isu.model.Status;
import com.isu.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Status> statuses = statusService.getStatuses();

        modelAndView.addObject("statuses", statuses);
        modelAndView.setViewName("admin/status/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Status status = new Status();

        modelAndView.addObject("status", status);
        modelAndView.setViewName("admin/status/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Status status) {
        statusService.create(status);
        return new ModelAndView("redirect:/admin/status/");

    }

    @RequestMapping(value = "/edit/{statusId}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("statusId") long statusId) {
        ModelAndView modelAndView = new ModelAndView();
        Status status = statusService.findStatusById(statusId);

        modelAndView.addObject("status", status);
        modelAndView.setViewName("admin/status/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{statusId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("statusId") long statusId, @Valid Status newStatus) {
        newStatus.setId(statusId);
        statusService.update(newStatus);

        return new ModelAndView("redirect:/admin/status/");
    }

    @RequestMapping(value = "/delete/{statusId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("statusId") long statusId) {
        statusService.delete(statusId);
        return new ModelAndView("redirect:/admin/status/");
    }

}
