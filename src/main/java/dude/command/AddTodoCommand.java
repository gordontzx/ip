package dude.command;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.task.TodoTask;
import dude.ui.Ui;

/**
 * Command that adds todo tasks.
 */
public class AddTodoCommand extends AddCommand {
    public AddTodoCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws InvalidArgumentException {
        if (args.isEmpty()) {
            throw new InvalidArgumentException("Error! Usage: todo TASK_NAME");
        }

        ui.print(tasks.add(new TodoTask(args)));
        storage.write(tasks.toCsvString());
    }

}
