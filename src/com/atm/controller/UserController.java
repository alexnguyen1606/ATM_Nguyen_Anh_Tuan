package com.atm.controller;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountServiceImpl;
import com.atm.views.UserView;

public class UserController {
    private UserView userView;
    private IAccountService accountService;

    public UserController() {
        this.userView = new UserView();
        this.accountService = new AccountServiceImpl();
    }

    public void index() {
        Integer userCheck = 0;
        boolean stop = true;
        Account account = null;

        do {
            switch (userCheck) {
                case 0:
                    userCheck = userView.index();
                    break;
                case 1:
                    userView.checkBalance();
                    userCheck = 0;
                    break;
                case 2:
                    account = new Account();
                    userView.transferMoney(account);
                    accountService.transferMoney(account);
                    account = null;
                    userCheck = 0;
                    break;
                case 3:
                    account = userView.pickMoney();
                    accountService.pickMoney(account);
                    account = null;
                    userCheck = 0;
                    break;
                case 4:
                    stop = false;
                    break;
            }
        } while (stop);
    }
}
