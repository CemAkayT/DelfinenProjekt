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

    public void createCompResultButterfly(double resultTime, String idNum, LocalDate resultDate,String tournament){
        for(Result result : competitiveResultListButterfly){
            if(result.getIdNum().equals(idNum)){competitiveResultListButterfly.remove(result);}
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament,Discipline.BUTTERFLY);
        for (int i = 0; i < competitiveResultListButterfly.size(); i++) {
            if(competitionResult.getResultTime() > competitiveResultListButterfly.get(i).getResultTime()){
                competitiveResultListButterfly.add(i,competitionResult);
            }
        }
    }
    public void createCompResultCrawl(double resultTime, String idNum, LocalDate resultDate,String tournament) {
        for (Result result : competitiveResultListCrawl) {
            if (result.getIdNum().equals(idNum)) {
                competitiveResultListCrawl.remove(result);
            }
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum, resultDate, tournament, Discipline.CRAWL);
        for (int i = 0; i < competitiveResultListCrawl.size(); i++) {
            if (competitionResult.getResultTime() > competitiveResultListCrawl.get(i).getResultTime()) {
                competitiveResultListCrawl.add(i, competitionResult);
            }
        }
    }
    public void createCompResultBackcrawl(double resultTime, String idNum, LocalDate resultDate,String tournament) {
        for (Result result : competitiveResultListBackcrawl) {
            if (result.getIdNum().equals(idNum)) {
                competitiveResultListBackcrawl.remove(result);
            }
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum, resultDate, tournament, Discipline.BACKCRAWL);
        for (int i = 0; i < competitiveResultListBackcrawl.size(); i++) {
            if (competitionResult.getResultTime() > competitiveResultListBackcrawl.get(i).getResultTime()) {
                competitiveResultListBackcrawl.add(i, competitionResult);
            }
        }
    }
    public void createCompResultBreaststroke(double resultTime, String idNum, LocalDate resultDate,String tournament) {
        for (Result result : competitiveResultListBreaststroke) {
            if (result.getIdNum().equals(idNum)) {
                competitiveResultListBreaststroke.remove(result);
            }
        }
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum, resultDate, tournament, Discipline.BREASTSTROKE);
        for (int i = 0; i < competitiveResultListButterfly.size(); i++) {
            if (competitionResult.getResultTime() > competitiveResultListButterfly.get(i).getResultTime()) {
                competitiveResultListButterfly.add(i, competitionResult);
            }
        }
    }
    //Create Training Results //@Martin Anberg

    public void createTrainResultButterfly(double resultTime, String idNum, LocalDate resultDate) {
        for (Result result : trainingResultListButterfly) {
            if (result.getIdNum().equals(idNum)) {
                trainingResultListButterfly.remove(result);
            }
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum, resultDate, Discipline.BUTTERFLY);
        for (int i = 0; i < trainingResultListButterfly.size(); i++) {
            if (trainingResult.getResultTime() > trainingResultListButterfly.get(i).getResultTime()) {
                trainingResultListButterfly.add(i, trainingResult);
            }
        }
    }
    public void createTrainResultCrawl(double resultTime, String idNum, LocalDate resultDate){
        for(Result result : trainingResultListCrawl){
            if(result.getIdNum().equals(idNum)){trainingResultListCrawl.remove(result);}
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.CRAWL);
            for (int i = 0; i < trainingResultListCrawl.size(); i++) {
                if(trainingResult.getResultTime() > trainingResultListCrawl.get(i).getResultTime()){
                    trainingResultListCrawl.add(i,trainingResult);
                }
            }
    }
    public void createTrainResultBackcrawl(double resultTime, String idNum, LocalDate resultDate){
        for(Result result : trainingResultListBackcrawl){
            if(result.getIdNum().equals(idNum)){trainingResultListBackcrawl.remove(result);}
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.BACKCRAWL);
        for (int i = 0; i < trainingResultListBackcrawl.size(); i++) {
            if(trainingResult.getResultTime() > trainingResultListBackcrawl.get(i).getResultTime()){
                trainingResultListBackcrawl.add(i,trainingResult);
            }
        }
    }
    public void createTrainResultBreaststroke(double resultTime, String idNum, LocalDate resultDate){
        for(Result result : trainingResultListBreaststroke){
            if(result.getIdNum().equals(idNum)){trainingResultListBreaststroke.remove(result);}
        }
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.BREASTSTROKE);
        for (int i = 0; i < trainingResultListBreaststroke.size(); i++) {
            if(trainingResult.getResultTime() > trainingResultListBreaststroke.get(i).getResultTime()){
                trainingResultListBreaststroke.add(i,trainingResult);
            }
        }
    }

    //TOP 5 COMPETITIVE //@Martin Anberg

    public String showTop5CompResultsButterfly(){
        for (int i = 0; i < 5; i++) {
            return i+". ID:"+competitiveResultListButterfly.get(i).getIdNum()+" TID:"+ competitiveResultListButterfly.get(i).getResultTime()+" STÆVNE: "+competitiveResultListButterfly.get(i).getTournament();
        }
        return null;
    }

    public String showTop5CompResultsCrawl(){
        for (int i = 0; i < 5; i++) {
            return i+". ID:"+competitiveResultListCrawl.get(i).getIdNum()+" TID:"+ competitiveResultListCrawl.get(i).getResultTime()+" STÆVNE: "+competitiveResultListCrawl.get(i).getTournament();
        }
        return null;
    }
    public String showTop5CompResultsBackcrawl(){
        for (int i = 0; i < 5; i++) {
            return i+". ID:"+competitiveResultListBackcrawl.get(i).getIdNum()+" TID:"+ competitiveResultListBackcrawl.get(i).getResultTime()+" STÆVNE: "+competitiveResultListBackcrawl.get(i).getTournament();
        }
        return null;
    }
    public String showTop5CompResultsBreaststroke(){
        for (int i = 0; i <= 5; i++) {
            return i+". ID:"+competitiveResultListBreaststroke.get(i).getIdNum()+" TID:"+ competitiveResultListBreaststroke.get(i).getResultTime()+" STÆVNE: "+competitiveResultListBreaststroke.get(i).getTournament();
        }
        return null;
    }

    //TOP 5 TRAINING
    public String showTop5TrainResultsButterfly(){
        for (int i = 0; i <= 5; i++) {
            return i+". ID:"+trainingResultListButterfly.get(i).getIdNum()+" TID:"+ trainingResultListButterfly.get(i).getResultTime();
        }
        return null;
    }
    public String showTop5TrainResultsCrawl(){
        for (int i = 0; i <= 5; i++) {
            return i+". ID:"+trainingResultListCrawl.get(i).getIdNum()+" TID:"+ trainingResultListCrawl.get(i).getResultTime();
        }
        return null;
            }
    public String showTop5TrainResultsBackcrawl(){
        for (int i = 0; i <= 5; i++) {
            return i+". ID:"+trainingResultListBackcrawl.get(i).getIdNum()+" TID:"+ trainingResultListBackcrawl.get(i).getResultTime();
        }
        return null;
    }
    public String showTop5TrainResultsBreaststroke(){
        for (int i = 0; i <= 5; i++) {
            return i+". ID:"+trainingResultListBreaststroke.get(i).getIdNum()+" TID:"+ trainingResultListBreaststroke.get(i).getResultTime();
        }
        return null;
    }

}



