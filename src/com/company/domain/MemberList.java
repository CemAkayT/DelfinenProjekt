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

    public void deleteMember(){

    }

    public void editMember(){

    }

    public void showMembers(){
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i).getName()+members.get(i).getIdNum()
                    +members.get(i).getDateOfBirth()+members.get(i).getDateOfMembership()+
                    members.get(i).getTrainerName());
        }

    }


}
