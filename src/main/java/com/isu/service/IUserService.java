package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User createStudent(String name, Group group);
}
