package com.company.domain;

import java.time.LocalDate;
import java.util.UUID;

public class CompetitionResult extends Result{
    public CompetitionResult(double resultTime, UUID idNum, LocalDate dateOfReult) {
        super(resultTime, idNum, dateOfReult);
    }
}
