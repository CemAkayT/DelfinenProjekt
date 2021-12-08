package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ResultList {
    private ArrayList<TrainingResult> trainingBestResultListButterfly = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListCrawl = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListBackcrawl = new ArrayList<>();
    private ArrayList<TrainingResult> trainingBestResultListBreaststroke = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListButterfly = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListCrawl = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListBackcrawl = new ArrayList<>();
    private ArrayList<CompetitionResult> competitiveBestResultListBreaststroke = new ArrayList<>();
    //public String comment;

    //Create Competitive Results //@Martin Anberg

    public void runCreateCompResultButterfly(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament, competitiveBestResultListButterfly);
    }
    public void runCreateCompResultCrawl(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament, competitiveBestResultListCrawl);
    }
    public void runCreateCompResultBackcrawl(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament, competitiveBestResultListBackcrawl);
    }
    public void runCreateCompResultBreaststroke(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament, competitiveBestResultListBreaststroke);
    }


    public ArrayList<CompetitionResult> createCompResult(double resultTime, String idNum, LocalDate resultDate,String tournament, ArrayList<CompetitionResult> competiveResultList) {
        for (CompetitionResult competitionResult : competiveResultList) {
            if ((competitionResult.getIdNum().equals(idNum) && competitionResult.getResultTime() > resultTime) || (competitionResult.getIdNum().equals(idNum) && competitionResult.getResultTime() != 0)) {
                competitionResult.setDateOfResult(resultDate);
                competitionResult.setResultTime(resultTime);
            } else {
                CompetitionResult competitionResult2 = new CompetitionResult(resultTime, idNum, resultDate, tournament);
                competiveResultList.add(competitionResult2);
            }

        }
        return competiveResultList;
    }

    //Create Training Results //@Martin Anberg @Graham Heaven

    public void runCreateTrainResultButterfly(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment){
      if (fromFile) {
          trainingBestResultListButterfly = createTrainResultFromFile(resultTime,idNum,resultDate,comment, trainingBestResultListButterfly);
      } else {
          trainingBestResultListButterfly = createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListButterfly);
      }
    }

    public void runCreateTrainResultCrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment){
        createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListCrawl);
    }
    public void runCreateTrainResultBackcrawl(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment){
        createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListBackcrawl);
    }

    public void runCreateTrainResultBreaststroke(boolean fromFile, double resultTime, String idNum, LocalDate resultDate, String comment){
        if (fromFile) {
            trainingBestResultListBreaststroke = createTrainResultFromFile(resultTime,idNum,resultDate,comment, trainingBestResultListBreaststroke);
        } else {
            trainingBestResultListBreaststroke = createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListBreaststroke);
        }
    }


    public ArrayList<TrainingResult> createTrainResultFromFile(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate, comment);
        trainingResultList.add(trainingResult);
        return trainingResultList;
    }

    public ArrayList<TrainingResult> createTrainResult(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        for (TrainingResult trainingResult : trainingResultList) {
            if ((trainingResult.getIdNum().equals(idNum) && trainingResult.getResultTime() > resultTime) || (trainingResult.getIdNum().equals(idNum) && trainingResult.getResultTime() != 0)) {
                trainingResult.setDateOfResult(resultDate);
                trainingResult.setResultTime(resultTime);
            } else {
                TrainingResult trainingResult2 = new TrainingResult(resultTime, idNum, resultDate, comment);
                trainingResultList.add(trainingResult2);
            }
        }
        return trainingResultList;
    }
    //TOP 5 COMPETITIVE //@Martin Anberg

    public String showTop5CompResultsButterfly(){
       return Top5CompResults(competitiveBestResultListButterfly);
    }
    public String showTop5CompResultsCrawl(){
        return Top5CompResults(competitiveBestResultListButterfly);
    }
    public String showTop5CompResultsBackcrawl(){
        return Top5CompResults(competitiveBestResultListButterfly);
    }
    public String showTop5CompResultsBreaststroke(){
        return Top5CompResults(competitiveBestResultListButterfly);
    }

    public String Top5CompResults(ArrayList<CompetitionResult> competitionResultList){
        String s ="";
        if(competitionResultList.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                s = s + i + ". ID:" + competitionResultList.get(i).getIdNum() + " TID:" + competitionResultList.get(i).getResultTime() + " STÆVNE: " + competitionResultList.get(i).getTournament();
            }
        }else{s = "Der ikke fem resultater registreret";}
        return s;
    }

    //TOP 5 TRAINING
    public String showTop5TrainResultsButterfly(){
        return Top5TrainResults(trainingBestResultListButterfly);
    }
    public String showTop5TrainResultsCrawl(){
        return Top5TrainResults(trainingBestResultListCrawl);
    }
    public String showTop5TrainResultsBackcrawl(){
        return Top5TrainResults(trainingBestResultListBackcrawl);
    }
    public String showTop5TrainResultsBreaststroke(){
        return Top5TrainResults(trainingBestResultListBreaststroke);
    }

    public String Top5TrainResults(ArrayList<TrainingResult> trainingResultList){
        String s = "";
        if(trainingResultList.size() >= 5) {
            for (int i = 0; i <= 5; i++) {
                s = s + i + ". ID:" + trainingResultList.get(i).getIdNum() + " TID:" + trainingResultList.get(i).getResultTime();
            }
        }else{s = "Der ikke fem resultater registreret";}
        return s;
    }

    //FIND MEMBER RESULT COMPETITIVE //@MartinAnberg
    public String memberCompetitiveButterfly(String idNum){
        for(Result result : competitiveBestResultListButterfly){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    public String memberCompetitiveCrawl(String idNum){
        for(Result result : competitiveBestResultListCrawl){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    public String memberCompetitiveBackcrawl(String idNum){
        for(Result result : competitiveBestResultListBackcrawl){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    public String memberCompetitiveBreaststroke(String idNum){
        for(Result result : competitiveBestResultListBreaststroke){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    //FIND MEMBER RESULT TRAINING //@MartinAnberg
    public double memberTrainingButterfly(String idNum){
        double bestTime = 0;
        for(Result result : trainingBestResultListButterfly){
            if (idNum.equals(result.getIdNum())) {
                bestTime = result.getResultTime();
            }
        }
        return bestTime;
    }
    public String memberTrainingCrawl(String idNum){
        for(Result result : trainingBestResultListCrawl){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    public String memberTrainingBackcrawl(String idNum){
        for(Result result : trainingBestResultListBackcrawl){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }
    public String memberTrainingBreaststroke(String idNum){
        for(Result result : trainingBestResultListBreaststroke){
            if(idNum.equals(result.getIdNum())){
                return ""+result.getResultTime();
            }
        }
        return "INGEN TID";
    }

}



