package com.company.domain;

import java.time.LocalDate;
import java.util.UUID;

public class TrainingResult extends Result{
    public TrainingResult(double resultTime, UUID idNum, LocalDate dateOfReult) {
        super(resultTime, idNum, dateOfReult);
    }
}
