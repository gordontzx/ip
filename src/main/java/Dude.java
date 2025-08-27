import java.util.ArrayList;
import java.util.Scanner;

public class Dude {
    private static TaskList tasks;

    // Wraps message between horizontal lines and prints it
    private static void printMessage(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    private static void processCommand(String cmd, String arg) {
        try {
            if (cmd.equals("list")) {
                printMessage(tasks.toString());
            } else if (cmd.equals("todo")) {
                printMessage(tasks.addTodoTask(arg));
            } else if (cmd.equals("deadline")) {
                printMessage(tasks.addDeadlineTask(arg));
            } else if (cmd.equals("event")) {
                printMessage(tasks.addEventTask(arg));
            } else if (cmd.equals("mark")) {
                printMessage(tasks.markAsDone(arg));
            } else if (cmd.equals("unmark")) {
                printMessage(tasks.unmarkAsDone(arg));
            } else if (cmd.equals("delete")) {
                printMessage(tasks.deleteTask(arg));
            } else {
                printMessage("Unknown command!");
            }
        } catch (InvalidArgumentsException e) {
            printMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        printMessage("Hello! I'm Dude.\nWhat can I do for you?");

        // Initialize data structures
        tasks = new TaskList();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(": ");
            String input = scanner.nextLine().trim();

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
        scanner.close();

        printMessage("Bye. Hope to see you again soon!");
    }
}
