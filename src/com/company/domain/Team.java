package com.company.domain;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private boolean isJunior;
    private ArrayList<Member> teamMemberlist = new ArrayList<>();

    public Team(String teamName, boolean isJunior, ArrayList<Member> teamMemberlist) {
        this.teamName = teamName;
        this.isJunior = isJunior;
        this.teamMemberlist = teamMemberlist;
    }

    public void addMember(Member member){
        teamMemberlist.add(member);
    }
    public void removeMember(Member member){
        teamMemberlist.remove(member);
    }
    public void showTeamMemberList(Member member){
        for(Member member1 : teamMemberlist){
            System.out.println(member1.getName()+" "+member1.getMiddleName()+" "+member1.getLastName());
        }
    }

    public String getTeamName() {
        return teamName;
    }


    enum Discipline{
        BUTTERFLY,
        CRAWL,
        BAGCRAWL,
        BREASTSTROKE;
    }
}
