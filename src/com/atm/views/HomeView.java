package com.atm.views;

import com.atm.model.Account;

import java.util.List;
import java.util.Scanner;

public class HomeView {

    public Integer menu(Scanner in){


        Integer check = null;
        System.out.println("--------------ATM---------------");
        System.out.println("nhập yêu cầu");
        System.out.println("1. Đăng nhập");
        System.out.print("Yêu cầu:");
        try {
            check = in.nextInt();
        }catch (Exception e){
            return 0;
        }
        return check;
    }

}
