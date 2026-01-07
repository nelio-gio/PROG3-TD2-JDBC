package football.model;

import football.enums.PlayerPositionEnum;

public class Player {

    private Integer id;
    private String name;
    private int age;
    private PlayerPositionEnum position;
    private Team team;
    private Integer goals;


    public Player() {
    }


    public Player(Integer id, String name, int age, PlayerPositionEnum position, Team team, Integer goals) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
        this.goals = goals;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public Integer getGoals() {
        return goals;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(PlayerPositionEnum position) {
        this.position = position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", team=" + (team != null ? team.getName() : "aucune") +
                ", goals=" + goals +
                '}';
    }
}