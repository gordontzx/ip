public class UnmarkCommand extends Command {
    public UnmarkCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            ui.print(tasks.unmarkAsDone(Integer.parseInt(args)));
        } catch (NumberFormatException e) {
            ui.print("Error! Usage: unmark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
