package com.atm.serivce.impl;

import com.atm.dao.AccountDAO;
import com.atm.model.Account;
import com.atm.serivce.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {

    AccountDAO accountDAO = AccountDAO.getInstance();

    @Override
    public void activeAccount(Long accountId) {
        List<Account> accounts = accountDAO.getAccounts();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountId)) {
                account.setStatus(1);
            }
        }
    }

    @Override
    public void disableAccount(Long accountId) {
        List<Account> accounts = accountDAO.getAccounts();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountId)) {
                account.setStatus(0);
            }
        }
    }

    @Override
    public Account addAccount(Account account) {
        List<Account> accounts = accountDAO.getAccounts();
        boolean check = true;
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(account.getAccountNumber())) {
                check = false;
                break;
            }
        }
        if (check) {
            accounts.add(account);
            System.out.println("Thêm tài khoản thành công");
        } else {
            System.out.println("Số tài khoản đã tồn tại");
        }
        return account;
    }
}
