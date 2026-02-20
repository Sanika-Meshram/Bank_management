package org.example.bankmanagemnt.backend.repository;

import org.example.bankmanagemnt.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
