package football.repository;


import football.db.DBConnection;
import football.enums.*;
import football.model.*;

import java.sql.*;
import java.util.*;

public class DataRetriever {

    private DBConnection dbConnection;

    public DataRetriever(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    public Team findTeamById(Integer id) throws SQLException {

        Connection conn = dbConnection.getConnection();

        PreparedStatement teamStmt =
                conn.prepareStatement("SELECT * FROM team WHERE id = ?");
        teamStmt.setInt(1, id);
        ResultSet rsTeam = teamStmt.executeQuery();

        if (!rsTeam.next()) return null;

        Team team = new Team(
                rsTeam.getInt("id"),
                rsTeam.getString("name"),
                ContinentEnum.valueOf(rsTeam.getString("continent")),
                new ArrayList<>()
        );

        PreparedStatement playerStmt =
                conn.prepareStatement("SELECT * FROM player WHERE id_team = ?");
        playerStmt.setInt(1, id);
        ResultSet rsPlayers = playerStmt.executeQuery();

        while (rsPlayers.next()) {
            Player player = new Player();
            player.setId(rsPlayers.getInt("id"));
            player.setName(rsPlayers.getString("name"));
            player.setAge(rsPlayers.getInt("age"));
            player.setPosition(PlayerPositionEnum.valueOf(rsPlayers.getString("position")));
            player.setTeam(team);

            Integer goals = (Integer) rsPlayers.getObject("goals");
            player.setGoals(goals);

            team.getPlayers().add(player);
        }

        return team;
    }

    public List<Player> findPlayers(int page, int size) throws SQLException {

        List<Player> players = new ArrayList<>();
        int offset = (page - 1) * size;

        Connection conn = dbConnection.getConnection();
        PreparedStatement stmt =
                conn.prepareStatement(
                        "SELECT * FROM player ORDER BY id LIMIT ? OFFSET ?");

        stmt.setInt(1, size);
        stmt.setInt(2, offset);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setAge(rs.getInt("age"));
            player.setPosition(PlayerPositionEnum.valueOf(rs.getString("position")));


            Integer goals = (Integer) rs.getObject("goals");
            player.setGoals(goals);

            players.add(player);
        }

        return players;
    }

    public void createPlayers(List<Player> players) throws SQLException {

        Connection conn = dbConnection.getConnection();
        conn.setAutoCommit(false);

        try {
            PreparedStatement insert =
                    conn.prepareStatement(
                            "INSERT INTO player(name, age, position, id_team) VALUES (?, ?, ?, ?)");

            for (Player p : players) {
                insert.setString(1, p.getName());
                insert.setInt(2, p.getAge());
                insert.setString(3, p.getPosition().name());
                insert.setObject(4, null);
                insert.executeUpdate();
            }

            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw e;
        }
    }
}

