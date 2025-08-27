public class Dude {
    private Ui ui;
    private TaskList tasks;

    public Dude() {
        this.ui = new Ui();
        this.tasks = new TaskList();
    }

    private void processCommand(String cmd, String arg) {
        try {
            switch (cmd) {
                case "list" ->      ui.printMessage(tasks.toString());
                case "todo" ->      ui.printMessage(tasks.addTodoTask(arg));
                case "deadline" ->  ui.printMessage(tasks.addDeadlineTask(arg));
                case "event" ->     ui.printMessage(tasks.addEventTask(arg));
                case "mark" ->      ui.printMessage(tasks.markAsDone(arg));
                case "unmark" ->    ui.printMessage(tasks.unmarkAsDone(arg));
                case "delete" ->    ui.printMessage(tasks.deleteTask(arg));
                default ->          ui.printMessage("Unknown command!");
            }
        } catch (InvalidArgumentsException e) {
            ui.printMessage(e.getMessage());
        }
    }

    private void run() {
        ui.printWelcome();

        while (true) {
            String input = ui.read();

            // Split input into command and argument
            int firstSpace = input.indexOf(" ");
            String cmd = firstSpace == -1 ? input : input.substring(0, firstSpace);
            String arg = firstSpace != -1 && firstSpace + 1 < input.length()
                    ? input.substring(firstSpace + 1)
                    : "";

            if (cmd.equals("bye")) {
                break;
            }
            processCommand(cmd, arg);
        }

        ui.printBye();
    }

    public static void main(String[] args) {
        new Dude().run();
    }
}
