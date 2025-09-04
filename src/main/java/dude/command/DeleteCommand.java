package dude.command;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that deletes a task.
 */
public class DeleteCommand extends Command {
    public DeleteCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws InvalidArgumentException {
        try {
            String res = tasks.deleteTask(Integer.parseInt(args));
            storage.write(tasks.toCsvString());
            return res;
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Error! Usage: delete TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
