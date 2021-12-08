package com.company.domain;

import java.time.LocalDate;
import java.util.UUID;

public class TrainingResult extends Result {

    private String comment;

    public TrainingResult(double resultTime, String idNum, LocalDate dateOfResult, String comment) {
        super(resultTime, idNum, dateOfResult);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}
