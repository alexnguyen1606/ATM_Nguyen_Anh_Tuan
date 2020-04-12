package com.atm.controller;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.IAdminService;
import com.atm.serivce.IAtmService;
import com.atm.serivce.impl.AdminServiceImpl;
import com.atm.serivce.impl.AtmServiceImpl;
import com.atm.views.AdminView;

import java.io.IOException;
import java.util.Scanner;

public class AdminController {
    private Scanner scanner ;
    private AdminView adminView;
    private IAdminService adminService;
    private IAtmService atmService;
    public AdminController(Scanner scanner) {
        this.scanner = scanner;
        adminView = new AdminView(this.scanner);
        adminService = new AdminServiceImpl();
        atmService = new AtmServiceImpl();
    }

    public Integer index() throws IOException {
        Integer adminCheck =0;
        Long accountNumber = null;
        boolean stop= true;
        do {
            switch (adminCheck){
                case 0:
                   adminCheck= adminView.index();
                   break;
                case 1:
                    adminCheck=adminView.listUser();
                    break;
                case 2:
                    Account account = adminView.formInputAccount();
                    adminService.addAccount(account);
                    adminCheck = 0;
                    break;
                case 3:
                    accountNumber = adminView.active();
                    adminService.activeAccount(accountNumber);
                    accountNumber = null;
                    adminCheck = 0;
                    break;
                case 4:
                     accountNumber = adminView.disable();
                    adminService.disableAcount(accountNumber);
                    accountNumber = null;
                    adminCheck = 0;
                    break;
                case 5:
                    adminCheck = adminView.atmInfo(atmService.findById());
                    break;
                case 6:
                    stop = false;
                    adminCheck = 11;
                    break;
            }
        }while (stop);
        return adminCheck;
    }

}
