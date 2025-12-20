package football.repository;

import football.repository.DataRetriever;
import football.db.DBConnection;
import football.enums.ContinentEnum;
import football.enums.PlayerPositionEnum;
import football.model.Team;
import football.model.Player;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataRetrieverTest {

    @Test
    void testFindTeamById() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever dataRetriever = new DataRetriever(dbConnection);

        Team team = dataRetriever.findTeamById(1);

        assertNotNull(team);
        assertEquals("Real Madrid CF", team.getName());
        assertTrue(team.getPlayers().size() > 0);
    }

    @Test
    void testFindPlayersPagination() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever dataRetriever = new DataRetriever(dbConnection);

        List<Player> players = dataRetriever.findPlayers(1, 2);

        assertEquals(2, players.size());
    }

    @Test
    void testShowPlayers() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever repo = new DataRetriever(dbConnection);

        List<Player> players = repo.findPlayers(1, 10);

        for (Player p : players) {
            System.out.println(
                    p.getName() + " - " + p.getPosition()
            );
        }
    }


    @Test
    void testFindTeamByIdWithPlayers() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever repo = new DataRetriever(dbConnection);

        Team team = repo.findTeamById(1);

        assertNotNull(team);
        assertEquals("Real Madrid CF", team.getName());
        assertTrue(team.getPlayers().size() >= 3);
    }

    @Test
    void testFindTeamByIdWithoutPlayers() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever repo = new DataRetriever(dbConnection);

        Team team = repo.findTeamById(5);

        assertNotNull(team);
        assertEquals("Inter Miami CF", team.getName());
        assertEquals(0, team.getPlayers().size());
    }

    @Test
    void testFindPlayersPaginationPage1() throws SQLException {

        DBConnection dbConnection = new DBConnection();
        DataRetriever repo = new DataRetriever(dbConnection);

        List<Player> players = repo.findPlayers(1, 2);

        assertEquals(2, players.size());
        assertEquals("Thibaut Courtois", players.get(0).getName());
        assertEquals("Dani Carvajal", players.get(1).getName());
    }


}
