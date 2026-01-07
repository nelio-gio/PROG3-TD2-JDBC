package football;

import football.db.DBConnection;
import football.enums.ContinentEnum;
import football.enums.PlayerPositionEnum;
import football.model.Player;
import football.model.Team;
import football.repository.DataRetriever;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        DBConnection db = new DBConnection();
        DataRetriever retriever = new DataRetriever(db);

        // === TEST ORIGINAL : findTeamById et exception sur buts inconnus ===
        System.out.println("=== Test findTeamById et exception buts inconnus ===");
        Team real = retriever.findTeamById(1);
        System.out.println(real);
        System.out.println("Total buts Real Madrid : " + real.getPlayersGoals());

        try {
            Team barca = retriever.findTeamById(2);
            System.out.println(barca);
            System.out.println("Total buts Barcelona : " + barca.getPlayersGoals());
        } catch (IllegalStateException e) {
            System.out.println("Exception attendue capturée : " + e.getMessage());
        }

        System.out.println();

    }
}