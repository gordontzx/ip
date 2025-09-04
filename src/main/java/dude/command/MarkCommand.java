package dude.command;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that marks a task as done.
 */
public class MarkCommand extends Command {
    public MarkCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws InvalidArgumentException {
        try {
            int idx = Integer.parseInt(args);
            String res = tasks.markAsDone(idx);
            storage.write(tasks.toCsvString());
            return res;
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Error! Usage: mark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
