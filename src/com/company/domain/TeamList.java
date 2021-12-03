package com.company.domain;

import java.util.ArrayList;
import java.util.Objects;

public class TeamList {
    private ArrayList<Team> teams = new ArrayList<>();

    public void createTeam(String name, boolean isJunior, boolean isDeleteable){
        Team team = new Team(name,isJunior,isDeleteable);
        teams.add(team);

    }public void createTeam(String name, boolean isJunior, boolean isDeleteable, ArrayList<Member> list) {
        Team team = new Team(name, isJunior, isDeleteable, list);
        teams.add(team);
    }


    public void deleteTeam(String name){
        for (Team team : teams)
        if(team.getTeamName().equals(name)){
            if(team.isDeleteable()) {
                teams.remove(team);
                System.out.println(team.getTeamName()+" er blevet slettet.");
            }else{
                System.out.println("Dette hold kan ikke slettes");
            }
        }
    }

    public void listOfTeams() {
        for (Team team : teams)
            System.out.println("TEAM NAVN: " + team.getTeamName());
    }
}
