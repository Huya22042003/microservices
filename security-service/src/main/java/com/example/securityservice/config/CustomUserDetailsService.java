package com.example.securityservice.config;

import com.example.securityservice.entity.User;
import com.example.securityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = repository.findByUsername(username);
        return optional.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản"));
    }
}
