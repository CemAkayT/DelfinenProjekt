package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ResultList {
    ArrayList<TrainingResult> trainingResultList = new ArrayList<>();
    ArrayList<CompetitionResult> competitiveResultList = new ArrayList<>();

    public void createCompResult(double resultTime, String idNum, LocalDate resultDate,String tournament){
        CompetitionResult competitionResult = new CompetitionResult(resultTime, idNum,resultDate,tournament);
        competitiveResultList.add(competitionResult);
    }

    public void createTrainResult(double resultTime, String idNum, LocalDate resultDate){
        TrainingResult trainingResult = new TrainingResult(resultTime, idNum,resultDate);
        trainingResultList.add(trainingResult);
    }


}
