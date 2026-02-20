package org.example.bankmanagemnt.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.bankmanagemnt.backend.model.User;
import org.example.bankmanagemnt.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }
}
