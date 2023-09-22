import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.TournamentManagement.Game;
import ru.netology.TournamentManagement.NotRegisteredException;
import ru.netology.TournamentManagement.Player;

public class GameTest {

    @Test
    public void theFirstPlayerWins() {
        Player dima = new Player(1, "Дима", 420);
        Player lyosha = new Player(2, "Лёша", 400);
        Game game = new Game();

        game.register(lyosha);
        game.register(dima);
        int actual = game.round("Дима", "Лёша");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void theSecondPlayerWins() {
        Player dima = new Player(1, "Дима", 420);
        Player lyosha = new Player(2, "Лёша", 500);
        Game game = new Game();

        game.register(dima);
        game.register(lyosha);
        int actual = game.round("Дима", "Лёша");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void Draw() {
        Player dima = new Player(1, "Дима", 400);
        Player lyosha = new Player(2, "Лёша", 400);
        Game game = new Game();

        game.register(lyosha);
        game.register(dima);
        int actual = game.round("Дима", "Лёша");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void theFirstPlayerDoesNotExist() {
        Player lyosha = new Player(1, "Лёша", 300);
        Player dima = new Player(2, "Дима", 320);
        Game game = new Game();

        game.register(lyosha);
        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Герман", "Дима")
        );
    }

    @Test
    public void thereIsNoSecondPlayer() {
        Player lyosha = new Player(1, "Лёша", 300);
        Player dima = new Player(2, "Дима", 320);
        Game game = new Game();

        game.register(lyosha);
        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Лёша", "Герман")
        );
    }
}
