package com.company.UI;

import java.util.Scanner;

public class UserInterface {
Scanner sc = new Scanner(System.in);


    public void printMessage(String message){

        System.out.println(message);
    }
    public String getInputString(){

        return sc.nextLine();
}
    public int getInputInt(){

        return sc.nextInt();
}
}
