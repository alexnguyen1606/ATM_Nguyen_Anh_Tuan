package com.atm.controller;

import com.atm.model.Account;
import com.atm.views.HomeView;
import com.atm.views.LoginView;

import java.util.Scanner;

public class HomeController {
    private Scanner scanner;
    private HomeView homeView;
    private LoginView loginView;
    public HomeController(Scanner scanner) {
        this.scanner = scanner;
        homeView = new HomeView();
        loginView = new LoginView(scanner);
    }

    public Integer index(Integer check){
        Integer homeCheck= 1;
        Boolean stop=true;
       while (stop){
           switch (homeCheck){
               case 1:
                   check = homeView.menu(scanner);
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
