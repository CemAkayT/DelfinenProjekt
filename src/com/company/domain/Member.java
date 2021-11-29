package com.company.domain;


import java.time.LocalDate;
import java.util.UUID;

public class Member {
    private String name;
    private UUID idNum;
    private LocalDate dateOfBirth;
    private boolean hasPaid;
    private LocalDate dateOfMembership;
    private boolean isCompetitive;
    private String trainerName;

    public Member(String name, UUID idNum, LocalDate dateOfBirth, boolean hasPaid, LocalDate dateOfMembership, boolean isCompetitive, String trainerName) {
        this.name = name;
        this.idNum = idNum;
        this.dateOfBirth = dateOfBirth;
        this.hasPaid = hasPaid;
        this.dateOfMembership = dateOfMembership;
        this.isCompetitive = isCompetitive;
        this.trainerName = trainerName;
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

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }
}
