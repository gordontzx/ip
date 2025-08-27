package dude.command;

import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {}

    @Override
    public boolean isExit() {
        return true;
    }
}
