public class MarkCommand extends Command {
    public MarkCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int idx = Integer.parseInt(args);
            ui.print(tasks.markAsDone(idx));
            storage.write(tasks.toCsvString());
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("Error! Usage: mark TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
