package com.company.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Result {
    private double resultTime;
    private UUID idNum;
    private LocalDate dateOfResult;

    enum Discipline{
        BUTTERFLY,
        CRAWL,
        BAGCRAWL,
        BREASTSTROKE;
    }

    public Result(double resultTime, UUID idNum, LocalDate dateOfResult) {
        this.resultTime = resultTime;
        this.idNum = idNum;
        this.dateOfResult = dateOfResult;
    }

    public double getResultTime() {
        return resultTime;
    }

    public void setResultTime(double resultTime) {
        this.resultTime = resultTime;
    }

    public UUID getIdNum() {
        return idNum;
    }

    public void setIdNum(UUID idNum) {
        this.idNum = idNum;
    }

    public LocalDate getDateOfResult() {
        return dateOfResult;
    }

    public void setDateOfResult(LocalDate dateOfResult) {
        this.dateOfResult = dateOfResult;
    }
}
