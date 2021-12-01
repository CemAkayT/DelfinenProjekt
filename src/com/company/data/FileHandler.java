package com.company.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    File membersList = new File("src/com/company/data/memberlist.csv");
    ArrayList<String> listOfMembers = new ArrayList<>();

    //try to read list of members file
    public void readListOfMembers() {
        String line;
        //String data;
        try {
            Scanner input = new Scanner(membersList);
            while (input.hasNext()) {
                line = input.nextLine();
                listOfMembers.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(membersList + " not found");
        }
        outputListOfMembers();
    }

    //try to write list of members file
    public void writeListOfMembers() {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/memberlisttest.csv", false));
                if (listOfMembers == null) {
                    System.out.println("No members to save");
                } else {
                    for (String member : listOfMembers) {
                        ps.println(member);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputListOfMembers() {
        for (String line : listOfMembers) {
            //Member member = new Member(line); //conflict in member constructor
            String[] lineData = line.split(";");
            for (String d : lineData) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}