package dude.command;

import java.time.format.DateTimeParseException;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.task.DeadlineTask;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that adds deadline tasks.
 */
public class AddDeadlineCommand extends AddCommand {
    public AddDeadlineCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String[] parts = args.split(" /by ");
        if (parts.length != 2) {
            throw new InvalidArgumentException("Error! Usage: deadline TASK_NAME /by YYYY-MM-DD");
        }

        try {
            String res = tasks.add(new DeadlineTask(parts[0], parts[1]));
            storage.write(tasks.toCsvString());
            return res;
        } catch (DateTimeParseException e) {
            throw new InvalidArgumentException("Invalid Date! Usage: deadline TASK_NAME /by YYYY-MM-DD");
        }
    }
}
