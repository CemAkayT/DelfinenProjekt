package com.company.domain;


import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Member {
    private String name;
    private String middleName;
    private String lastName;
    private String idNum;
    private LocalDate dateOfBirth;
    private boolean hasPaid = true;
    private LocalDate dateOfMembership;
    private boolean isCompetitive;
    private String trainerName;
    private double membershipFee;
    private boolean isJunior;
    private boolean active = true;

    public Member(String name,String middleName, String lastName, String idNum, LocalDate dateOfBirth, LocalDate dateOfMembership, boolean isCompetitive, String trainerName) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.idNum = idNum;
        this.dateOfBirth = dateOfBirth;
        this.dateOfMembership = dateOfMembership;
        this.isCompetitive = isCompetitive;
        this.trainerName = trainerName;
        setMembership();
    }

    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName(){
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getIdNum() {
        return idNum;
    }

    public double getMembershipFee() {
        return membershipFee;
    }
    public String getMembershipStatus(){
        Period currentAge = Period.between(dateOfBirth, LocalDate.now());
        if(currentAge.getYears() >= 18 && currentAge.getYears() < 60){
            return "senior";
        }
        if(currentAge.getYears() > 60){
            return "senior";
        }
        if(currentAge.getYears() < 18){
            return "junior";
        }
        return "";
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setMembership() {
        Period currentAge = Period.between(dateOfBirth, LocalDate.now());
        if(currentAge.getYears() >= 18 && currentAge.getYears() < 60){
            this.membershipFee = 1600;
            isJunior = false;

        }
        if(currentAge.getYears() > 60){
            this.membershipFee = 1600*0.75;
            isJunior = false;

        }
        if(currentAge.getYears() < 18){
            this.membershipFee = 1000;
            isJunior = true;

        }
        if(!active){
            this.membershipFee = 500; // mangler vi else?
        }
    }

    public String buildStringForCSV() {
        return name + ";" + middleName + ";" + lastName + ";" +
                idNum + ";" + dateOfBirth + ";" + dateOfMembership + ";" + isCompetitive + ";" + trainerName + ";";
    }

    @Override
    public String toString() {
        return "Member: " + name + " " + middleName + " " + lastName +
                ", id Num: " + idNum +
                ", Date of birth: " + dateOfBirth +
                ", Paid: " + hasPaid +
                ", Subscription date: " + dateOfMembership +
                ", Is competitive: " + isCompetitive +
                ", Assigned trainer: " + trainerName;
    }
}
