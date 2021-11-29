package com.company.domain;

import com.company.UI.UserInterface;
import com.company.data.FileHandler;

import java.time.LocalDate;
import java.util.UUID;

public class Controller {
UserInterface UI = new UserInterface();
FileHandler fileHandler = new FileHandler();
MemberList memberList = new MemberList();
TeamList teamList = new TeamList();


    public void run(){

        String choice;
        boolean active = true;

            while(active){
                choice = UI.getInputString().toLowerCase();
                switch (choice) {

                    case "opret medlem" :
                        //memberCreation();
                        UI.printMessage("Skriv navn:");
                        String name = UI.getInputString();
                        UUID idNum = UUID.randomUUID();
                        UI.printMessage("medlem id er "+idNum);
                        UI.printMessage("Skriv fødselsdato år/måned/dag");
                        LocalDate dateOfBirth = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
                        UI.printMessage(dateOfBirth.toString());
                        boolean isCompetitive = false;
                        UI.printMessage("Er medlemmet konkurrencesvømmer?");
                        UI.getInputString();
                        choice = UI.getInputString();
                        if(choice.equals("ja")){
                            isCompetitive = true;
                        }
                        //else{}

                        LocalDate dateOfMembership= LocalDate.now();
                        UI.printMessage(dateOfMembership.toString());
                        String trainerName = null;
                        if(isCompetitive){
                            UI.printMessage("Skriv medlems træner:");
                            trainerName = UI.getInputString();
                        }
                        boolean hasPaid = true;
                        memberList.createMember(name, idNum, dateOfBirth,hasPaid,dateOfMembership,isCompetitive,trainerName);
                        break;

                    case "slet medlem" :
                        break;

                    case "rediger medlem" :
                        break;

                    case "medlemsliste" :
                        memberList.showMembers();
                        break;

                    default:
                        System.out.println("...");
                        break;

                }
            }
        }

    /*private void memberCreation() {
        UI.printMessage("Skriv navn:");
        String name = input.nextLine();
        UUID idNum = UUID.randomUUID();
        UI.printMessage("medlem id er "+idNum);
        UI.printMessage("Skriv fødselsdato år/måned/dag");
        LocalDate dateOfBirth = LocalDate.of(input.nextInt(), input.nextInt(), input.nextInt());
        UI.printMessage(dateOfBirth.toString());
        boolean isCompetitive = false;
        UI.printMessage("Er medlemmet konkurrencesvømmer?");
        choice = input.nextLine();
        if(choice.equals("ja")){
            isCompetitive = true;
        }
        //else{}

        LocalDate dateOfMembership= LocalDate.now();
        UI.printMessage(dateOfMembership.toString());
        String trainerName = null;
        if(isCompetitive){
            UI.printMessage("Skriv medlems træner:");
            trainerName = input.nextLine();
        }
        boolean hasPaid = true;
        memberList.createMember(name, idNum, dateOfBirth,hasPaid,dateOfMembership,isCompetitive,trainerName);
    }*/

}




