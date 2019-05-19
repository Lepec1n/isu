package com.isu.service;

import com.isu.model.Group;
import com.isu.model.Role;
import com.isu.model.User;
import com.isu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
    public User createStudent(String name, String password, Role role, Group group) {
        String pwdHash = this.generatePasswordHash(password);
        int dbRole = role.toInt();
        User student = new User(name, pwdHash, dbRole, group);
        userRepository.save(student);
        return student;
    }

    @Override
    public String generatePasswordHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < encodedHash.length; i++) {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception neverHappens) {
            return "STAS GAY";
        }
    }
}
