package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that lists stored tasks.
 */
public class ListCommand extends Command {
    public ListCommand() {
        super("");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.print(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
