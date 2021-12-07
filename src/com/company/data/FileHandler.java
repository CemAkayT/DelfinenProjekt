package com.company.data;

import com.company.UI.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//@Graham Heaven
public class FileHandler {

    UserInterface UI = new UserInterface();
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
            UI.printMessage(membersList + " not found");
        }
        UI.printMessage("Members List loaded");
        return listOfMembers;
    }

    //try to write list of members file @Graham Heaven
    public void writeListOfMembers(ArrayList<String> list) {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/memberlisttest.csv", false));
                if (list == null) {
                    UI.printMessage("No members to save");
                } else {
                    for (String member : list) {
                        ps.println(member);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        UI.printMessage("Members List saved");
    }

    //try to read list of teams file @Graham Heaven
    public ArrayList<String> readListOfTeams() {
        String line;
        try {
            Scanner input = new Scanner(teamsList);
            while (input.hasNext()) {
                line = input.nextLine();
                listOfTeams.add(line);
            }
        } catch (FileNotFoundException e) {
            UI.printMessage(teamsList + " not found");
        }
        UI.printMessage("Teams List loaded");
        return listOfTeams;
    }

    //Try to write list of teams file @Graham Heaven
    public void writeListOfTeams(ArrayList<String> list) {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/teamlisttest.csv", false));
                if (list == null) {
                    UI.printMessage("No teams to save");
                } else {
                    for (String team : list) {
                        ps.println(team);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        UI.printMessage("Teams List saved");
    }

    // @Graham Heaven
    public void readAllTimeFiles() {
        String[] resultTypes = {"training", "competition"};
        String[] fileNames = {"butterfly", "breaststroke", "crawl", "backcrawl"};
        for (String resultType : resultTypes) {
            for (String fileName : fileNames) {
                readOneTimeFile(resultType, fileName);
                // todo: for each line in each file create the appropriate Result object and add to ResultList.
            }
        }
        UI.printMessage("Results lists loaded");
    }

    // @Graham Heaven
    public void readOneTimeFile(String type, String discipline) {
        String fileToRead = "src/com/company/data/" + discipline + "_" + type + ".csv";
        ArrayList<String> resultTimes = readRegisteredTimes(fileToRead);
        System.out.println(resultTimes); // test
    }

    // Try to read registered times from file @Graham Heaven
    public ArrayList<String> readRegisteredTimes(String fileName) {
        File resultsList = new File(fileName);
        ArrayList<String> listOfResults = new ArrayList<>();
        // Try to load results for one of the training files
        String line;
        try {
            Scanner input = new Scanner(resultsList);
            while (input.hasNext()) {
                line = input.nextLine();
                listOfResults.add(line);
            }
        } catch (FileNotFoundException e) {
            UI.printMessage(fileName + " not found");
        }
        return listOfResults;
    }

    // Try to write registered times to file @Graham Heaven
    public void writeRegisteredTimes() {

    }
}