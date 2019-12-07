package com.isu.service;


import com.isu.exception.GroupNotFoundException;
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
        if (group.isPresent()) {
            return group.get().getStudents();
        } else {
            throw new GroupNotFoundException(groupId);
        }
    }

    @Override
    public List<User> getStudents(Group group) {
        return group.getStudents();
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findGroup(Long id){
        Optional<Group> dbGroupContainer = groupRepository.findById(id);
        if(!dbGroupContainer.isPresent())
            throw new GroupNotFoundException(id);
        return dbGroupContainer.get();
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findGroupByName(name);
    }

    @Override
    public Group createGroup(String name) {
        Group group = new Group();
        group.setName(name);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group updateGroup(Group group) {

        Group dbGroup = findGroup(group.getId());
        dbGroup.setName(group.getName());
        dbGroup.setStudents(group.getStudents());
        groupRepository.save(dbGroup);
        return dbGroup;
    }

    @Override
    public void deleteGroup(Group group) {
        Optional<Group> dbGroupContainer = groupRepository.findById(group.getId());
        if(!dbGroupContainer.isPresent())
            throw new GroupNotFoundException(group.getId());
        groupRepository.delete(dbGroupContainer.get());
    }
}