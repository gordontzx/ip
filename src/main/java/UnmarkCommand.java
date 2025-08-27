public class UnmarkCommand extends Command {
    public UnmarkCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.print(tasks.unmarkAsDone(Integer.parseInt(args)));
            storage.write(tasks.toCsvString());
        } catch (NumberFormatException e) {
            ui.print("Error! Usage: unmark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
