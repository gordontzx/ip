public class Dude {
    private final Ui ui;
    private final TaskList tasks;

    public Dude() {
        this.ui = new Ui();
        this.tasks = new TaskList();
    }

    private void run() {
        ui.printWelcome();

        while (true) {
            String input = ui.read();
            Command cmd = Parser.parse(input);

            if (cmd.isExit()) {
                break;
            }

            try {
                cmd.execute(tasks, ui);
            } catch (DudeException e) {
                ui.print(e.getMessage());
            }
        }

        ui.printBye();
    }

    public static void main(String[] args) {
        new Dude().run();
    }
}
