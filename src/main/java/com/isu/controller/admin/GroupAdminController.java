package com.isu.controller.admin;

import com.isu.model.Group;
import com.isu.service.interfaces.IFacultyService;
import com.isu.service.interfaces.IGroupService;
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
@RequestMapping("/admin/group")
public class GroupAdminController {

    @Autowired
    private IGroupService groupService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IFacultyService facultyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Group> groups = groupService.findAll();

        modelAndView.addObject("groups", groups);
        modelAndView.setViewName("admin/group/list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        Group group = new Group();

        modelAndView.addObject("group", group);
        modelAndView.addObject("faculties", facultyService.findAll());
        modelAndView.setViewName("admin/group/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid Group group) {
        groupService.create(group);
        return new ModelAndView("redirect:/admin/group/");

    }

    @RequestMapping(value = "/edit/{groupId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("groupId") long groupId) {
        ModelAndView modelAndView = new ModelAndView();

        Group group = groupService.findGroup(groupId);
        modelAndView.addObject("group", group);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("admin/group/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{groupId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("groupId") long groupId, @Valid Group newGroup) {
        newGroup.setId(groupId);
        groupService.update(newGroup);
        return new ModelAndView("redirect:/admin/group/");
    }

    @RequestMapping(value = "/delete/{groupId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("groupId") long groupId) {
        groupService.delete(groupId);
        return new ModelAndView("redirect:/admin/group/");
    }

}
