package com.isu.controller.admin;

import com.isu.model.LiteratureRequest;
import com.isu.service.interfaces.ILiteratureRequestService;
import com.isu.service.interfaces.ILiteratureService;
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
@RequestMapping("/admin/request")
public class RequestAdminController {

    @Autowired
    private ILiteratureRequestService requestService;
    @Autowired
    private ILiteratureService literatureService;
    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<LiteratureRequest> requests = requestService.findAll();

        modelAndView.addObject("requests", requests);
        modelAndView.setViewName("admin/request/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        LiteratureRequest request = new LiteratureRequest();

        modelAndView.addObject("request", request);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("literatures", literatureService.findAll());
        modelAndView.setViewName("admin/request/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid LiteratureRequest request) {
        requestService.create(request);
        return new ModelAndView("redirect:/admin/request/");

    }

    @RequestMapping(value = "/edit/{requestId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("requestId") long requestId) {
        ModelAndView modelAndView = new ModelAndView();

        LiteratureRequest request = requestService.findById(requestId);

        modelAndView.addObject("request", request);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("literatures", literatureService.findAll());
        modelAndView.setViewName("admin/request/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{requestId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("requestId") long requestId,
                             @Valid LiteratureRequest newRequest) {
        newRequest.setId(requestId);
        requestService.update(newRequest);
        return new ModelAndView("redirect:/admin/request/");
    }

    @RequestMapping(value = "/delete/{facultyId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("facultyId") long facultyId) {
        requestService.delete(facultyId);
        return new ModelAndView("redirect:/admin/request/");
    }

}
