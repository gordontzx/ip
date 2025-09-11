package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;

import java.util.List;

/**
 * Command that sends help on using commands.
 */
public class HelpCommand extends Command {
    private static final String FORMAT = "help";

    public HelpCommand(String args) {
        super(args);
    }

    public static String getFormat() {
        return FORMAT;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        return HelpCommand.getFormat() + '\n'
                + ListCommand.getFormat() + '\n'
                + ExitCommand.getFormat() + '\n'
                + AddDeadlineCommand.getFormat() + '\n'
                + AddEventCommand.getFormat() + '\n'
                + AddTodoCommand.getFormat() + '\n'
                + MarkCommand.getFormat() + '\n'
                + UnmarkCommand.getFormat() + '\n'
                + DeleteCommand.getFormat() + '\n'
                + FindCommand.getFormat();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
