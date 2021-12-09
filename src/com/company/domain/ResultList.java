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
    public String comment;

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

    //Create Competitive Result//@Martin Anberg
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

    //Create Training Results //@Martin Anberg

    public void runCreateTrainResultButterfly(double resultTime, String idNum, LocalDate resultDate, String comment){
      trainingBestResultListButterfly = createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListButterfly);
    }

    public void runCreateTrainResultButterflyFromFile(double resultTime, String idNum, LocalDate resultDate, String comment) {
        trainingBestResultListButterfly = createTrainResultFromFile(resultTime,idNum,resultDate,comment, trainingBestResultListButterfly);
    }

    public void runCreateTrainResultCrawl(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListCrawl);
    }
    public void runCreateTrainResultBackcrawl(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListBackcrawl);
    }
    public void runCreateTrainResultBreaststroke(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListBreaststroke);
    }


    public ArrayList<TrainingResult> createTrainResultFromFile(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate, comment);
        trainingResultList.add(trainingResult);
        return trainingResultList;
    }
//Create Training Result//@Martin Anberg
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

    public String Top5CompResults(ArrayList<CompetitionResult> competitionBestResultList){
        String s ="";
        int i = 1;
        Collections.sort(competitionBestResultList);
        for (CompetitionResult competitionResult : competitionBestResultList){
            s = s+i+". BEDSTE TID ER   "+competitionResult.getResultTime()+"\nAF   "+competitionResult.getIdNum()+"\n";
            i++;
        }
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

    public String Top5TrainResults(ArrayList<TrainingResult> trainingBestResultList){
        String s ="";
        int i = 1;
        Collections.sort(trainingBestResultList);
        for (TrainingResult trainingResult : trainingBestResultList){
            s = s+i+". BEDSTE TID ER   "+trainingResult.getResultTime()+"\nAF   "+trainingResult.getIdNum()+"\n";
            i++;
        }
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



