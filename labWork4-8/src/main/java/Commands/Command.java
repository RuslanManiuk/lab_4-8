package Commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Command {
    public static Logger logger = LoggerFactory.getLogger(Command.class);

    void execute();

    static int parseInt(String input) {
        return Integer.parseInt(input.trim());
    }
}
