package com.isu.service;


import com.isu.model.Group;
import com.isu.model.User;
import com.isu.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements IGroupService{

    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<User> getStudents(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        List<User> students = null;
        if (group.isPresent()) {
            students = group.get().getStudents();
        }
        return students;
    }
}