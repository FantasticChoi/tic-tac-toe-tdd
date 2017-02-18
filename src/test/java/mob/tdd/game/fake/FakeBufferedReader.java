package mob.tdd.game.fake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;

public class FakeBufferedReader extends BufferedReader {

    private Queue<String> commands = new LinkedList<>();

    public FakeBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        if (!commands.isEmpty()) {
            return commands.poll();
        }
        return null;
    }

    public void addCommandToQueue(String command) {
        commands.add(command);
    }

}
