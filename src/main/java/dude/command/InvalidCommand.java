package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Object to represent an invalid/unknown command.
 */
public class InvalidCommand extends Command {
    public InvalidCommand() {
        super("");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.print("Unknown command!");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
