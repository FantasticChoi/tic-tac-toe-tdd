package mob.tdd.game.fake;

import lombok.Getter;

import java.io.OutputStream;
import java.io.PrintStream;

public class FakePrintStream extends PrintStream {

    @Getter
    private String printedString;

    public FakePrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void print(String s) {
        printedString = s;
    }
}
