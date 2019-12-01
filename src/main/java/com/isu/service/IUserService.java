package com.isu.service;

import com.isu.model.User;

public interface IUserService {

    User findUserByUsername(String username);

    void saveUser(User user);


}
