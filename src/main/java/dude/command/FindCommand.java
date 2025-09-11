package dude.command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dude.storage.Storage;
import dude.task.Task;
import dude.tasklist.TaskList;

/**
 * Command to find tasks that match a keyword.
 */
public class FindCommand extends Command {
    public FindCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        List<Task> matches = args.isEmpty() ? List.of() : tasks.getMatches(args);

        String body = IntStream.range(0, matches.size())
                .mapToObj(i -> String.format("\n%d.%s", i + 1, matches.get(i).toString()))
                .collect(Collectors.joining());

        return "Here are the matching tasks in your list:" + body;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
