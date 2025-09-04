package dude;

import dude.command.Command;
import dude.exception.DudeException;
import dude.parser.Parser;
import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Chatbot.
 * Run the program from this file to start the chatbot.
 */
public class Dude {
    private final Ui ui;
    private final TaskList tasks;
    private final Storage storage;

    /**
     * Returns a chatbot object.
     * @param filePath file path for the data file
     */
    public Dude(String filePath) {
        this.ui = new Ui();
        this.tasks = new TaskList();
        this.storage = new Storage(filePath);
        storage.read(tasks);
    }

    private void run() {
        ui.printWelcome();

        while (true) {
            String input = ui.read();
            Command cmd = Parser.parse(input);

            if (cmd.isExit()) {
                break;
            }

            try {
                cmd.execute(tasks, ui, storage);
            } catch (DudeException e) {
                ui.print(e.getMessage());
            }
        }

        ui.printBye();
    }

    public static void main(String[] args) {
        String filePath = "data/data.csv";
        new Dude(filePath).run();
    }
}
