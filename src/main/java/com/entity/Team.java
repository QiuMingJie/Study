package com.entity;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2019-11-18 16:30
 * @Description
 */

public class Team {

    private Student leader;

    private List<Student> members;

    private String teamName;

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "leader=" + leader +
                ", members=" + members +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
