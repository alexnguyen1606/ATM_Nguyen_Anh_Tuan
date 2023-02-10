package com.atm.views;

import com.atm.factory.InputFactory;

import java.util.Scanner;

public class HomeView {

    Scanner scanner;

    public HomeView() {
        this.scanner = InputFactory.getInput();
    }

    public Integer menu() {
        Integer check = null;
        System.out.println("--------------ATM---------------");
        System.out.println("nhập yêu cầu");
        System.out.println("1. Đăng nhập");
        System.out.println("10. Exit");
        System.out.print("Yêu cầu:");
        try {
            check = scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
        return check;
    }

}
