package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class MemberList {
    private ArrayList<Member> members = new ArrayList<>();


    public void createMember(String name, String lastName, UUID idNum, LocalDate dateOfBirth, LocalDate dateOfMembership, boolean isCompetitive, String trainerName){
        Member member = new Member(name, lastName,idNum, dateOfBirth,dateOfMembership,isCompetitive,trainerName);
        members.add(member);
    }

    public void deleteMember(String idNumDelete){
        for (int i = 0; i < members.size(); i++)
        if(members.get(i).getIdNum().toString().equals(idNumDelete)){
            members.remove(i);
        }
    }
    public void editMemberName(String idNumEdit, String name){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                members.get(i).setName(name);
                }

    }
    public void editMemberLastName(String idNumEdit, String memberLastName){
        for (int i = 0; i <members.size() ; i++)
          if (members.get(i).getIdNum().toString().equals(idNumEdit)) {
              members.get(i).setLastName(memberLastName);
        }
    }
    public void editMemberArrears(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
            if(members.get(i).isHasPaid()){
                members.get(i).setHasPaid(false);
            }else members.get(i).setHasPaid(true);
            }
    }
    public void editMemberTrainer(String idNumEdit, String trainerName){
        for (Member member : members)
            if (member.getIdNum().toString().equals(idNumEdit)) {
                member.setTrainerName(trainerName);
            }
    }
    public void editMemberStatus(String idNumEdit){
        for (Member member : members)
            if (member.getIdNum().toString().equals(idNumEdit)) {
                if (member.isCompetitive()) {
                    member.setCompetitive(false);
                    member.setTrainerName(null);
                } else member.setCompetitive(true);
            }
            }

    public void showMembers(){
        for (Member member : members) {
            System.out.println("\nMEDLEMSNAVN: " + member.getName() + " " + member.getLastName() +
                    "\nID: " + member.getIdNum() +
                    "\nFØDSELSDATO: " + member.getDateOfBirth() +
                    "\nOPRETTELSESDATO: " + member.getDateOfMembership() +
                    "\nTRÆNER: " + member.getTrainerName() +
                    "\nMEDLEMSSTATUS: " + member.getMembershipStatus() +
                    "\nAKTIVSTATUS: " + member.isActive() +
                    "\n");
        }

    }
    public void arrearsList(){
        for (Member member : members)
            if (!member.isHasPaid()) {
                System.out.println(member.getName());
            }
    }
    public boolean memberArrearsStatus(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
            return members.get(i).isHasPaid();
            }
        return false;
    }
    public boolean memberSwimmerStatus(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                return members.get(i).isCompetitive();
            }
        return false;
    }
    public double showIncome(){
        double income = 0;
        for (Member member : members) {
            income = income + member.getMembershipFee();
        }
         return income;
    }
    public void editActiveStatus(String idNumEdit){
        for (Member member : members)
            if (member.getIdNum().toString().equals(idNumEdit)) {
                member.setActive(!member.isActive());
            }
    }
    public boolean memberActiveStatus(String idNumEdit){
        for (Member member : members)
            if (member.getIdNum().toString().equals(idNumEdit)) {
                return member.isActive();
            }
        return false;
    }

}
