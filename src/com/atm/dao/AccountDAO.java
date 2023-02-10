package com.atm.dao;

import com.atm.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    private static List<Account> accounts;
    private static Account account;
    private static final AccountDAO instance;
    private AccountDAO() {
        setAccounts();
    }

    static {
        instance = new AccountDAO();
    }

    public static AccountDAO getInstance() {
        return instance;
    }

    public void setAccounts() {
        this.accounts = new ArrayList<>();
        Account builder1 = new Account.Builder().setAccountNumber(9209123210L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("admin").build();
        Account builder2 = new Account.Builder().setAccountNumber(9209123212L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();
        Account builder3 = new Account.Builder().setAccountNumber(9209123215L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();
        Account builder4 = new Account.Builder().setAccountNumber(9209123218L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();

        accounts.add(builder1);
        accounts.add(builder2);
        accounts.add(builder3);
        accounts.add(builder4);
    }

    public List<Account> getAccounts() {
        return accounts;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
