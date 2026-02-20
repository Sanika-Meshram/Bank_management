package org.example.bankmanagemnt.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.bankmanagemnt.backend.model.Account;
import org.example.bankmanagemnt.backend.model.User;
import org.example.bankmanagemnt.backend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody User user){
        return ResponseEntity.ok(service.createAccount(user));
    }
}
