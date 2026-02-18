package com.bank.service;

import com.bank.model.Account;

public interface BankService {
    void createAccount();
    void depositMoney();
    void WithdrawMoney();
    Account ShowAccountDetails();
    void ShowAllAccounts();
    void getTransaction(int page);
}
