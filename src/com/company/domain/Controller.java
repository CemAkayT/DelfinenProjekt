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


    public void run() {

        String choice;
        UI.printMessage("VELKOMMEN TIL DELFINEN! \uD83D\uDC2C" +
                "\n");
        while (true) {
            UI.printMessage("Vælg funktion:" +
                    "\n1. opret medlem" +
                    "\n2. slet medlem" +
                    "\n3. rediger medlem" +
                    "\n4. se medlemsliste" +
                    "\n5. se restance liste" +
                    "\n6. se kontingent til dato" +
                    "\n7. opret hold" +
                    "\n8. slet hold" +
                    "\n9. ");
            choice = UI.getInputString().toLowerCase();
            switch (choice) {
                case "opret medlem", "1" -> memberCreation();
                case "slet medlem", "2" -> memberDeletion();
                case "rediger medlem", "3" -> memberEditing();
                case "se medlemsliste", "4" -> memberList.showMembers();
                case "se restance liste", "5" -> {
                    UI.printMessage("LISTE AF MEDLEMMER I RESTANCE: "+"\n");
                    memberList.arrearsList();
                }
                case "kontingent", "6" -> {
                    UI.printMessage("TOTAL KONTINGENT: ");
                    UI.printDouble(memberList.showIncome());
                    UI.printMessage("");
                }
                case "opret hold", "7"-> {
                    teamCreation();
                }
                case "slet hold", "8"->{

                }
                default -> UI.printMessage("Hov der skete en fejl, prøv igen.");
            }
        }
    }

    private void teamCreation() {
        UI.printMessage("Skriv navn på holdet");
        String teamName = UI.getInputString();
        UI.printMessage("Er det et juniorhold?");
        String choice = UI.getInputString();
        boolean isJunior;
        isJunior = choice.equals("ja");
        teamList.createTeam(teamName,isJunior);

    }

    private void memberEditing() {
        memberList.showMembers();
        UI.printMessage("Skriv medlemmets ID for at redigere medlem: ");
        String idNumEdit = UI.getInputString();
        boolean editActive = true;
        while (editActive) {
            UI.printMessage("Hvad skal redigeres? " +
                    "\n1. medlemmets navn" +
                    "\n2. medlemmets mellemnavn" +
                    "\n3. medlemmets efternavn" +
                    "\n4. medlemmets svømmestatus" +
                    "\n5. medlemmets kontingent" +
                    "\n6. medlems træner(hvis medlem er konkurrencesvømmer)" +
                    "\n7. ændre aktiv/passiv status" +
                    "\n8. afslut redigering");
            String choice = UI.getInputString().toLowerCase();
            switch (choice) {
                case "navn", "1" -> {
                    UI.printMessage("Skriv nyt navn: ");
                    String memberName = UI.getInputString();
                    memberList.editMemberName(idNumEdit, memberName);
                }
                case "mellemnavn", "2" -> {
                    UI.printMessage("Skriv nyt mellemnavn: ");
                    String memberMiddleName = UI.getInputString();
                    memberList.editMemberMiddleName(idNumEdit, memberMiddleName);
                }
                case "efternavn", "3"-> {
                    UI.printMessage("Skriv nyt efternavn: ");
                    String memberLastName = UI.getInputString();
                    memberList.editMemberLastName(idNumEdit, memberLastName);
                }
                case "svømmerstatus", "4"-> {
                    memberList.editMemberStatus(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til " + memberList.memberSwimmerStatus(idNumEdit));
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Husk at tilføje træner");
                    }
                }

                case "kontingent", "5"-> {
                    memberList.editMemberArrears(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til " + memberList.memberArrearsStatus(idNumEdit));
                }

                case "træner", "6"-> {
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Skriv nyt navn på træner");
                        String trainerName = UI.getInputString();
                        memberList.editMemberTrainer(idNumEdit, trainerName);
                    } else {
                        UI.printMessage("Dette medlem er ikke konkurrencesvømmer");// ??
                    }
                }


                case "aktiv/passiv", "7"-> {
                    memberList.editActiveStatus(idNumEdit);
                    UI.printMessage("Medlemmets aktivitetsstatus er nu ændret til " + memberList.memberActiveStatus(idNumEdit));
                }

                case "afslut", "8"-> editActive = false;


                default-> UI.printMessage("Der skete en fejl, prøv noget andet.");
            }
        }
    }
    private void memberDeletion() {
        memberList.showMembers();
        UI.printMessage("Skriv medlemmets ID for at slette medlem");
        String idNumDelete = UI.getInputString();
        memberList.deleteMember(idNumDelete);
        UI.printMessage("Medlem slettet"+"\n");
    }

    private void memberCreation() {
        UI.printMessage("Skriv navn: ");
        String name = UI.getInputString();
        UI.printMessage("Skriv mellemnavn: ");
        String middleName = UI.getInputString();
        UI.printMessage("Skriv efternavn: ");
        String lastName = UI.getInputString();
        UUID idNum = UUID.randomUUID();
        UI.printMessage("\n" + "Medlemmets ID er: " + idNum + "\n");
        UI.printMessage("Skriv fødselsdato år/måned/dag: ");
        LocalDate dateOfBirth = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
        UI.printMessage("Medlemmets fødselsdato: " + dateOfBirth + "\n");

        UI.printMessage("Vil medlem deltage i konkurrencer? ");
        UI.getInputString();
        String choice = UI.getInputString();
        if (choice.equals("ja")) {
            UI.printMessage("Hvem bliver medlemmets træner? ");
            String trainerName = UI.getInputString();
            LocalDate dateOfMembership = LocalDate.now();
            UI.printMessage("Medlem oprettet: " + dateOfMembership + "\n");
            memberList.createMember(name, middleName, lastName, idNum, dateOfBirth, dateOfMembership, true, trainerName);
        } else {
            LocalDate dateOfMembership = LocalDate.now();
            UI.printMessage("Medlem oprettet: " + dateOfMembership + "\n");
            memberList.createMember(name,middleName, lastName, idNum, dateOfBirth, dateOfMembership, false, null);
        }
    }
}




