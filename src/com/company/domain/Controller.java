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
            UI.printMessage("VELKOMMEN TIL DELFINNEN!" +
                    "\n");
            while(active){
                UI.printMessage("vælg funktion" +
                        "\n1. opret medlem" +
                        "\n2. slet medlem" +
                        "\n3. rediger medlem" +
                        "\n4. medlemsliste" +
                        "\n5. restanceliste" +
                        "\n6. budget" +
                        "\n7. " +
                        "\n8. " +
                        "\n9. ");
                choice = UI.getInputString().toLowerCase();
                switch (choice) {

                    //Chairman Use Case
                    case "opret medlem","1" :
                        memberCreation(choice);
                        break;

                    case "slet medlem","2" :
                        memberDeletion();
                        break;

                    case "rediger medlem","3" :
                        memberEditing(choice);
                        break;

                    case "medlemsliste","4" :
                        memberList.showMembers();
                        break;
                    //Casher Use case

                    case "restanceliste","5" :
                        UI.printMessage("LISTE AF MEDLEMMER I RESTANCE");
                        memberList.arrearslist();
                        break;

                    case "budget","6" :
                        UI.printMessage("TOTAL KONTINGENT");
                        UI.printDouble(memberList.showIncome());

                        break;


                    default:
                        UI.printMessage("Der skete en fejl, prøv noget igen.");
                        break;

                }
            }
        }

    private void memberEditing(String choice) {
        memberList.showMembers();
        UI.printMessage("Skriv medlems ID for at redigere medlem");
        String idNumEdit = UI.getInputString();
        boolean editActive = true;
        while(editActive) {
            UI.printMessage("Skriv nu hvad der skal redigeres" +
                    "\n 1. medlems navn" +
                    "\n 2. medlems svømme status" +
                    "\n 3. medlems kontigent" +
                    "\n 4. medlems træner(hvis medlem er konkurenccesvømmer)" +
                    "\n 5. medlems aktiv/passiv" +
                    "\n . afslut redigering");
            choice = UI.getInputString().toLowerCase();
            switch (choice) {
                case "navn", "1":
                    UI.printMessage("Skriv nyt navn");
                String memberName = UI.getInputString();
                    memberList.editMemberName(idNumEdit, memberName);
                    break;

                case "svømmerstatus", "2":
                    memberList.editMemberStatus(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til "+memberList.memberSwimmerStatus(idNumEdit));
                    if(memberList.memberSwimmerStatus(idNumEdit) == true)
                    {UI.printMessage("Husk at tilføj træner");}
                    break;
                case "kontingent", "3":
                    memberList.editMemberArrears(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til "+memberList.memberArrearsStatus(idNumEdit));
                    break;
                case "træner", "4":
                    if(memberList.memberSwimmerStatus(idNumEdit) == true) {
                        UI.printMessage("Skriv ny træner navn");
                        String trainerName = UI.getInputString();
                        memberList.editMemberTrainer(idNumEdit,trainerName);
                    } else {UI.printMessage("Dette medlem er ikke konkurenccesvømmer");}
                    break;

                case "aktiv/passiv", "5" :
                    memberList.editActiveStatus(idNumEdit);
                    UI.printMessage("Medlems aktivitets status er nu ændret til "+memberList.memberActiveStatus(idNumEdit));
                break;

                case "afslut", "":
                editActive = false;
                break;

                default: UI.printMessage("Der skete en fejl, prøv noget andet.");

            }
        }
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
        memberList.createMember(name, idNum, dateOfBirth,dateOfMembership,isCompetitive,trainerName);
    }

}




