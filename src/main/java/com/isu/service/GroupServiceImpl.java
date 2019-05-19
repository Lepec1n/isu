package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;
import com.isu.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService{

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    IUserService userService;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group createEmptyGroup() {
        Group group = new Group(Collections.emptyList());
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group addStudent(Group group, User student) {
        group.getStudents().add(student);
        groupRepository.save(group);
        return group;
    }

    @Override
    public List<User> getStudents(Long groupId) {
        List<User> students =  groupRepository.findById(groupId).get().getStudents();
        return students;
    }
}
