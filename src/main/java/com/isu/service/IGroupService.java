package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;

import java.util.List;

public interface IGroupService {

    List<User> getStudents(Long groupId);

    List<User> getStudents(Group group);

    List<Group> findAll();

    List<Group> findGroupByName();

    Group createGroup(String name);

    Group updateGroup(Group group);

    void deleteGroup(Group group);
}
