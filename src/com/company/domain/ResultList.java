package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ResultList {
    private ArrayList<TrainingResult> trainingBestResultListButterfly = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListCrawl = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListBackcrawl = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListBreaststroke = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListButterfly = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListCrawl = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListBackcrawl = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListBreaststroke = new ArrayList<>();

    //Create Competitive Results //@Martin Anberg @Graham Heaven

    public void runCreateCompResultButterfly(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String tournament) {
        if (fromFile) {
            competitiveBestResultListButterfly = createCompResultFromFile(resultTime, idNum, resultDate, tournament, competitiveBestResultListButterfly);
        } else {
            competitiveBestResultListButterfly = createCompResult(resultTime, idNum, resultDate, tournament, competitiveBestResultListButterfly);
        }
    }

    public void runCreateCompResultCrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String tournament) {
        if (fromFile) {
            competitiveBestResultListCrawl = createCompResultFromFile(resultTime, idNum, resultDate, tournament, competitiveBestResultListCrawl);
        } else {
            competitiveBestResultListCrawl = createCompResult(resultTime, idNum, resultDate, tournament, competitiveBestResultListCrawl);
        }
    }

    public void runCreateCompResultBackcrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String tournament) {
        if (fromFile) {
            competitiveBestResultListBackcrawl = createCompResultFromFile(resultTime, idNum, resultDate, tournament, competitiveBestResultListBackcrawl);
        } else {
            competitiveBestResultListBackcrawl = createCompResult(resultTime, idNum, resultDate, tournament, competitiveBestResultListBackcrawl);
        }
    }

    public void runCreateCompResultBreaststroke(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String tournament) {
        if (fromFile) {
            competitiveBestResultListBreaststroke = createCompResultFromFile(resultTime, idNum, resultDate, tournament, competitiveBestResultListBreaststroke);
        } else {
            competitiveBestResultListBreaststroke = createCompResult(resultTime, idNum, resultDate, tournament, competitiveBestResultListBreaststroke);
        }
    }
    //@Graham Heaven
    public ArrayList<CompetitionResult> createCompResultFromFile(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<CompetitionResult> competitionResultList) {
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum, resultDate, comment);
        competitionResultList.add(competitionResult);
        return competitionResultList;
    }
    //Create Competitive Result//@Martin Anberg
    public ArrayList<CompetitionResult> createCompResult(double resultTime, String idNum, LocalDate resultDate,String tournament, ArrayList<CompetitionResult> competiveResultList) {
        boolean containsResult = false;
        for (CompetitionResult competitionResult : competiveResultList) {
            if ((competitionResult.getIdNum().equals(idNum))) {
                competitionResult.setDateOfResult(resultDate);
                competitionResult.setResultTime(resultTime);
                containsResult = true;
            }
        }
        if(!containsResult) {
            CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum, resultDate, tournament);
            competiveResultList.add(competitionResult);
            System.out.println("YO RETARD WTF");
        }
        return competiveResultList;
    }

    //Create Training Results //@Martin Anberg @Graham Heaven

    public void runCreateTrainResultButterfly(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment) {
        if (fromFile) {
            trainingBestResultListButterfly = createTrainResultFromFile(resultTime, idNum, resultDate, comment, trainingBestResultListButterfly);
        } else {
            trainingBestResultListButterfly = createTrainResult(resultTime, idNum, resultDate, comment, trainingBestResultListButterfly);
        }
    }

    public void runCreateTrainResultCrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment) {
        if (fromFile) {
            trainingBestResultListCrawl = createTrainResultFromFile(resultTime, idNum, resultDate, comment, trainingBestResultListCrawl);
        } else {
            trainingBestResultListCrawl = createTrainResult(resultTime, idNum, resultDate, comment, trainingBestResultListCrawl);
        }
    }

    public void runCreateTrainResultBackcrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment) {
        if (fromFile) {
            trainingBestResultListBackcrawl = createTrainResultFromFile(resultTime, idNum, resultDate, comment, trainingBestResultListBackcrawl);
        } else {
            trainingBestResultListBackcrawl = createTrainResult(resultTime, idNum, resultDate, comment, trainingBestResultListBackcrawl);
        }
    }

    public void runCreateTrainResultBreaststroke(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment) {
        if (fromFile) {
            trainingBestResultListBreaststroke = createTrainResultFromFile(resultTime, idNum, resultDate, comment, trainingBestResultListBreaststroke);
        } else {
            trainingBestResultListBreaststroke = createTrainResult(resultTime, idNum, resultDate, comment, trainingBestResultListBreaststroke);
        }
    }

    //@Graham Heaven
    public ArrayList<TrainingResult> createTrainResultFromFile(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate, comment);
        trainingResultList.add(trainingResult);
        return trainingResultList;
    }
