package com.company.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private File membersList = new File("src/com/company/data/memberlisttest.csv");
    private File teamsList = new File("src/com/company/data/teamlist.csv");
    private ArrayList<String> listOfMembers = new ArrayList<>();
    private ArrayList<String> listOfTeams = new ArrayList<>();

    //try to read list of members file
    public ArrayList<String> readListOfMembers() {
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
        //outputListOfMembers();
        return listOfMembers;
    }

    //try to write list of members file
    public void writeListOfMembers(ArrayList<String> list) {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/memberlisttest.csv", false));
                if (list == null) {
                    System.out.println("No members to save");
                } else {
                    for (String member : list) {
                        ps.println(member);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
    }
}