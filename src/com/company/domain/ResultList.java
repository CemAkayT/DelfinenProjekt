package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ResultList {
    ArrayList<TrainingResult> trainingResultList = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultList = new ArrayList<>();

    public void createCompResultButterfly(double resultTime, String idNum, LocalDate resultDate,String tournament,Discipline discipline){
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament,Discipline.BUTTERFLY);
        competitiveResultList.add(competitionResult);
    }
    public void createCompResultCrawl(double resultTime, String idNum, LocalDate resultDate,String tournament,Discipline discipline){
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament,Discipline.CRAWL);
        competitiveResultList.add(competitionResult);
    }
    public void createCompResultBackcrawl(double resultTime, String idNum, LocalDate resultDate,String tournament,Discipline discipline){
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament,Discipline.BACKCRAWL);
        competitiveResultList.add(competitionResult);
    }
    public void createCompResultBreaststroke(double resultTime, String idNum, LocalDate resultDate,String tournament,Discipline discipline){
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament,Discipline.BREASTSTROKE);
        competitiveResultList.add(competitionResult);
    }

    //Create Training results

    public void createTrainResultButterfly(double resultTime, String idNum, LocalDate resultDate){
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.BUTTERFLY);
        trainingResultList.add(trainingResult);
    }
    public void createTrainResultCrawl(double resultTime, String idNum, LocalDate resultDate){
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.CRAWL);
        trainingResultList.add(trainingResult);
    }
    public void createTrainResultBackcrawl(double resultTime, String idNum, LocalDate resultDate){
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.BACKCRAWL);
        trainingResultList.add(trainingResult);
    }
    public void createTrainResultBreaststroke(double resultTime, String idNum, LocalDate resultDate){
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate, Discipline.BREASTSTROKE);
        trainingResultList.add(trainingResult);
    }


}
