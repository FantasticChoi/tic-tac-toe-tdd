package mob.tdd;

import java.io.BufferedReader;
import java.io.IOException;

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

    private void start() {
        gameOutput.print(game.getBoard());
        while (!isGameFinished()) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                String[] split = line.split(" ");
                game.turn(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                gameOutput.print(game.getBoard());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isGameFinished() {
        return game.getState().equals(GameState.X_WON)
                || game.getState().equals(GameState.O_WON)
                || game.getState().equals(GameState.DRAW);
    }
}
