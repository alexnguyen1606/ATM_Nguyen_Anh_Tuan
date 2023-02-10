package com.atm.controller;

import com.atm.dao.AtmDAO;
import com.atm.model.Account;
import com.atm.model.Atm;

import java.io.IOException;

public class MainController {
    private static Atm atm;
    private static Account accountLogin;

    public MainController() {

    }

    public static void main(String[] args) throws IOException {
        int check = 0;
        HomeController homeController = new HomeController();
        LoginController loginController = new LoginController();
        AdminController adminController = new AdminController();
        UserController userController = new UserController();
        getAtm();
        boolean stop = true;
        do {
            switch (check) {
                case 0:
                    check = homeController.index(check);
                    break;
                case 1://đăng nhập
                    accountLogin = loginController.login();
                    check = 2;
                    break;
                case 2:
                    if (accountLogin == null) {
                        check = 0;
                    } else {
                        if (accountLogin.getRole().equalsIgnoreCase("admin")) {

                            check = 3;
                        } else {
                            check = 4;
                        }
                    }
                    break;
                case 3://admin
                    if (accountLogin == null) {
                        check = 0;
                    } else {
                        check = adminController.index();
                    }

                    break;
                case 4://user
                    if (accountLogin == null) {
                        check = 0;
                    } else {
                        userController.index();
                        check = 11;
                    }
                    break;
                case 10://ngừng giao dịch
                    stop = false;
                    break;
                case 11:
                    System.out.println("Logout");
                    accountLogin = null;
                    check = 0;
                    break;
                default:
                    System.out.println("Logout");
                    check = 0;
                    stop = false;
                    break;
            }

        } while (stop);
    }

    public static Account getAccountLogin() {
        return accountLogin;
    }

    public static void setAccount(Account account) {
        accountLogin = account;
    }

    public static Atm getAtm() {
        return new AtmDAO().getAtm();
    }

    public static void setAtm(Atm atm) {
        MainController.atm = atm;
    }
}
