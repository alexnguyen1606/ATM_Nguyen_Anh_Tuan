package com.atm.serivce.impl;

import com.atm.controller.MainController;
import com.atm.dao.AccountDAO;
import com.atm.dao.AtmDAO;
import com.atm.model.Account;
import com.atm.model.Atm;
import com.atm.serivce.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private final AccountDAO accountDAO;
    private final AtmDAO atmDAO;

    public AccountServiceImpl() {
        this.accountDAO = AccountDAO.getInstance();
        this.atmDAO = new AtmDAO();
    }

    @Override
    public boolean transferMoney(Account account2) {
        List<Account> accounts = accountDAO.getAccounts();
        Account account = MainController.getAccountLogin();
        if (account.getTotalMoney() < account2.getTranferAmount()) {
            System.out.println("Số tiền bạn k đủ để thực hiện giao dịch");
            return false;
        } else {
            Long ammountTranfer = account2.getTranferAmount();
            Boolean check = false;
            for (Account account1 : accounts) {
                if (account1.getAccountNumber().equals(account2.getAccountNumber())) {
                    account1.setTotalMoney(account1.getTotalMoney() + ammountTranfer);
                    check = true;
                    break;
                }
            }
            if (check) {
                for (Account account1 : accounts) {
                    if (account1.getAccountNumber().equals(account.getAccountNumber())) {
                        account1.setTotalMoney(account1.getTotalMoney() + ammountTranfer);
                        break;
                    }
                }
                System.out.println("Chuyển khoản thành công");
                return true;
            }
            return false;
        }

    }

    @Override
    public Account authentication(Account accountInput) {
        Long accountNumber = accountInput.getAccountNumber();
        String password = accountInput.getPassword();
        Account result = null;

        for (Account item : accountDAO.getAccounts()) {
            if (item.getPassword().equals(password) && item.getAccountNumber().equals(accountNumber) && item.getStatus().equals(1)) {
                result = item;
                break;
            }
        }
        return result;
    }

    @Override
    public Account findByAccountNumber(Long accountNumber) {
        List<Account> accounts = accountDAO.getAccounts();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void pickMoney(Account account) {
        Atm atm = atmDAO.getAtm();
        Account accountLogin = MainController.getAccountLogin();
        List<Account> accounts = accountDAO.getAccounts();
        if (atm.getTotalMoney() < account.getPickMoney()) {
            System.out.println("ATM Không đủ tiền mặt");
        } else if (accountLogin.getTotalMoney() < account.getPickMoney()) {
            System.out.println("Số tiền nhập quá số dư");

        } else {
            Long pickMoney = account.getPickMoney();
            for (Account item : accounts) {
                if (accountLogin.getAccountNumber().equals(item.getAccountNumber())) {
                    item.setTotalMoney(item.getTotalMoney() - pickMoney);
                    atm.setTotalMoney(atm.getTotalMoney() - pickMoney);
                }
            }
            MainController.setAtm(atm);
        }
    }


}
