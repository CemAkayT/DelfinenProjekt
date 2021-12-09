package com.company.UI;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);


    public void printMessage(String message) {

        System.out.println(message);
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

    // Only returns an integer in the range for the required menu @Graham Heaven
    public int getValidInt(int max) {
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice <= max && choice >= 0) {
                    break;
                } else {
                    System.out.println("Du kan kun taste et tal mellem 0 og " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Du kan kun taste et tal mellem 0 og " + max);
                sc.nextLine();
            }
        }
        sc.nextLine();
        return choice;
    }

    public int getValidYear() {
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice <= Year.now().getValue() && choice >= 1) {
                    break;
                } else {
                    System.out.println("Du kan kun taste et tal mellem 1 og " + Year.now().getValue());
                }
            } catch (InputMismatchException e) {
                System.out.println("Du kan kun taste et tal mellem 1 og " + Year.now().getValue());
                sc.nextLine();
            }
        }
        sc.nextLine();
        return choice;
    }

    public int getValidMonth() {
        int choice;
        while (true) {
            try {
                choice = sc.nextInt();
                if (choice <= 12 && choice >= 1) {
                    break;
                } else {
                    System.out.println("Du kan kun taste et tal mellem 1 og " + 12);
                }
            } catch (InputMismatchException e) {
                System.out.println("Du kan kun taste et tal mellem 1 og " + 12);
                sc.nextLine();
            }
        }
        sc.nextLine();
        return choice;
    }

    public int getValidDay(int month) {
        int choice;
        while (true) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                try {
                    choice = sc.nextInt();
                    if (choice <= 31 && choice >= 1) {
                        break;
                    } else {
                        System.out.println("Du kan kun taste et tal mellem 1 og " + 31);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du kan kun taste et tal mellem 1 og " + 31);
                    sc.nextLine();
                }
            }
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                try {
                    choice = sc.nextInt();
                    if (choice <= 30 && choice >= 1) {
                        break;
                    } else {
                        System.out.println("Du kan kun taste et tal mellem 1 og " + 30);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du kan kun taste et tal mellem 1 og " + 30);
                    sc.nextLine();
                }
            }
            if (month == 2) {
                try {
                    choice = sc.nextInt();
                    if (choice <= 29 && choice >= 1) {
                        break;
                    } else {
                        System.out.println("Du kan kun taste et tal mellem 1 og " + 29);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Du kan kun taste et tal mellem 1 og " + 29);
                    sc.nextLine();
                }
            }
        }
        sc.nextLine();
        return choice;
    }
}