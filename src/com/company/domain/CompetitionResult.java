package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class CompetitionResult extends Result {
    private String tournament;

    public CompetitionResult(double resultTime, String idNum, LocalDate dateOfResult, String tournament) {
        super(resultTime, idNum, dateOfResult);
        this.tournament = tournament;
    }

    public String getTournament() {
        return tournament;
    }
    public Result getResultByID(String idNum, ArrayList<CompetitionResult> results){
        for(Result result : results) {
            if (idNum.equals(getIdNum())) {
                return result;
            }
        }
        return null;
    }
}
