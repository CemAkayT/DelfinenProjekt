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

                    //Chairman Use Case
                    case "opret medlem" :
                        memberCreation(choice);
                        break;

                    case "slet medlem" :
                        memberDeletion();
                        break;

                    case "rediger medlem" :
                        memberEditing();
                        break;

                    case "medlemsliste" :
                        memberList.showMembers();
                        break;
                    //Casher Use case

                    case "" :


                    default:
                        System.out.println("Der skete en fejl, prøv noget igen.");
                        break;

                }
            }
        }

    private void memberEditing() {
        memberList.showMembers();
        UI.printMessage("Skriv medlems ID for at redigere medlem");
        String idNumEdit = UI.getInputString();
        memberList.editMember(idNumEdit);
    }

    private void memberDeletion() {
        memberList.showMembers();
        UI.printMessage("Skriv medlems ID for at slette medlem");
        String idNumDelete = UI.getInputString();
        memberList.deleteMember(idNumDelete);
    }

    private void memberCreation(String choice) {
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
        LocalDate dateOfMembership= LocalDate.now();
        UI.printMessage(dateOfMembership.toString());
        String trainerName = null;
        if(isCompetitive){
            UI.printMessage("Skriv medlems træner:");
            trainerName = UI.getInputString();
        }
        boolean hasPaid = true;
        memberList.createMember(name, idNum, dateOfBirth,hasPaid,dateOfMembership,isCompetitive,trainerName);
    }

}




