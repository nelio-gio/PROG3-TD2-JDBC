package football.model;

import football.enums.ContinentEnum;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private Integer id;
    private String name;
    private ContinentEnum continent;
    private List<Player> players = new ArrayList<>();


    public Team() {
    }

    public Team(Integer id, String name, ContinentEnum continent, List<Player> players) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.players = (players != null) ? players : new ArrayList<>();
    }


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


    public int getPlayersGoals() {
        int total = 0;
        for (Player player : players) {
            if (player.getGoals() == null) {
                throw new IllegalStateException(
                        "Nombre de buts encore inconnu pour le joueur : " + player.getName()
                );
            }
            total += player.getGoals();
        }
        return total;
    }


}