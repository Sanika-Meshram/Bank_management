package com.bank.model;

import com.bank.constant.AccountType;

public class SavingsAccount extends Account{
    private static final double MIN_BALANCE=10000.0;

    public SavingsAccount(User user, double balance) {
        super(user, balance, AccountType.SAVING);
    }
    public double getMinBalance(){
        return MIN_BALANCE;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
