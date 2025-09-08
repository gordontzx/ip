package dude;

import dude.command.Command;
import dude.exception.DudeException;
import dude.parser.Parser;
import dude.storage.Storage;
import dude.tasklist.TaskList;

/**
 * Class that encapsulates the chatbot.
 */
public class Dude {
    private final TaskList tasks;
    private final Storage storage;

    /**
     * Returns a chatbot object.
     * @param filePath file path for the data file
     */
    public Dude(String filePath) {
        this.tasks = new TaskList();
        this.storage = new Storage(filePath);
        storage.read(tasks);
    }

    /**
     * Return response to user input.
     * @param input user input.
     * @return chatbot response.
     */
    public String getResponse(String input) {
        Command cmd = Parser.parse(input);
        if (cmd.isExit()) {
            return "bye!";
        }
        try {
            return cmd.execute(tasks, storage);
        } catch (DudeException e) {
            return e.getMessage();
        }
    }
}
