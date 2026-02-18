package com.bank.app;

import com.bank.constant.AccountType;
import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingsAccount;
import com.bank.model.User;
import com.bank.service.BankServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        BankServiceImpl bank = new BankServiceImpl();
       int choice = 0 ;
       while(choice != -1) {
           System.out.println(("1. Create Account"));
           System.out.println(("2. Deposit"));
           System.out.println(("3. Withdraw"));
           System.out.println(("4. Details"));
           System.out.println(("5. Show All accounts"));
           System.out.println(("9. Exit"));
           choice = sc.nextInt();

           try {
               switch (choice) {
                   case 1:
                       bank.createAccount();
                       break;
                   case 2:
                       bank.depositMoney();
                       break;
                   case 3:
                       bank.WithdrawMoney();
                       break;
                   case 4:
                       bank.ShowAccountDetails();
                       break;
                   case 5:
                       bank.ShowAllAccounts();
                       break;
                   case 9:
                       return;

               }
           }
       catch(RuntimeException e) {
           System.out.println(e);
       }

       }

    }
}

