package com.isu.service;

import com.isu.model.Group;
import com.isu.model.User;
import com.isu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createStudent(String name, Group group) {
        User student = new User(name, group);
        userRepository.save(student);
        return student;
    }
}
