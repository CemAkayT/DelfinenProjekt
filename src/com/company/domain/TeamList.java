package com.company.domain;

import java.util.ArrayList;
import java.util.Objects;

public class TeamList {
    private ArrayList<Team> teams = new ArrayList<>();

    public void createTeam(String name, boolean isJunior, boolean isDeleteable){
        Team team = new Team(name,isJunior,isDeleteable);
        teams.add(team);
    }

    // overload to recreate team list from file @Graham Heaven
    public void createTeam(String name, boolean isJunior, boolean isDeleteable, ArrayList<Member> list) {
        Team team = new Team(name, isJunior, isDeleteable, list);
        teams.add(team);
    }

    //@Martin Anberg
    public String deleteTeam(String name){
        for (Team team : teams)
        if(team.getTeamName().equals(name)){
            if(team.isDeleteable()) {
                teams.remove(team);
                return team.getTeamName()+" er blevet slettet.";
            }else{
                return "Dette hold kan ikke slettes";
            }
        }
        return null;
    }
    //@Martin Anberg
    public String listOfTeams() {
        String s ="";
        for (Team team : teams) {
            s = s + "TEAM NAVN: " + team.getTeamName()+"\n";
        }
        return s;
    }
    //@Martin Anberg
    public void editTeamName(String name,String newname){
        for (Team team : teams) {
            if(team.getTeamName().equals(name))
            team.setTeamName(newname);
        }

    }
    //@Martin Anberg
    public void addMemberToTeam(String teamName, Member member){
        for (Team team : teams) {
            if(team.getTeamName().equals(teamName))
                team.addMember(member);
        }

    }
    //@Martin Anberg
    public void removeMemberToTeam(String teamName,Member member){
        for (Team team : teams) {
            if(team.getTeamName().equals(teamName))
                team.removeMember(member);
        }
    }
    public void seeMembersInTeam(String teamName){
        for (Team team : teams) {
            if(team.getTeamName().equals(teamName)){

            }
        }
    }

    // @Graham Heaven
    public ArrayList<String> teamsListToString() {
        ArrayList<String> listOfTeams = new ArrayList<>();
        ArrayList<String> listOfTeamData;
        for (Team t : teams) {
            StringBuilder teamData = new StringBuilder();
            teamData.append(t.getTeamName()).append(";");
            teamData.append(t.isJunior()).append(";");
            teamData.append(t.isDeleteable()).append(";");
            listOfTeamData = t.getListOfTeamMembersIds();
            for (String s : listOfTeamData) {
                teamData.append(s).append(";");
            }
            listOfTeams.add(teamData.toString());
        }
        return listOfTeams;
    }
}
