package com.company.domain;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private final boolean isJunior;
    private ArrayList<Member> teamMemberlist = new ArrayList<>();
    private final boolean isDeletable;

    public Team(String teamName, boolean isJunior, boolean isDeletable) {
        this.teamName = teamName;
        this.isJunior = isJunior;
        this.isDeletable = isDeletable;
    }

    public Team(String teamName, boolean isJunior, boolean isDeletable, ArrayList<Member> list) {
        this.teamName = teamName;
        this.isJunior = isJunior;
        this.isDeletable = isDeletable;
        this.teamMemberlist = list;
    }

    public void addMember(Member member) {
        teamMemberlist.add(member);
    }

    public void removeMember(Member member) {
        teamMemberlist.remove(member);
    }

    public void showTeamMemberList(Member member) {
        for (Member member1 : teamMemberlist) {
            System.out.println(member1.getName() + " " + member1.getMiddleName() + " " + member1.getLastName());
        }
    }

    public ArrayList<Member> getTeamMemberList() {
        return teamMemberlist;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public boolean isJunior() {
        return isJunior;
    }

    //Build a list of ID for team members so they can save to file.
    public ArrayList<String> getListOfTeamMembersIds() {
        ArrayList<String> listOfIds = new ArrayList<>();
        for (Member m : teamMemberlist) {
            listOfIds.add(m.getIdNum());
        }
        return listOfIds;
    }
}
