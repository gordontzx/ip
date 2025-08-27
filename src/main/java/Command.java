public abstract class Command {
    protected String args;

    public Command(String args) {
        this.args = args;
    }

    public abstract void execute(TaskList tasks, Ui ui) throws DudeException;

    public abstract boolean isExit();
}
