package dude.command;

import java.util.List;

import dude.storage.Storage;
import dude.task.Task;
import dude.tasklist.TaskList;
import dude.ui.Ui;

/**
 * Command to find tasks that match a keyword.
 */
public class FindCommand extends Command {
    public FindCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> matches = args.isEmpty() ? List.of() : tasks.getMatches(args);
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:");
        int count = 0;
        for (Task task : matches) {
            sb.append(String.format("\n%d.%s", ++count, task.toString()));
        }
        return sb.toString();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
