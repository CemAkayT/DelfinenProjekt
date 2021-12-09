package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
//@Martin Anberg
public class Result implements Comparable<Result> {
    private double resultTime;
    private String idNum;
    private LocalDate dateOfResult;



    public Result(double resultTime, String idNum, LocalDate dateOfResult) {
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

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public LocalDate getDateOfResult() {
        return dateOfResult;
    }

    public void setDateOfResult(LocalDate dateOfResult) {
        this.dateOfResult = dateOfResult;
    }

    // @Graham Heaven
    public String buildStringForCSV() {
        return idNum + ";" + dateOfResult + ";" + resultTime + ";";
    }

    @Override
    public int compareTo(Result time) {
        return Double.compare(this.resultTime, time.resultTime);
    }
}
