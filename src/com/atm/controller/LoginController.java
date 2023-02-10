package com.atm.controller;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountServiceImpl;
import com.atm.views.LoginView;

public class LoginController {
    private LoginView loginView;
    private IAccountService accountService;

    public LoginController() {
        loginView = new LoginView();
        accountService = new AccountServiceImpl();
    }

    public Account login() {
        int homeCheck = 1;
        boolean stop = true;
        Account account = null;

        while (stop) {
            switch (homeCheck) {
                case 1:
                    account = loginView.login();
                    account = accountService.authentication(account);
                    if (account == null) {
                        homeCheck = 2;
                    } else {
                        stop = false;
                    }
                    break;
                case 2:
                    loginView.loginFail();
                    stop = false;
                    break;
                default:
                    stop = false;
                    break;
            }
        }

        return account;

    }
}
