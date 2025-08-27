public class MarkCommand extends Command {
    public MarkCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            int idx = Integer.parseInt(args);
            ui.print(tasks.markAsDone(idx));
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("Error! Usage: mark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
