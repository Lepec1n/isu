package com.isu.service;


import com.isu.exception.GroupNotFoundException;
import com.isu.model.Group;
import com.isu.model.User;
import com.isu.repository.GroupRepository;
import com.isu.repository.UserRepository;
import com.isu.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

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

    @Override
    public Group findGroup(Long id){
        Optional<Group> dbGroupContainer = groupRepository.findById(id);
        if(!dbGroupContainer.isPresent())
            throw new GroupNotFoundException(id);
        return dbGroupContainer.get();
    }

    @Override
    public Group findGroup(String name) {
        return groupRepository.findGroupByName(name);
    }

    @Override
    public Group create(Group group) {
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group update(Group group) {
        groupRepository.save(group);
        return group;
    }

    @Override
    public void delete(Long groupId) {
        Group dbGroup = findGroup(groupId);
        delete(dbGroup);
    }

    @Override
    public void delete(Group group){
        groupRepository.delete(group);
    }
}