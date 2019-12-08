package com.isu.service.interfaces;

import com.isu.model.Role;
import com.isu.model.User;

import java.util.List;

public interface IUserService {

    User findUserByUsername(String username);

    User saveStudent(User user);

    List<User> findAll();

    User findById(Long userId);

    User create(User user);

    User update(User user);

    void delete(User user);

    void delete(Long userId);

    User findUserById(Long id);

    List<User> finAllUsersByRole(Role role);

    List<User> findAllStudents();

    List<User> findAllTeachers();
}
