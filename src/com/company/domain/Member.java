package com.company.domain;


import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Member {
    private String name;
    private UUID idNum;
    private LocalDate dateOfBirth;
    private boolean hasPaid;
    private LocalDate dateOfMembership;
    private boolean isCompetitive;
    private String trainerName;
    private double membershipFee;

    public Member(String name, UUID idNum, LocalDate dateOfBirth, boolean hasPaid, LocalDate dateOfMembership, boolean isCompetitive, String trainerName) {
        this.name = name;
        this.idNum = idNum;
        this.dateOfBirth = dateOfBirth;
        this.hasPaid = hasPaid;
        this.dateOfMembership = dateOfMembership;
        this.isCompetitive = isCompetitive;
        this.trainerName = trainerName;
        setMembershipFee();
    }

    public String getName() {
        return name;
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

    public UUID getIdNum() {
        return idNum;
    }

    public double getMembershipFee() {
        return membershipFee;
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

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setMembershipFee() {
        Period currentAge = Period.between(dateOfBirth, LocalDate.now());
        if(currentAge.getYears() >= 18 && currentAge.getYears() < 60){
            this.membershipFee = 1600;
        }
        if(currentAge.getYears() > 60){
            this.membershipFee = 1600*0.75;
        }
        if(currentAge.getYears() < 18){
            this.membershipFee = 1000;
        }

    }
}
