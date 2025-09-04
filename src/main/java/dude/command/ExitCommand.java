package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command to exit the program.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super("");
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return "bye!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
