package com.isu.controller;


import com.isu.model.Group;
import com.isu.model.Role;
import com.isu.model.User;
import com.isu.service.IGroupService;
import com.isu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    IGroupService groupService;
    @Autowired
    IUserService userService;

    @GetMapping("/test")
    public ModelAndView performWriteTest(){
        Group group = groupService.createEmptyGroup();
        User student = userService.createStudent("pwduser", "hunter2", Role.STUDENT, group);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/test_read")
    public List<User> performWriteTest(@RequestParam Long groupId){
        return groupService.getStudents(groupId);
    }
}
