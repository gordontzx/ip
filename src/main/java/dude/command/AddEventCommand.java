package dude.command;

import dude.exception.InvalidArgumentException;
import dude.storage.Storage;
import dude.task.EventTask;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command that adds event tasks.
 */
public class AddEventCommand extends AddCommand {
    public AddEventCommand(String arg) {
        super(arg);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        int fromIndex = args.indexOf(" /from ");
        int toIndex = args.indexOf(" /to ");
        if (fromIndex == -1 || toIndex == -1
                || fromIndex == 0 || toIndex == args.length() - 5 || fromIndex == toIndex - 7) {
            throw new InvalidArgumentException("Error! Usage: event TASK_NAME /from START /to END");
        }

        String taskName = args.substring(0, fromIndex);
        String start = args.substring(fromIndex + 7, toIndex);
        String end = args.substring(toIndex + 5);
        String res = tasks.add(new EventTask(taskName, start, end));
        storage.write(tasks.toCsvString());
        return res;
    }
}
