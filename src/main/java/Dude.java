import java.util.ArrayList;
import java.util.Scanner;

public class Dude {
    private static ArrayList<Task> list;

    // Wraps message between horizontal lines and prints it
    private static void printMessage(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    // Print list
    private static void printList() {
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            sb.append("List is empty!");
        }

        for (int i = 0; i < list.size(); ++i) {
            sb.append(String.format("%d.%s", i+1, list.get(i)));
            if (i != list.size() - 1)
                sb.append('\n');
        }
        printMessage(sb.toString());
    }

    private static void markAsDone(int i) {
        if (i < 0 || i > list.size()) {
            printMessage("Invalid task id!");
            return;
        }

        Task task = list.get(i - 1);
        task.markAsDone();
        printMessage("Nice! I've marked this task as done:\n  " + task);
    }

    private static void unmarkAsDone(int i) {
        if (i < 0 || i > list.size()) {
            printMessage("Invalid task id!");
            return;
        }

        Task task = list.get(i - 1);
        task.unmarkAsDone();
        printMessage("Ok, I've marked this task as not done yet:\n  " + task);
    }

    private static void processCommand(String command, String argument) {
        if (command.equals("list")) {
            printList();
        } else if (command.equals("add")) {
            if (argument.isEmpty()) {
                printMessage("Error! Usage: add TASK_NAME");
                return;
            }
            list.add(new Task(argument));
            printMessage("Added: " + argument);
        } else if (command.equals("mark")) {
            try {
                markAsDone(Integer.parseInt(argument));
            } catch (NumberFormatException e) {
                printMessage("Error! Usage: mark TASK_INDEX");
            }
        } else if (command.equals("unmark")) {
            try {
                unmarkAsDone(Integer.parseInt(argument));
            } catch (NumberFormatException e) {
                printMessage("Error! Usage: unmark TASK_INDEX");
            }
        } else {
            printMessage("Unknown command!");
        }
    }

    public static void main(String[] args) {
        printMessage("Hello! I'm Dude.\nWhat can I do for you?");

        // Initialize data structures
        list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(": ");
            String input = scanner.nextLine().trim();

            // Split input into command and argument
            int firstSpace = input.indexOf(" ");
            String command = firstSpace == -1 ? input : input.substring(0, firstSpace);
            String argument = firstSpace != -1 && firstSpace + 1 < input.length()
                                ? input.substring(firstSpace + 1)
                                : "";

            if (command.equals("bye")) { break; }
            processCommand(command, argument);
        }
        scanner.close();

        printMessage("Bye. Hope to see you again soon!");
    }
}
