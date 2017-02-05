package mob.tdd;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleCommandReader {

    private Game game;
    private BufferedReader bufferedReader;

    public ConsoleCommandReader(Game game, BufferedReader bufferedReader) {
        this.game = game;
        this.bufferedReader = bufferedReader;
        start();
    }

    private void start() {
        while (!isGameFinished()) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                String[] split = line.split(" ");
                game.turn(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
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
