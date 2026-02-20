package org.example.bankmanagemnt.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.bankmanagemnt.backend.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/deposit/{id}")
    public ResponseEntity<String> deposit(@PathVariable Long id,
                                          @RequestParam BigDecimal amount){
        service.deposit(id, amount);
        return ResponseEntity.ok("Deposit successful");
    }
}
