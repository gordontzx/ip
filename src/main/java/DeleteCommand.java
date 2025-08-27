public class DeleteCommand extends Command {
    public DeleteCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        try {
            ui.print(tasks.deleteTask(Integer.parseInt(args)));
        } catch (NumberFormatException e) {
            ui.print("Error! Usage: delete TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
