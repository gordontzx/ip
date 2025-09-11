package dude.command;

import java.time.format.DateTimeParseException;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.task.DeadlineTask;
import dude.tasklist.TaskList;

/**
 * Command that adds deadline tasks.
 */
public class AddDeadlineCommand extends AddCommand {
    private static final String FORMAT = "deadline TASK_NAME /by YYYY-MM-DD";

    public AddDeadlineCommand(String args) {
        super(args);
    }

    public static String getFormat() {
        return FORMAT;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
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
