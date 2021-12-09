package com.company.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class MemberList {
    private ArrayList<Member> members = new ArrayList<>();

    // Overload to build member list from file @Graham Heaven
    public void createMember(ArrayList<String> listOfMembers) {
        for (String line : listOfMembers) {
            String[] lineData = line.split(";");
            String name = lineData[0];
            String middleName = lineData[1];
            String lastName = lineData[2];
            String idNum = lineData[3];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(lineData[4], formatter);
            LocalDate dateOfMembership = LocalDate.parse(lineData[5], formatter);
            boolean isCompetitive = Objects.equals(lineData[6], "true");
            String trainerName = lineData[7];

            Member member = new Member(name, middleName, lastName, idNum, dateOfBirth, dateOfMembership, isCompetitive, trainerName);
            members.add(member);
        }
        membersListToString();
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void createMember(String name, String middleName, String lastName, String idNum, LocalDate dateOfBirth, LocalDate dateOfMembership, boolean isCompetitive, String trainerName) {
        Member member = new Member(name, middleName, lastName, idNum, dateOfBirth, dateOfMembership, isCompetitive, trainerName);
        members.add(member);
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void deleteMember(String idNumDelete) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getIdNum().equals(idNumDelete)) {
                members.remove(i);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberName(String idNumEdit, String name) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                member.setName(name);
            }

    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberMiddleName(String idNumEdit, String memberMiddleName) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                member.setMiddleName(memberMiddleName);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberLastName(String idNumEdit, String memberLastName) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getIdNum().equals(idNumEdit)) {
                members.get(i).setLastName(memberLastName);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberArrears(String idNumEdit) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getIdNum().equals(idNumEdit)) {
                if (members.get(i).isHasPaid()) {
                    members.get(i).setHasPaid(false);
                } else members.get(i).setHasPaid(true);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberTrainer(String idNumEdit, String trainerName) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                member.setTrainerName(trainerName);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public void editMemberStatus(String idNumEdit) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                if (member.isCompetitive()) {
                    member.setCompetitive(false);
                    member.setTrainerName(null);
                } else member.setCompetitive(true);
            }
    }

    //@Martin Anberg @Cem Akay @Tobias Winkel
    public String showMembers() {
        String s = "";
        for (Member member : members) {
            s = s + "\nMEDLEMSNAVN: " + member.getName() + " " + member.getMiddleName() + " " + member.getLastName() +
                    "\nID: " + member.getIdNum() +
                    "\nFØDSELSDATO: " + member.getDateOfBirth() +
                    "\nOPRETTELSESDATO: " + member.getDateOfMembership() +
                    "\nTRÆNER: " + member.getTrainerName() +
                    "\nMEDLEMSSTATUS: " + member.getMembershipStatus() +
                    "\nAKTIVSTATUS: " + member.isActive() +
                    "\n";
        }
        return s;
    }

    //@MartinAnberg
    public String arrearsList() {
        String s = "";
        for (Member member : members) {
            if (!member.isHasPaid()) {
                s = s + member.getName() + " " + member.getMiddleName() + " " + member.getLastName() + "\n" + member.getIdNum() + "\n";
            }
        }
        return s;
    }

    //@MartinAnberg
    public String memberPaymentList() {
        String s = "";
        for (Member member : members) {
            if (member.isHasPaid()) {
                s = s + member.getName() + " " + member.getMiddleName() + " " + member.getLastName() + "\n" + member.getIdNum() +
                        "\nDette medlem betaler " + member.getMembershipFee() + " i kontingent\n\n";
            }
        }
        return s;
    }

    public boolean memberArrearsStatus(String idNumEdit) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getIdNum().equals(idNumEdit)) {
                return members.get(i).isHasPaid();
            }
        return false;
    }

    public boolean memberSwimmerStatus(String idNumEdit) {
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).getIdNum().equals(idNumEdit)) {
                return members.get(i).isCompetitive();
            }
        return false;
    }

    //@MartinAnberg
    public String showIncome() {
        double income = 0;
        for (Member member : members) {
            income = income + member.getMembershipFee();
        }
        return "Klubbens årlige indkomst er " + income + "\nKlubbens månedlige indkomst er " + income / 12;
    }

    public void editActiveStatus(String idNumEdit) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                member.setActive(!member.isActive());
            }
    }

    public boolean memberActiveStatus(String idNumEdit) {
        for (Member member : members)
            if (member.getIdNum().equals(idNumEdit)) {
                return member.isActive();
            }
        return false;
    }

    //@Graham Heaven
    public String competitiveListShort() {
        StringBuilder s = new StringBuilder();
        for (Member member : members) {
            if (member.isCompetitive()) {
                s.append("\n").append(member.getName()).append(" ").append(member.getMiddleName()).append(" ").append(member.getLastName()).append(", ID: ").append(member.getIdNum());
            }
        }
        return s.toString();
    }


    //@MartinAnberg
    public String searchMemberByIdNum(String IdNum) {
        for (Member member : members)
            if (member.getIdNum().equals(IdNum)) {
                return member.getName() + " " + member.getMiddleName() + " " + member.getLastName();
            }
        return null;
    }

    // @Graham Heaven
    public ArrayList<String> membersListToString() {
        ArrayList<String> listOfMembers = new ArrayList<>();
        String memberData;
        for (Member m : members) {
            memberData = m.buildStringForCSV();
            listOfMembers.add(memberData);
        }
        return listOfMembers;
    }

    //Needed to create team list from file which only stores UUID as string. @Graham Heaven
    public Member getMemberFromUUID(String idNum) {
        //try to get name as test
        Member foundMember = null;
        for (Member m : members) {
            if (Objects.equals(m.getIdNum(), idNum)) {
                foundMember = m;
            }
        }
        return foundMember;
    }
}