//Create Training Result//@Martin Anberg
    public ArrayList<TrainingResult> createTrainResult(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        boolean containsResult = false;
        for (TrainingResult trainingResult : trainingResultList) {
            if ((trainingResult.getIdNum().equals(idNum))) {
                trainingResult.setDateOfResult(resultDate);
                trainingResult.setResultTime(resultTime);
                containsResult = true;
            }
        }
        if(!containsResult) {
            TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate,comment);
            trainingResultList.add(trainingResult);
            System.out.println("YO RETARD WTF");
        }
        return trainingResultList;
    }
    //TOP 5 COMPETITIVE //@Martin Anberg

    public String showTop5CompResultsButterfly() {
        return Top5CompResults(competitiveBestResultListButterfly);
    }

    public String showTop5CompResultsCrawl() {
        return Top5CompResults(competitiveBestResultListButterfly);
    }

    public String showTop5CompResultsBackcrawl() {
        return Top5CompResults(competitiveBestResultListButterfly);
    }

    public String showTop5CompResultsBreaststroke() {
        return Top5CompResults(competitiveBestResultListButterfly);
    }

    
    public String Top5CompResults(ArrayList<CompetitionResult> competitionBestResultList){
        String s ="";
        int i = 1;
        Collections.sort(competitionBestResultList);
        for (CompetitionResult competitionResult : competitionBestResultList){
            s = s+i+". BEDSTE TID ER   "+competitionResult.getResultTime()+"\nAF   "+competitionResult.getIdNum()+"\n";
            i++;
            if (i == 5){return s;}
        }
        return s;
    }
    //TOP 5 TRAINING
    public String showTop5TrainResultsButterfly() {
        return Top5TrainResults(trainingBestResultListButterfly);
    }

    public String showTop5TrainResultsCrawl() {
        return Top5TrainResults(trainingBestResultListCrawl);
    }

    public String showTop5TrainResultsBackcrawl() {
        return Top5TrainResults(trainingBestResultListBackcrawl);
    }

    public String showTop5TrainResultsBreaststroke() {
        return Top5TrainResults(trainingBestResultListBreaststroke);
    }

    public String Top5TrainResults(ArrayList<TrainingResult> trainingBestResultList){
        String s ="";
        int i = 1;
        Collections.sort(trainingBestResultList);
        for (TrainingResult trainingResult : trainingBestResultList){
            s = s+i+". BEDSTE TID ER   "+trainingResult.getResultTime()+"\nAF   "+trainingResult.getIdNum()+"\n";
            i++;
            if (i == 5){return s;}
        }
        return s;
    }

    //FIND MEMBER RESULT COMPETITIVE //@MartinAnberg
    public String memberCompetitiveButterfly(String idNum) {
        for (Result result : competitiveBestResultListButterfly) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    public String memberCompetitiveCrawl(String idNum) {
        for (Result result : competitiveBestResultListCrawl) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    public String memberCompetitiveBackcrawl(String idNum) {
        for (Result result : competitiveBestResultListBackcrawl) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    public String memberCompetitiveBreaststroke(String idNum) {
        for (Result result : competitiveBestResultListBreaststroke) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    //FIND MEMBER RESULT TRAINING //@MartinAnberg
    public double memberTrainingButterfly(String idNum) {
        double bestTime = 0;
        for (Result result : trainingBestResultListButterfly) {
            if (idNum.equals(result.getIdNum())) {
                bestTime = result.getResultTime();
            }
        }
        return bestTime;
    }

    public String memberTrainingCrawl(String idNum) {
        for (Result result : trainingBestResultListCrawl) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    public String memberTrainingBackcrawl(String idNum) {
        for (Result result : trainingBestResultListBackcrawl) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    public String memberTrainingBreaststroke(String idNum) {
        for (Result result : trainingBestResultListBreaststroke) {
            if (idNum.equals(result.getIdNum())) {
                return "" + result.getResultTime();
            }
        }
        return "INGEN TID";
    }

    //@Graham Heaven
    public ArrayList<TrainingResult> getTrainingBestResultListButterfly() {
        return trainingBestResultListButterfly;
    }

    //@Graham Heaven
    public ArrayList<TrainingResult> getTrainingBestResultListCrawl() {
        return trainingBestResultListCrawl;
    }

    //@Graham Heaven
    public ArrayList<TrainingResult> getTrainingBestResultListBackcrawl() {
        return trainingBestResultListBackcrawl;
    }

    //@Graham Heaven
    public ArrayList<TrainingResult> getTrainingBestResultListBreaststroke() {
        return trainingBestResultListBreaststroke;
    }

    //@Graham Heaven
    public ArrayList<CompetitionResult> getCompetitiveBestResultListButterfly() {
        return competitiveBestResultListButterfly;
    }

    //@Graham Heaven
    public ArrayList<CompetitionResult> getCompetitiveBestResultListCrawl() {
        return competitiveBestResultListCrawl;
    }

    //@Graham Heaven
    public ArrayList<CompetitionResult> getCompetitiveBestResultListBackcrawl() {
        return competitiveBestResultListBackcrawl;
    }

    //@Graham Heaven
    public ArrayList<CompetitionResult> getCompetitiveBestResultListBreaststroke() {
        return competitiveBestResultListBreaststroke;
    }

    // @Graham Heaven
    public ArrayList<String> trainingResultsListToString(ArrayList<TrainingResult> results) {
        ArrayList<String> listOfResults = new ArrayList<>();
        String resultData;
        for (TrainingResult r : results) {
            resultData = r.buildStringForCSV() + r.getComment() + ";";
            listOfResults.add(resultData);
        }
        return listOfResults;
    }

    // @Graham Heaven
    public ArrayList<String> competitionResultsListToString(ArrayList<CompetitionResult> results) {
        ArrayList<String> listOfResults = new ArrayList<>();
        String resultData;
        for (CompetitionResult r : results) {
            resultData = r.buildStringForCSV() + r.getTournament() + ";";
            listOfResults.add(resultData);
        }
        return listOfResults;
    }
}



