package com.company.domain;

import com.company.UI.UserInterface;
import com.company.data.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Controller {
    UserInterface UI = new UserInterface();
    FileHandler fh = new FileHandler();
    MemberList memberList = new MemberList();
    TeamList teamList = new TeamList();


    public void start() {

        ArrayList<String> listOfMembers = fh.readListOfMembers();
        memberCreationFromFile(listOfMembers);
        ArrayList<String> listOfTeams = fh.readListOfTeams();
        teamCreationFromFile(listOfTeams);
        //teamList.listOfTeams();


        int choice;
        UI.printMessage("\nVELKOMMEN TIL DELFINEN! \uD83D\uDC2C\n");
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Hoved menu - Vælg funktion:
                    1. Medlemmer
                    2. Kontigent
                    3. Træning
                                        
                    0. Afslut
                    """);
            choice = UI.getValidInt(3);
            switch (choice) {
                case 0 -> running = closeFiles();
                case 1 -> membersMenu();
                case 2 -> accountMenu();
                case 3 -> trainingMenu();
            }

        }
    }

    private boolean closeFiles() {
        ArrayList<String> list = memberList.membersListToString();
        fh.writeListOfMembers(list);
        return false;
    }

    private void membersMenu() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Meddlems menu - Vælg funktion:
                    1. Opret medlem
                    2. Slet medlem
                    3. rediger medlem
                    4. Se medlemsliste
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(4);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> memberCreation();
                case 2 -> memberDeletion();
                case 3 -> memberEditing();
                case 4 -> memberList.showMembers();
            }
        }
    }

    private void accountMenu() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Kontigent menu - Vælg funktion:
                    1. Se restance liste
                    2. Se kontingent til dato
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(2);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> {
                    UI.printMessage("LISTE AF MEDLEMMER I RESTANCE: " + "\n");
                    memberList.arrearsList();
                }
                case 2 -> {
                    UI.printMessage("TOTAL KONTINGENT: ");
                    UI.printDouble(memberList.showIncome());
                    UI.printMessage("");
                }
            }
        }
    }

    private void trainingMenu() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Træning menu - Vælg funktion:
                    1. Opret hold
                    2. Slet hold
                    3. Registrering(Træning)
                    4. Registrering(Konkurence)
                    5. TOP 5 svømmerer
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(5);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> teamCreation();
                case 2 -> teamDeletion();
                case 3 -> registerTraining();
                case 4 -> registerCompetitive();
                case 5 -> top5Swimmers();
            }
        }
    }

    private void top5Swimmers() {

    }

    private void registerCompetitive() {
        int choice;
        UI.printMessage("""
                Vælg funktion:
                1. Registrer butterfly(Konkurence)
                2. Registrer crawl(Konkurence)
                3. Registrer rygcrawl(Konkurence)
                4. Registrer brystsvømning(Konkurence)
                5. Registrer stævne(Konkurence)
                                    
                0. Tilbage til hoved menu
                """);
        choice = UI.getInputInt();
        switch (choice) {
            case 1 -> registerCompetitiveButterfly();
            case 2 -> registerCompetitiveCrawl();
            case 3 -> registerCompetitiveBackcrawl();
            case 4 -> registerCompetitiveBreaststroke();
            case 5 -> registerCompetitiveTournament();
        }
    }

    private void registerCompetitiveButterfly() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
    }

    private void registerCompetitiveCrawl() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
    }

    private void registerCompetitiveBackcrawl() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
    }

    private void registerCompetitiveBreaststroke() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
    }

    private void registerCompetitiveTournament() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
    }

    private void registerTraining() {
        int choice;
        UI.printMessage("""
                Vælg funktion:
                1. Registrer butterfly(Konkurence)
                2. Registrer crawl(Konkurence)
                3. Registrer rygcrawl(Konkurence)
                4. Registrer brystsvømning(Konkurence)
                5. Registrer stævne(Konkurence)
                                    
                0. Tilbage til hoved menu
                """);
        choice = UI.getInputInt();
        switch (choice) {
            case 1 -> registerTrainingButterfly();
            case 2 -> registerTrainingCrawl();
            case 3 -> registerTrainingBackcrawl();
            case 4 -> registerTrainingBreaststroke();
        }
    }

    private void registerTrainingButterfly() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
    }

    private void registerTrainingCrawl() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
    }

    private void registerTrainingBackcrawl() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja")) {
            UI.printMessage("Skriv ny tid");
            UI.getInputDouble();

        }
    }

    private void registerTrainingBreaststroke() {
        memberList.CompetitiveList();
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: ");
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
    }

    private void teamDeletion() {
        teamList.listOfTeams();
        UI.printMessage("Skriv navn på holdet");
        String teamName = UI.getInputString();
        UI.getInputString();
        UI.printMessage("Er du sikker på at du vil slette " + teamName + "?");
        String choice = UI.getInputString();
        if (choice.equals("ja")) {
            teamList.deleteTeam(teamName);
        } else {
            UI.printMessage(teamName + " bliver IKKE slette");
        }
    }

    private void teamCreation() {
        UI.printMessage("Skriv navn på holdet");
        String teamName = UI.getInputString();
        UI.getInputString();
        UI.printMessage("Er det et juniorhold?");
        String choice = UI.getInputString();
        boolean isJunior;
        isJunior = choice.equals("ja");
        boolean isDeleteable = false;
        teamList.createTeam(teamName, isJunior, isDeleteable);

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
                case "efternavn", "3" -> {
                    UI.printMessage("Skriv nyt efternavn: ");
                    String memberLastName = UI.getInputString();
                    memberList.editMemberLastName(idNumEdit, memberLastName);
                }
                case "svømmerstatus", "4" -> {
                    memberList.editMemberStatus(idNumEdit);
                    UI.printMessage("Medlems svømmestatus er nu ændret til " + memberList.memberSwimmerStatus(idNumEdit));
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Husk at tilføje træner");
                    }
                }

                case "kontingent", "5" -> {
                    memberList.editMemberArrears(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til " + memberList.memberArrearsStatus(idNumEdit));
                }

                case "træner", "6" -> {
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Skriv nyt navn på træner");
                        String trainerName = UI.getInputString();
                        memberList.editMemberTrainer(idNumEdit, trainerName);
                    } else {
                        UI.printMessage("Dette medlem er ikke konkurrencesvømmer");// ??
                    }
                }


                case "aktiv/passiv", "7" -> {
                    memberList.editActiveStatus(idNumEdit);
                    UI.printMessage("Medlemmets aktivitetsstatus er nu ændret til " + memberList.memberActiveStatus(idNumEdit));
                }

                case "afslut", "8" -> editActive = false;


                default -> UI.printMessage("Der skete en fejl, prøv noget andet.");
            }
        }
    }

    private void memberDeletion() {
        memberList.showMembers();
        UI.printMessage("Skriv medlemmets ID for at slette medlem");
        String idNumDelete = UI.getInputString();
        UI.getInputString();
        memberList.deleteMember(idNumDelete);
        UI.printMessage("Medlem slettet" + "\n");
    }

    private void memberCreation() {
        UI.printMessage("Skriv fornavn: ");
        String name = UI.getInputString();
        UI.getInputString();
        UI.printMessage("Skriv mellemnavn: ");
        String middleName = UI.getInputString();
        UI.printMessage("Skriv efternavn: ");
        String lastName = UI.getInputString();
        String idNum = UUID.randomUUID().toString();
        UI.printMessage("\n" + "Medlemmets ID er: " + idNum + "\n");
        UI.printMessage("Skriv fødselsdato år/måned/dag: ");
        LocalDate dateOfBirth = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
        UI.printMessage("Medlemmets fødselsdato: " + dateOfBirth + "\n");

        UI.printMessage("Vil medlem deltage i konkurrencer? ");
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
            memberList.createMember(name, middleName, lastName, idNum, dateOfBirth, dateOfMembership, false, null);
        }
    }

    private void memberCreationFromFile(ArrayList<String> list) {
        memberList.createMember(list);
    }

    private void teamCreationFromFile(ArrayList<String> list) {
        ArrayList<Member> listOfMembers = new ArrayList<>();
        for (String s : list) {
            String[] lineData = s.split(";");
            String teamName = lineData[0];
            boolean isJunior = (Objects.equals(lineData[1], "true"));
            boolean isDeleteable = (Objects.equals(lineData[2], "true"));
            Member member;
            for (int i = 3; i < lineData.length; i++) {
                member = memberList.getMemberFromUUID(lineData[i]);
                listOfMembers.add(member);
            }
            teamList.createTeam(teamName, isJunior, isDeleteable, listOfMembers);
        }
    }
}