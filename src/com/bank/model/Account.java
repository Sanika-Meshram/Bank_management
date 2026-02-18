package com.bank.model;

import com.bank.constant.AccountType;
import com.bank.util.IDGenerator;

import java.util.ArrayList;

public class Account extends ArrayList {
    protected String accountNumber;
    protected User user;
    protected double balance;
    protected AccountType accountType;

    IDGenerator id = new IDGenerator();
    //constructor

    public Account(User user, double balance, AccountType accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = id.GenAccNo(accountType );
    }


    //getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    //deposit
    public void deposit(double amount){
        balance+=amount;

    }
    //withdraw
    public  String withdraw(double amount){
        if(amount > balance) return "Insufficient balance ";
        balance-=amount;
        return "Successfully withdrawn";

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", id=" + id +
                '}';
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
