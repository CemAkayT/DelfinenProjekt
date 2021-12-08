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

    public String createCompResult(double resultTime, String idNum, LocalDate resultDate,String tournament, ArrayList<CompetitionResult> competiveResultList){
        for(CompetitionResult competitionresult : competiveResultList){
            if(competitionresult.getIdNum().equals(idNum)){competiveResultList.remove(competitionresult);}
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament);
        for (int i = 0; i < competiveResultList.size(); i++) {
            if(competitionResult.getResultTime() <= competiveResultList.get(i).getResultTime()){
                competiveResultList.add(i,competitionResult);
            }
        }
        if(!competiveResultList.contains(competitionResult)){
            competiveResultList.add(competiveResultList.size(),competitionResult);
        }
        return "";
    }

    //Create Training Results //@Martin Anberg

    public void runCreateTrainResultButterfly(double resultTime, String idNum, LocalDate resultDate, String comment){
      trainingBestResultListButterfly = createTrainResult(resultTime,idNum,resultDate,comment, trainingBestResultListButterfly);
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

    public ArrayList<TrainingResult> createTrainResult(double resultTime, String idNum, LocalDate resultDate, String comment, ArrayList<TrainingResult> trainingResultList) {
        for (Result result : trainingResultList) {
            if (result.getIdNum().equals(idNum)) {
                trainingResultList.remove(result);
            }
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate, comment);
        trainingResultList.add(trainingResult);
        System.out.println(trainingResultList.size()); // test
        for (int i = 0; i < trainingResultList.size(); i++) {
            if (resultTime < trainingResultList.get(i).getResultTime() || trainingResultList.get(i).getResultTime() == 0) {
                trainingResultList.set(i, trainingResult);
            }
        }
        if(!trainingResultList.contains(trainingResult)){
            trainingResultList.add(trainingResult);
        }
        System.out.println("time " + resultTime);
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
            if(idNum.equals(result.getIdNum())){
                bestTime = result.getResultTime();
            }
        }
        System.out.println(bestTime); // test
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



