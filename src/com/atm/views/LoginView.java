package com.atm.views;

import com.atm.factory.InputFactory;
import com.atm.model.Account;

import java.util.Scanner;

public class LoginView {
    private Scanner in;

    public LoginView() {
        this.in = InputFactory.getInput();
    }

    public Account login() {
        Integer check = null;
        System.out.println("----Đăng nhập----");
        System.out.println("Nhập số tài khoản:");
        Account account = new Account();
        account.setAccountNumber(in.nextLong());
        in.nextLine();
        System.out.println("Nhập mật khẩu:");
        account.setPassword(in.next());
        return account;
    }

    public void loginFail() {
        System.out.println("----------------ATM---------------");
        System.out.println("----------Fail----------");
    }

}
