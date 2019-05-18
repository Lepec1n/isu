package com.isu.service;

import com.isu.model.User;
import com.isu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
