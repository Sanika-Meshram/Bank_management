package com.bank.util;

import com.bank.constant.AccountType;

import java.time.LocalDate;
import java.util.UUID;

public class IDGenerator {
    public static  int counter = 1 ;
    public String GenAccNo (AccountType accountType){
        String accountNumber = " ACC";
        if(accountType == AccountType.SAVING){
            accountNumber += "_s_" + LocalDate.now().getYear() + counter++;
        }   else {
            accountNumber += "_curr_" + LocalDate.now().getYear() + counter++;
        }
        return accountNumber;
    }
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
