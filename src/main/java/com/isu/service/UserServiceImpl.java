package com.isu.service;

import com.isu.exception.UserNotFoundException;
import com.isu.model.Role;
import com.isu.model.User;
import com.isu.repository.RoleRepository;
import com.isu.repository.UserRepository;
import com.isu.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveStudent(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByName(Role.STUDENT);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        Optional<User> dbUserContainer = userRepository.findById(userId);
        if(!dbUserContainer.isPresent())
            throw new UserNotFoundException(userId);
        return dbUserContainer.get();
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(Long userId) {
        User dbUser = findUserById(userId);
        delete(dbUser);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> dbUserContainer = userRepository.findById(id);
        if(!dbUserContainer.isPresent()){
            throw new UserNotFoundException(id);
        }
        return dbUserContainer.get();
    }

    @Override
    public List<User> finAllUsersByRole(Role role) {
        return null;
    }

}
