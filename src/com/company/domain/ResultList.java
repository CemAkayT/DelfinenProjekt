package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ResultList {
    ArrayList<TrainingResult> trainingResultListButterfly = new ArrayList<>();
    ArrayList<TrainingResult> trainingResultListCrawl = new ArrayList<>();
    ArrayList<TrainingResult> trainingResultListBackcrawl = new ArrayList<>();
    ArrayList<TrainingResult> trainingResultListBreaststroke = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultListButterfly = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultListCrawl = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultListBackcrawl = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultListBreaststroke = new ArrayList<>();

    //Create Competitive Results //@Martin Anberg

    public void runCreateCompResultButterfly(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament,competitiveResultListButterfly);
    }
    public void runCreateCompResultCrawl(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament,competitiveResultListCrawl);
    }
    public void runCreateCompResultBackcrawl(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament,competitiveResultListBackcrawl);
    }
    public void runCreateCompResultBreaststroke(double resultTime, String idNum, LocalDate resultDate,String tournament){
        createCompResult(resultTime,idNum,resultDate,tournament,competitiveResultListBreaststroke);
    }

    public void createCompResult(double resultTime, String idNum, LocalDate resultDate,String tournament, ArrayList<CompetitionResult> competiveResultList){
        for(Result result : competiveResultList){
            if(result.getIdNum().equals(idNum)){competiveResultList.remove(result);}
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament);
        for (int i = 0; i < competiveResultList.size(); i++) {
            if(competitionResult.getResultTime() > competiveResultList.get(i).getResultTime()){
                competiveResultList.add(i,competitionResult);
            }
        }
        if(!competiveResultList.contains(competitionResult)){
            competiveResultList.add(competiveResultList.size(),competitionResult);
        }
    }

    //Create Training Results //@Martin Anberg

    public void runCreateTrainResultButterfly(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,trainingResultListButterfly);
    }
    public void runCreateTrainResultCrawl(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,trainingResultListButterfly);
    }
    public void runCreateTrainResultBackcrawl(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,trainingResultListButterfly);
    }
    public void runCreateTrainResultBreaststroke(double resultTime, String idNum, LocalDate resultDate){
        createTrainResult(resultTime,idNum,resultDate,trainingResultListButterfly);
    }

    public void createTrainResult(double resultTime, String idNum, LocalDate resultDate, ArrayList<TrainingResult> trainingResultList) {
        for (Result result : trainingResultList) {
            if (result.getIdNum().equals(idNum)) {
                trainingResultList.remove(result);
            }
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate);
        for (int i = 0; i < trainingResultList.size(); i++) {
            if (trainingResult.getResultTime() > trainingResultList.get(i).getResultTime()) {
                trainingResultList.add(i, trainingResult);
            }
        }
        if(!trainingResultList.contains(trainingResult)){
            trainingResultList.add(trainingResultList.size(),trainingResult);
        }
    }

    //TOP 5 COMPETITIVE //@Martin Anberg

    public String showTop5CompResultsButterfly(){
       return Top5CompResults(competitiveResultListButterfly);
    }
    public String showTop5CompResultsCrawl(){
        return Top5CompResults(competitiveResultListButterfly);
    }
    public String showTop5CompResultsBackcrawl(){
        return Top5CompResults(competitiveResultListButterfly);
    }
    public String showTop5CompResultsBreaststroke(){
        return Top5CompResults(competitiveResultListButterfly);
    }

    public String Top5CompResults(ArrayList<CompetitionResult> competitionResultList){
        String s ="";
        for (int i = 0; i < 5; i++) {
            s = s + i+". ID:"+competitionResultList.get(i).getIdNum()+" TID:"+competitionResultList.get(i).getResultTime()+" STÆVNE: "+competitionResultList.get(i).getTournament();
        }
        return s;
    }

    //TOP 5 TRAINING
    public String showTop5TrainResultsButterfly(){
        return Top5TrainResults(trainingResultListButterfly);
    }
    public String showTop5TrainResultsCrawl(){
        return Top5TrainResults(trainingResultListCrawl);
    }
    public String showTop5TrainResultsBackcrawl(){
        return Top5TrainResults(trainingResultListBackcrawl);
    }
    public String showTop5TrainResultsBreaststroke(){
        return Top5TrainResults(trainingResultListBreaststroke);
    }

    public String Top5TrainResults(ArrayList<TrainingResult> trainingResultList){
        String s = "";
        for (int i = 0; i <= 5; i++) {
            s = s + i+". ID:"+trainingResultList.get(i).getIdNum()+" TID:"+ trainingResultList.get(i).getResultTime();
        }
        return s;
    }

    //FIND MEMBER RESULT COMPETITIVE //@MartinAnberg
    public double memberCompetitiveButterfly(String idNum){
        for(Result result : competitiveResultListButterfly){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberCompetitiveCrawl(String idNum){
        for(Result result : competitiveResultListCrawl){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberCompetitiveBackcrawl(String idNum){
        for(Result result : competitiveResultListBackcrawl){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberCompetitiveBreaststroke(String idNum){
        for(Result result : competitiveResultListBreaststroke){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    //FIND MEMBER RESULT TRAINING //@MartinAnberg
    public double memberTrainingButterfly(String idNum){
        for(Result result : trainingResultListBreaststroke){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberTrainingCrawl(String idNum){
        for(Result result : trainingResultListCrawl){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberTrainingBackcrawl(String idNum){
        for(Result result : trainingResultListBackcrawl){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }
    public double memberTrainingBreaststroke(String idNum){
        for(Result result : trainingResultListBreaststroke){
            if(idNum.equals(result.getIdNum())){
                return result.getResultTime();
            }
        }
        return 0;
    }

}



