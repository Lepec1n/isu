package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;

import java.util.List;

public interface IGroupService {

    List<User> getStudents(Long groupId);

    List<User> getStudents(Group group);

    List<Group> findAll();

    Group findGroup(Long groupId);

    Group findGroup(String groupName);

    Group create(Group name);

    Group update(Group group);

    void delete(Group group);

    void delete(Long groupId);

}
