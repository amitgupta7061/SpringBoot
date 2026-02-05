package com.auth.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.api.dto.LoginRequest;
import com.auth.api.dto.SignupRequest;
import com.auth.api.models.User;
import com.auth.api.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {

        if (userRepository.findByUsername(request.username).isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(request.username);
        user.setPassword(encoder.encode(request.password));

        userRepository.save(user);
        return "Signup successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.username)
                .orElse(null);

        if (user == null) return "User not found";

        if (!encoder.matches(request.password, user.getPassword()))
            return "Invalid credentials";

        return "Login successful";
    }
}
