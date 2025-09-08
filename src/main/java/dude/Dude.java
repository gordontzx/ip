package dude;

import dude.command.Command;
import dude.exception.DudeException;
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
     * @param cmd Command to execute.
     * @return chatbot response.
     */
    public String getResponse(Command cmd) {
        try {
            return cmd.execute(tasks, storage);
        } catch (DudeException e) {
            return e.getMessage();
        }
    }

    /**
     * Get initial hello message.
     * @return hello message.
     */
    public static String getHelloMessage() {
        return "Hello! I'm Dude.\nWhat can I do for you?";
    }
}
