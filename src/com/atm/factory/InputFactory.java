package com.atm.factory;

import java.util.Scanner;

/**
 * @author: Nguyen Anh Tuan
 * Feb 08, 2023
 */

public class InputFactory {

    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getInput() {
        return scanner;
    }

}
