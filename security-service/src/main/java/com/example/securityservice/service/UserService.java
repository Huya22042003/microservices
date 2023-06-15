package com.example.securityservice.service;

import com.example.securityservice.entity.User;

import java.util.List;

public interface UserService {
    List<User> getList();
    boolean add(User user);
}
