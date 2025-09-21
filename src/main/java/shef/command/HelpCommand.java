package shef.command;

import shef.storage.Storage;
import shef.tasklist.TaskList;

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
        return "Here are the commands you can execute:\n"
                + HelpCommand.getFormat() + '\n'
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
