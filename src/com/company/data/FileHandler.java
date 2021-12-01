package com.company.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private File membersList = new File("src/com/company/data/memberlist.csv");
    private File teamsList = new File("src/com/company/data/teamlist.csv");
    private ArrayList<String> listOfMembers = new ArrayList<>();
    private ArrayList<String> listOfTeams = new ArrayList<>();

    //try to read list of members file
    public void readListOfMembers() {
        String line;
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

    //try to read list of teams file
    public void readListOfTeams() {
        String line;
        try {
            Scanner input = new Scanner(teamsList);
            while (input.hasNext()) {
                line = input.nextLine();
                listOfTeams.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(teamsList + " not found");
        }
        for (String newline : listOfTeams) {
            String[] lineData = newline.split(";");
            for (String d : lineData) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }


}