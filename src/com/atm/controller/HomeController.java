package com.atm.controller;

import com.atm.views.HomeView;
import com.atm.views.LoginView;

public class HomeController {
    private final HomeView homeView;
    private final LoginView loginView;

    public HomeController() {
        homeView = new HomeView();
        loginView = new LoginView();
    }

    public Integer index(Integer check) {
        int homeCheck = 1;
        boolean stop = true;
        while (stop) {
            switch (homeCheck) {
                case 1:
                    check = homeView.menu();
                    stop = false;
                    break;
                default:
                    stop = false;
                    break;
            }
        }
        return check;
    }

}
