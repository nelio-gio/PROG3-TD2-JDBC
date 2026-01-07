package football.model;

import football.enums.ContinentEnum;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private Integer id;
    private String name;
    private ContinentEnum continent;
    private List<Player> players = new ArrayList<>();  // jamais null

    // Constructeur vide
    public Team() {
    }

    public Team(Integer id, String name, ContinentEnum continent, List<Player> players) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.players = (players != null) ? players : new ArrayList<>();
    }

    // === Getters ===
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContinentEnum getContinent() {
        return continent;
    }

    public List<Player> getPlayers() {
        return players;
    }

    // === Setters ===
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(ContinentEnum continent) {
        this.continent = continent;
    }

    public void setPlayers(List<Player> players) {
        this.players = (players != null) ? players : new ArrayList<>();
    }

    // Méthode demandée dans l'exercice (getPlayersCount)
    public Integer getPlayersCount() {
        return players.size();
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", nombre de joueurs=" + players.size() +
                '}';
    }
}