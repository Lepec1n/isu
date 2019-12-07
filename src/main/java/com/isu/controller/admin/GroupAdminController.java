package com.isu.controller.admin;

import com.isu.model.Discipline;
import com.isu.model.Group;
import com.isu.model.User;
import com.isu.service.IDisciplineService;
import com.isu.service.IGroupService;
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
@RequestMapping("/admin/group")
public class GroupAdminController {

    @Autowired
    private IGroupService groupService;
    @Autowired
    private IUserService userService;

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
        List<User> users = userService.findAll();
        modelAndView.addObject("group", group);
        modelAndView.addObject("users", users);
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
