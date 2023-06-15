package com.example.securityservice.service.impl;

import com.example.securityservice.entity.User;
import com.example.securityservice.repository.UserRepository;
import com.example.securityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public boolean add(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
