package com.isu.service;

import com.isu.model.User;

import java.util.List;

public interface IGroupService {
    List<User> getStudents(Long groupId);
}
