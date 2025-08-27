public class InvalidCommand extends Command {
    public InvalidCommand() {
        super("");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.print("Unknown command!");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
