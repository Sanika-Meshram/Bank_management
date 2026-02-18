package com.bank.service;

import com.bank.constant.AccountType;
import com.bank.exception.AccountNotFound;
import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.model.User;
import com.bank.repository.BankRepository;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BankServiceImpl implements BankService{
    Scanner sc = new Scanner(System.in);

    @Override
    public void createAccount() {

        String name , mobileNo , address, email ;
        AccountType accType;
        double  balance ;
        Account account;

        System.out.println("Enter details: ");
        System.out.println("Name: ");
        name = sc.nextLine();

        System.out.println("MobileNo: ");
        mobileNo = sc.nextLine();

        System.out.println("Address: ");
        address = sc.nextLine();

        System.out.println("email: ");
        email = sc.nextLine();

        System.out.println("Account Type :  \n 1.Saving \n 2. Current");
        int accop = sc.nextInt();

        System.out.println("Balance :  ");
        balance = sc.nextDouble();
        while (accop == 1 && balance <=1000){
            System.out.println("Balance should be more than 10000");
            System.out.println("Enter new balance: ");
            balance = sc.nextDouble();
        }
        if (accop == 1 ) {
            accType = AccountType.SAVING;

        }else{
            accType = AccountType.CURRENT;

        }
        //User Object
        User us = new User(name,mobileNo,address,email);
        System.out.println(us.toString());
        if(accType == AccountType.SAVING){
            account = new SavingsAccount(us, 15000);
            System.out.println(account.toString());
        }else{
            account  = new CurrentAccount(us , 140000);
            System.out.println(account.toString());
        }

        BankRepository.accounts.put(account.getAccountNumber(),account);
        String record = LocalDateTime.now() + " | " + " Credit " + " | " + balance ;
        ArrayList<String> transaction = new ArrayList<>();
        transaction.add(record);
        BankRepository.transactions.put(account.getAccountNumber(),account);
        sc.nextLine();
    }

    @Override
    public void depositMoney() {
        System.out.println("Enter account Number : ");
        String accNo = sc.nextLine();


        Account acc = BankRepository.accounts.get(accNo);
        if(acc==null){
            throw new AccountNotFound("Account Not Found");
        }

        System.out.println("Enter amount to deposit : ");
        double amount = sc.nextDouble();
        sc.nextLine();
        acc.deposit(amount);

        String record = LocalDateTime.now() + " | " + " Deposit " + " | " + amount ;
        ArrayList<String> transaction = BankRepository.transactions.get(acc.getAccountNumber());
        transaction.add(record);
        BankRepository.transactions.get(acc.getAccountNumber()).add(record);
        System.out.println("Amount deposited successfully");

    }

    @Override
    public void WithdrawMoney() {
        System.out.println("Enter account Number : ");
        String accNo = sc.nextLine();


        Account acc = BankRepository.accounts.get(accNo);
        if(acc==null){
            throw new AccountNotFound("Account Not Found");
        }

        System.out.println("Enter amount to withdraw : ");
        double amount = sc.nextDouble();
        sc.nextLine();
        acc.withdraw(amount);

        String record = LocalDateTime.now() + " | " + " Withdrawn " + " | " + amount ;

        BankRepository.transactions.put(acc.getAccountNumber()).add(record);
        System.out.println("Amount withdrawn successfully");

    }

    @Override
    public Account ShowAccountDetails() {
        System.out.println("Enter account number");
        String accNo = sc.nextLine();

        Account account = BankRepository.accounts.get(accNo);
        if (account == null)
            throw new AccountNotFound("Account not found");
        System.out.println(account.toString());
        return account ;

    }

    @Override
    public void ShowAllAccounts() {
        System.out.println(BankRepository.accounts);
    }

    @Override
    public void getTransaction(int page) {
        int limit = 5;
        int skip = (page - 1) * limit;

        Account account;
        account = ShowAccountDetails();
        ArrayList<String> transactions  = BankRepository.transactions.get(account.getAccountNumber());
        if(skip >= BankRepository.transactions.size()){
            System.out.println("No data found!!!");
            }
        int endindex = Math.min(skip+limit,transactions.size());
        for(int i = skip;i<endindex;i++){
            System.out.println(transactions.get(i));
        }

    }


}
