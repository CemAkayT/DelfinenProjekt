package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class MemberList {
    private ArrayList<Member> members = new ArrayList<>();


    public void createMember(String name, UUID idNum, LocalDate dateOfBirth, boolean hasPaid, LocalDate dateOfMembership, boolean isCompetitive, String trainerName){
        Member member = new Member(name, idNum, dateOfBirth,hasPaid,dateOfMembership,isCompetitive,trainerName);
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
    public void editMemberArrears(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
            if(members.get(i).isHasPaid() == true){
                members.get(i).setHasPaid(false);
            }else members.get(i).setHasPaid(true);
            }
    }
    public void editMemberTrainer(String idNumEdit, String trainerName){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                members.get(i).setTrainerName(trainerName);
            }
    }
    public void editMemberStatus(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                if(members.get(i).isCompetitive() == true){
                    members.get(i).setCompetitive(false);
                    members.get(i).setTrainerName(null);
                }else members.get(i).setCompetitive(true);
            }
            }

    public void showMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).getName()+members.get(i).getIdNum()
                    +members.get(i).getDateOfBirth()+members.get(i).getDateOfMembership()+
                    members.get(i).getTrainerName());
        }

    }
    public void arrearslist(){
        for (int i = 0; i < members.size(); i++)
            if (members.get(i).isHasPaid() == false){
                System.out.println(members.get(i).getName());
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


}
