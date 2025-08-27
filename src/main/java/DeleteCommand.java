public class DeleteCommand extends Command {
    public DeleteCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.print(tasks.deleteTask(Integer.parseInt(args)));
            storage.write(tasks.toCsvString());
        } catch (NumberFormatException e) {
            ui.print("Error! Usage: delete TASK_INDEX");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
