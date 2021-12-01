package com.company.domain;

import java.util.ArrayList;

public class TeamList {
    private ArrayList<Team> teams = new ArrayList<>();

    public void createTeam(String name, boolean isJunior){
        Team team = new Team(name,isJunior);
        teams.add(team);

    }



}
