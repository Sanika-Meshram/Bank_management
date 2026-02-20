package org.example.bankmanagemnt.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.bankmanagemnt.backend.model.Account;
import org.example.bankmanagemnt.backend.model.Transaction;
import org.example.bankmanagemnt.backend.repository.AccountRepository;
import org.example.bankmanagemnt.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountRepository accountRepo;
    private final TransactionRepository txRepo;

    public void deposit(Long accountId, BigDecimal amount){
        Account acc = accountRepo.findById(accountId).get();
        acc.setBalance(acc.getBalance().add(amount));

        Transaction tx = new Transaction();
        tx.setType("DEPOSIT");
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        tx.setAccount(acc);

        txRepo.save(tx);
        accountRepo.save(acc);
    }
}
