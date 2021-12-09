package com.company.data;

import com.company.UI.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//@Graham Heaven
public class FileHandler {

    UserInterface UI = new UserInterface();
    private File membersList = new File("src/com/company/data/memberlist.csv");
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
        UI.printMessage("Medlemsliste indlæst");
        return listOfMembers;
    }

    //try to write list of members file @Graham Heaven
    public void writeListOfMembers(ArrayList<String> list) {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/memberlist.csv", false));
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
        UI.printMessage("Medlemsliste gemt");
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
        UI.printMessage("Holdliste indlæst");
        return listOfTeams;
    }

    //Try to write list of teams file @Graham Heaven
    public void writeListOfTeams(ArrayList<String> list) {
        PrintStream ps;
        {
            try {
                ps = new PrintStream(new FileOutputStream("src/com/company/data/teamlist.csv", false));
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
        UI.printMessage("Holdliste gemt");
    }

    // @Graham Heaven
    public ArrayList<String> readOneTimeFile(String type, String discipline) {
        String fileToRead = "src/com/company/data/" + discipline + "_" + type + ".csv";
        return readRegisteredTimes(fileToRead);
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
    //The data for each of 8 file is stored in an array list
    public void writeRegisteredTimes(ArrayList<String> list, String discipline, String type) {
        PrintStream ps;
        {
            try {
                String fileName = "src/com/company/data/" + discipline + "_" + type + ".csv";
                ps = new PrintStream(new FileOutputStream(fileName, false));
                if (list == null) {
                    UI.printMessage("No results to save");
                } else {
                    for (String result : list) {
                        ps.println(result);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}