package com.company.domain;

import com.company.UI.UserInterface;
import com.company.data.FileHandler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Controller {
    UserInterface UI = new UserInterface();
    FileHandler fh = new FileHandler();
    MemberList memberList = new MemberList();
    TeamList teamList = new TeamList();
    ResultList resultList = new ResultList();
    double resultTime;


    public void start() {

        // Try to load Members, Teams from file.
        openFiles();

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

    // @Graham Heaven
    private boolean openFiles() {
        ArrayList<String> listOfMembers = fh.readListOfMembers();
        memberCreationFromFile(listOfMembers);
        ArrayList<String> listOfTeams = fh.readListOfTeams();
        teamCreationFromFile(listOfTeams);
        resultsCreationFromFiles();
        return true;
    }

    // @Graham Heaven
    private boolean closeFiles() {
        ArrayList<String> mList = memberList.membersListToString();
        fh.writeListOfMembers(mList);
        ArrayList<String> tList = teamList.teamsListToString();
        fh.writeListOfTeams(tList);
        return false;
    }

    // @Graham Heaven
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
                    5. Søg efter medlem via ID
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(5);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> memberCreation();
                case 2 -> memberDeletion();
                case 3 -> memberEditing();
                case 4 -> UI.printMessage(memberList.showMembers());
                case 5 -> runSearchMemberByID();
            }
        }
    }

    private void runSearchMemberByID() {
        UI.getInputString();
        UI.printMessage("Skriv ID");
        String idNum = UI.getInputString();
        UI.printMessage(memberList.searchMemberByIdNum(idNum));
    }

    // @Graham Heaven
    private void accountMenu() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Kontigent menu - Vælg funktion:
                    1. Se restance liste
                    2. Se kontingent til dato
                    3. Se medlemsliste med kontingent
                                        
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(3);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> {
                    UI.printMessage("LISTE AF MEDLEMMER I RESTANCE: " + "\n");
                    UI.printMessage(memberList.arrearsList());
                }
                case 2 -> {
                    UI.printMessage("TOTAL KONTINGENT: ");
                    UI.printMessage(memberList.showIncome());
                }
                case 3 -> {
                    UI.printMessage("LISTE AF MEDLEMMERS KONTINGENT");
                    UI.printMessage(memberList.memberPaymentList());
                }
            }
        }
    }

    // @Graham Heaven
    private void trainingMenu() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Træning menu - Vælg funktion:
                    1. Opret hold
                    2. Slet hold
                    3. Redigere hold
                    4. Registrering(Træning)
                    5. Registrering(Konkurence)
                    6. TOP 5 svømmere
                    7. Søg efter medlem via ID
                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(7);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> teamCreation();
                case 2 -> teamDeletion();
                //case 3 -> teamEditing();
                case 4 -> registerTraining();
                case 5 -> registerCompetitive();
                case 6 -> top5Swimmers();
                case 7 -> runSearchMemberByID();
            }
        }
    }

    private void top5Swimmers() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Træning menu - Vælg funktion:
                    1. Butterfly(Konkurence)
                    2. Crawl(Konkurence)
                    3. Backcrawl(Konkurence)
                    4. Brystsvømning(Konkurence)
                    5. Butterfly(Træning)
                    6. Crawl(Træning)
                    7. Backcrawl(Træning)
                    8. Brystsvømning(Træning)
                                        
                    0. Tilbage til tidligere menu
                    """);
            choice = UI.getValidInt(8);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> UI.printMessage(resultList.showTop5CompResultsButterfly());
                case 2 -> UI.printMessage(resultList.showTop5CompResultsCrawl());
                case 3 -> UI.printMessage(resultList.showTop5CompResultsBackcrawl());
                case 4 -> UI.printMessage(resultList.showTop5CompResultsBreaststroke());
                case 5 -> UI.printMessage(resultList.showTop5TrainResultsButterfly());
                case 6 -> UI.printMessage(resultList.showTop5TrainResultsCrawl());
                case 7 -> UI.printMessage(resultList.showTop5TrainResultsBackcrawl());
                case 8 -> UI.printMessage(resultList.showTop5TrainResultsBreaststroke());
            }
        }
    }

    private void registerCompetitive() {
        int choice;
        UI.printMessage("""
                Vælg funktion:
                1. Registrer butterfly(Konkurence)
                2. Registrer crawl(Konkurence)
                3. Registrer rygcrawl(Konkurence)
                4. Registrer brystsvømning(Konkurence)
                                                   
                0. Tilbage til hoved menu
                """);
        choice = UI.getInputInt();
        switch (choice) {
            case 1 -> registerCompetitiveButterfly();
            case 2 -> registerCompetitiveCrawl();
            case 3 -> registerCompetitiveBackcrawl();
            case 4 -> registerCompetitiveBreaststroke();
        }
    }

    private void registerCompetitiveButterfly() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberCompetitiveButterfly(idNum));
        UI.printMessage("Vil du ændre den? skriv ja eller nej");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv stævne");
            String tournament = UI.getInputString();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateCompResultButterfly(time, idNum, resultDate, tournament);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerCompetitiveCrawl() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberCompetitiveCrawl(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv stævne");
            String tournament = UI.getInputString();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateCompResultCrawl(time, idNum, resultDate, tournament);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerCompetitiveBackcrawl() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberCompetitiveBackcrawl(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv stævne");
            String tournament = UI.getInputString();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateCompResultBackcrawl(time, idNum, resultDate, tournament);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerCompetitiveBreaststroke() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberCompetitiveBreaststroke(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv stævne");
            String tournament = UI.getInputString();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateCompResultBreaststroke(time, idNum, resultDate, tournament);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }


    private void registerTraining() {
        int choice;
        boolean running = true;
        while (running) {
            UI.printMessage("""
                    Vælg funktion:
                    1. Registrer butterfly(Træning)
                    2. Registrer crawl(Træning)
                    3. Registrer rygcrawl(Træning)
                    4. Registrer brystsvømning(Træning)
                                                        
                    0. Tilbage til hoved menu
                    """);
            choice = UI.getValidInt(4);
            switch (choice) {
                case 0 -> running = false;
                case 1 -> registerTrainingButterfly();
                case 2 -> registerTrainingCrawl();
                case 3 -> registerTrainingBackcrawl();
                case 4 -> registerTrainingBreaststroke();
            }
        }
    }

    private void registerTrainingButterfly() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberTrainingButterfly(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateTrainResultButterfly(time, idNum, resultDate, "");
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerTrainingCrawl() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberTrainingCrawl(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateTrainResultCrawl(time, idNum, resultDate);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerTrainingBackcrawl() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberTrainingBackcrawl(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateTrainResultBackcrawl(time, idNum, resultDate);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void registerTrainingBreaststroke() {
        //@Martin Anberg
        UI.printMessage(memberList.CompetitiveList());
        UI.printMessage("Skriv medlems ID");
        String idNum = UI.getInputString();
        UI.printMessage("Svømmerens nuværende bedste tid er: " + resultList.memberTrainingBreaststroke(idNum));
        UI.printMessage("Vil du ændre den?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
            UI.printMessage("Skriv ny tid");
            double time = UI.getInputDouble();
            UI.printMessage("Skriv dato år/måned/dag");
            LocalDate resultDate = LocalDate.of(UI.getInputInt(), UI.getInputInt(), UI.getInputInt());
            resultList.runCreateTrainResultBreaststroke(time, idNum, resultDate);
        } else {
            UI.printMessage("tiden blevet ikke ændret");
        }
    }

    private void teamDeletion() {
        teamList.listOfTeams();
        UI.printMessage("Skriv navn på holdet");
        String teamName = UI.getInputString();
        UI.getInputString();
        UI.printMessage("Er du sikker på at du vil slette " + teamName + "?");
        String choice = UI.getInputString();
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
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
        //@Martin Anberg
        UI.printMessage(memberList.showMembers());
        UI.printMessage("Skriv medlemmets ID for at redigere medlem: ");
        String idNumEdit = UI.getInputString();
        boolean editActive = true;
        while (editActive) {
            UI.printMessage("""
                    Vælg funktion:
                    1. Medlemmets fornavn
                    2. Medlemmets mellemnavn
                    3. Medlemmets efternavn
                    4. Medlemmets svømmestatus
                    5. Medlemmets kontingent
                    6. Medlems træner(hvis medlem er konkurencesvømmer)  
                    7. Ændre aktiv/passiv status  
                                                        
                    0. Tilbage til hoved menu
                    """);
            int choice = UI.getValidInt(7);
            switch (choice) {
                case 1 -> {
                    UI.printMessage("Skriv nyt fornavn: ");
                    String memberName = UI.getInputString();
                    memberList.editMemberName(idNumEdit, memberName);
                }
                case 2 -> {
                    UI.printMessage("Skriv nyt mellemnavn: ");
                    String memberMiddleName = UI.getInputString();
                    memberList.editMemberMiddleName(idNumEdit, memberMiddleName);
                }
                case 3 -> {
                    UI.printMessage("Skriv nyt efternavn: ");
                    String memberLastName = UI.getInputString();
                    memberList.editMemberLastName(idNumEdit, memberLastName);
                }
                case 4 -> {
                    memberList.editMemberStatus(idNumEdit);
                    UI.printMessage("Medlems svømmestatus er nu ændret til " + memberList.memberSwimmerStatus(idNumEdit));
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Husk at tilføje træner");
                    }
                }

                case 5 -> {
                    memberList.editMemberArrears(idNumEdit);
                    UI.printMessage("Medlems restance status er nu ændret til " + memberList.memberArrearsStatus(idNumEdit));
                }

                case 6 -> {
                    if (memberList.memberSwimmerStatus(idNumEdit)) {
                        UI.printMessage("Skriv nyt navn på træner");
                        String trainerName = UI.getInputString();
                        memberList.editMemberTrainer(idNumEdit, trainerName);
                    } else {
                        UI.printMessage("Dette medlem er ikke konkurrencesvømmer");// ??
                    }
                }


                case 7 -> {
                    memberList.editActiveStatus(idNumEdit);
                    UI.printMessage("Medlemmets aktivitetsstatus er nu ændret til " + memberList.memberActiveStatus(idNumEdit));
                }

                case 0 -> editActive = false;

            }
        }
    }

    private void memberDeletion() {
        //@Martin Anberg
        UI.printMessage(memberList.showMembers());
        UI.printMessage("Skriv medlemmets ID for at slette medlem");
        String idNumDelete = UI.getInputString();
        UI.getInputString();
        memberList.deleteMember(idNumDelete);
        UI.printMessage("Medlem slettet" + "\n");
    }

    private void memberCreation() {
        //@Martin Anberg
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
        if (choice.equals("ja") || choice.equals("Ja") || choice.equals("JA")) {
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

    // @Graham Heaven
    private void memberCreationFromFile(ArrayList<String> list) {
        memberList.createMember(list);
    }

    // @Graham Heaven
    private void teamCreationFromFile(ArrayList<String> list) {
        for (String s : list) {
            ArrayList<Member> listOfMembers = new ArrayList<>();
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

    // @Graham Heaven
    private void resultsCreationFromFiles() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<String> listOfResultsFromOneFile;
        String[] resultTypes = {"training", "competition"};
        String[] fileNames = {"butterfly", "breaststroke", "crawl", "backcrawl"};
        for (String resultType : resultTypes) {
            for (String fileName : fileNames) {
                listOfResultsFromOneFile = fh.readOneTimeFile(resultType, fileName);
                // todo: for each line in each file create the appropriate Result object and add to ResultList.
                System.out.println(listOfResultsFromOneFile); // test
                if (resultType.equals("training") && fileName.equals("butterfly")) {
                    for (String s : listOfResultsFromOneFile) {
                        String[] lineData = s.split(";");
                        System.out.println(s);
                        String idNum = lineData[0];
                        LocalDate dateOfresult = LocalDate.parse(lineData[1], formatter);
                        //double resultTime = Double.parseDouble(lineData[2]);
                        //System.out.println(resultTime);
                        double resultTime = 44.44;
                        /*try {
                           resultTime = NumberFormat.getInstance(Locale.getDefault()).parse(lineData[2]).doubleValue();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }*/
                        String tekst = lineData[3];
                        resultList.runCreateTrainResultButterfly(resultTime, idNum, dateOfresult, tekst);
                    }
                }

            }
        }
        UI.printMessage("Results lists loaded");
    }
}