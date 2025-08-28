package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that marks a task as not done.
 */
public class UnmarkCommand extends Command {
    public UnmarkCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.print(tasks.unmarkAsDone(Integer.parseInt(args)));
            storage.write(tasks.toCsvString());
        } catch (NumberFormatException e) {
            ui.print("Error! Usage: unmark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
