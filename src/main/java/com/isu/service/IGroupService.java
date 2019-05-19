package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;

import java.util.List;

public interface IGroupService {

    List<Group> findAll();

    Group createEmptyGroup();

    Group addStudent(Group group, User student);

    List<User> getStudents(Long groupId);
}
