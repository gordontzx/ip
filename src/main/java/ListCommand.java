public class ListCommand extends Command {
    public ListCommand() {
        super("");
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.print(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
