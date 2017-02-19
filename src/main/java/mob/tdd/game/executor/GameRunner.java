package mob.tdd.game.executor;

import lombok.SneakyThrows;
import mob.tdd.game.Game;
import mob.tdd.game.GameState;

import java.io.BufferedReader;

public class GameRunner {

    private final Game game;
    private final BufferedReader bufferedReader;
    private final GameOutput gameOutput;

    public GameRunner(Game game, BufferedReader bufferedReader, GameOutput gameOutput) {
        this.game = game;
        this.bufferedReader = bufferedReader;
        this.gameOutput = gameOutput;
        start();
    }

    @SneakyThrows
    private void start() {
        gameOutput.print(game.getBoard());
        while (!isGameFinished()) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String[] split = line.split(" ");
            game.turn(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            gameOutput.print(game.getBoard());
        }
    }

    private boolean isGameFinished() {
        return game.getState().equals(GameState.X_WON)
                || game.getState().equals(GameState.O_WON)
                || game.getState().equals(GameState.DRAW);
    }
}
