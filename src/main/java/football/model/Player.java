package football.model;

import football.enums.PlayerPositionEnum;

public class Player {

    private Integer id;
    private String name;
    private int age;
    private PlayerPositionEnum position;
    private Team team;  // peut être null si l'équipe n'est pas chargée

    // Constructeur vide (très important pour JDBC et bonnes pratiques)
    public Player() {
    }

    // Constructeur complet (pratique pour les tests)
    public Player(Integer id, String name, int age, PlayerPositionEnum position, Team team) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
    }

    // === Getters ===
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

    // === Setters (indispensables !) ===
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

    // Pour afficher joliment dans les logs ou tests
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", team=" + (team != null ? team.getName() : "aucune") +
                '}';
    }
}