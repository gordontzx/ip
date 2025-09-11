package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;

/**
 * Command that lists stored tasks.
 */
public class ListCommand extends Command {
    private static final String FORMAT = "list";

    public ListCommand() {
        super("");
    }

    public static String getFormat() {
        return FORMAT;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        return tasks.toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
