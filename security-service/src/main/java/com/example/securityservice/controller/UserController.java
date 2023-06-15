package com.example.securityservice.controller;

import com.example.securityservice.entity.User;
import com.example.securityservice.model.request.LoginRequest;
import com.example.securityservice.service.UserService;
import com.example.securityservice.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping()
    public ResponseEntity test() {
        return ResponseEntity.ok().body(userService.getList());
    }


    @GetMapping("/fill")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(userService.getList());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        if (userService.add(user)) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        try {
            // Xác thực thông tin đăng nhập
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok().body(tokenService.generateTokens(authentication));
        } catch (AuthenticationException ex) {
            // Xử lý khi xác thực thất bại
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex);
        }
    }

}
