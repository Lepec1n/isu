package com.isu.controller;

import com.isu.model.User;
import com.isu.model.Group;
import com.isu.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GroupController {

    @Autowired
    IGroupService groupService;

    @GetMapping("/group/{groupId}")
    public ModelAndView getGroupPage(@PathVariable Long groupId) {
        Group group = groupService.getGroup(groupId);

        List<User> students = null;

        if (group != null) {
            students = groupService.getStudents(groupId);
        }

        ModelAndView mav = new ModelAndView("group");

        mav.addObject("students", students);
        mav.addObject("group", group);
        mav.addObject("groupId", groupId);

        return mav;
    }
}
