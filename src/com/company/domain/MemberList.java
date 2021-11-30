package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class MemberList {
    private ArrayList<Member> members = new ArrayList<>();


    public void createMember(String name, UUID idNum, LocalDate dateOfBirth, LocalDate dateOfMembership, boolean isCompetitive, String trainerName){
        Member member = new Member(name, idNum, dateOfBirth,dateOfMembership,isCompetitive,trainerName);
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
            System.out.println("\n MEDLEMSNAVN: "+members.get(i).getName()+
                    "\n ID: "+members.get(i).getIdNum() +
                    "\n FØDSELSDATO: "+members.get(i).getDateOfBirth()+
                    "\n OPRETTELSESDATO: "+members.get(i).getDateOfMembership()+
                    "\n TRÆNER: "+members.get(i).getTrainerName()+
                    "\n MEDLEMSSTATUS: "+members.get(i).getMembershipStatus()+
                    "\n AKTIVSTATUS: "+members.get(i).isActive()+
                    "\n");
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
    public double showIncome(){
        double income = 0;
        for (int i = 0; i < members.size(); i++){
            income = income + members.get(i).getMembershipFee();
        }
         return income;
    }
    public void editActiveStatus(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                if(members.get(i).isActive() == true){
                    members.get(i).setActive(false);
                }else members.get(i).setActive(true);
            }
    }
    public boolean memberActiveStatus(String idNumEdit){
        for (int i = 0; i < members.size(); i++)
            if(members.get(i).getIdNum().toString().equals(idNumEdit)){
                return members.get(i).isActive();
            }
        return false;
    }

}
