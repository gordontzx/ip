package dude.command;

import dude.exception.InvalidArgumentException;
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
    public String execute(TaskList tasks, Ui ui, Storage storage) throws InvalidArgumentException {
        try {
            String res = tasks.unmarkAsDone(Integer.parseInt(args));
            storage.write(tasks.toCsvString());
            return res;
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Error! Usage: unmark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
