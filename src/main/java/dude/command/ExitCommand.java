package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;

/**
 * Command to exit the program.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super("");
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        return "bye!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
