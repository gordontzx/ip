import java.time.format.DateTimeParseException;

public class AddDeadlineCommand extends AddCommand {
    public AddDeadlineCommand(String args) {
        super(args);
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        String[] parts = args.split(" /by ");
        if (parts.length != 2) {
            throw new InvalidArgumentsException("Error! Usage: deadline TASK_NAME /by YYYY-MM-DD");
        }

        try {
            ui.print(tasks.add(new DeadlineTask(parts[0], parts[1])));
        } catch (DateTimeParseException e) {
            throw new InvalidArgumentsException("Invalid Date! Usage: deadline TASK_NAME /by YYYY-MM-DD");
        }
    }
}
