package com.company.UI;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);


    public void printMessage(String message) {

        System.out.println(message);
    }

    public void printDouble(double doub) {

        System.out.println(doub);
    }

    public String getInputString() {

        return sc.nextLine();
    }

    public double getInputDouble() {

        return sc.nextDouble();
    }

    public int getInputInt() {
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public int getValidInt(int max) {
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice <= max && choice >= 0) {
                    break;
                } else {
                    System.out.println("Dette er ikke muligt, prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dette er ikke muligt, prøv igen.");
                sc.nextLine();
            }
        }

        return choice;
    }
}