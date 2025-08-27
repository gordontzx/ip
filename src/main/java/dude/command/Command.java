package dude.command;

import dude.exception.DudeException;
import dude.storage.Storage;
import dude.tasklist.TaskList;
import dude.ui.Ui;

public abstract class Command {
    protected String args;

    public Command(String args) {
        this.args = args;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DudeException;

    public abstract boolean isExit();
}
