package org.example.bankmanagemnt.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.bankmanagemnt.backend.model.Account;
import org.example.bankmanagemnt.backend.model.User;
import org.example.bankmanagemnt.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repo;

    public Account createAccount(User user){
        Account acc = new Account();
        acc.setAccountNumber(UUID.randomUUID().toString());
        acc.setBalance(BigDecimal.ZERO);
        acc.setStatus("ACTIVE");
        acc.setUser(user);
        return repo.save(acc);
    }
}
