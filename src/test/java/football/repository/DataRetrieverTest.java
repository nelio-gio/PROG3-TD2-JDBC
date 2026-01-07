package football.repository;

import football.db.DBConnection;
import football.model.Player;
import football.model.Team;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataRetrieverTest {

    private final DBConnection dbConnection = new DBConnection();
    private final DataRetriever dataRetriever = new DataRetriever(dbConnection);

    @Test
    void testFindTeamById() throws SQLException {
        Team team = dataRetriever.findTeamById(1);

        assertNotNull(team);
        assertEquals("Real Madrid CF", team.getName());
        assertTrue(team.getPlayers().size() > 0);
    }

    @Test
    void testFindPlayersPagination() throws SQLException {
        List<Player> players = dataRetriever.findPlayers(1, 2);

        assertEquals(2, players.size());
    }

    @Test
    void testShowPlayers() throws SQLException {
        List<Player> players = dataRetriever.findPlayers(1, 10);

        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getPosition());
        }
    }

    @Test
    void testFindTeamByIdWithPlayers() throws SQLException {
        Team team = dataRetriever.findTeamById(1);

        assertNotNull(team);
        assertEquals("Real Madrid CF", team.getName());
        assertEquals(3, team.getPlayers().size());

        System.out.println("Équipe trouvée : " + team.getName());
        System.out.println("Nombre de joueurs : " + team.getPlayers().size());
        for (Player p : team.getPlayers()) {
            System.out.println("  - " + p.getName() + " (" + p.getPosition() + ")");
        }
    }

    @Test
    void testFindTeamByIdWithoutPlayers() throws SQLException {
        Team team = dataRetriever.findTeamById(5);

        assertNotNull(team);
        assertEquals("Inter Miami CF", team.getName());
        assertEquals(0, team.getPlayers().size());
    }

    @Test
    void testFindPlayersPaginationPage1() throws SQLException {
        List<Player> players = dataRetriever.findPlayers(1, 2);

        assertEquals(2, players.size());
        assertEquals("Thibaut Courtois", players.get(0).getName());
        assertEquals("Dani Carvajal", players.get(1).getName());
    }
}