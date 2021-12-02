package com.company.domain;

import java.time.LocalDate;
import java.util.UUID;

public class TrainingResult extends Result{

    public TrainingResult(double resultTime, String idNum, LocalDate dateOfResult) {
        super(resultTime, idNum, dateOfResult);

    }
}
