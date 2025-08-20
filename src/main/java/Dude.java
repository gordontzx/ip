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

    private static void printAddedTask(Task task) {
        printMessage(String.format("Got it. I've added this task:\n  %s\nYou now have %d tasks in the list",
                                    task,
                                    list.size()));
    }

    private static void addTodoTask(String taskDesc) {
        if (taskDesc.isEmpty()) {
            printMessage("Error! Usage: todo TASK_NAME");
            return;
        }

        TodoTask t = new TodoTask(taskDesc);
        list.add(t);
        printAddedTask(t);
    }

    private static void addDeadlineTask(String taskDesc) {
        String[] parts = taskDesc.split(" /by ");
        if (parts.length != 2) {
            printMessage("Error! Usage: deadline TASK_NAME /by DEADLINE");
            return;
        }

        DeadlineTask t = new DeadlineTask(parts[0], parts[1]);
        list.add(t);
        printAddedTask(t);
    }

    private static void addEventTask(String taskDesc) {
        String[] parts1 = taskDesc.split(" /from ");
        if (parts1.length != 2) {
            printMessage("Error! Usage: event TASK_NAME /from START /to END");
            return;
        }
        String[] parts2 = parts1[1].split(" /to ");
        if (parts2.length != 2) {
            printMessage("Error! Usage: event TASK_NAME /from START /to END");
            return;
        }

        EventTask t = new EventTask(parts1[0], parts2[0], parts2[1]);
        list.add(t);
        printAddedTask(t);
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

    private static void processCommand(String cmd, String arg) {
        if (cmd.equals("list")) {
            printList();
        } else if (cmd.equals("todo")) {
            addTodoTask(arg);
        } else if (cmd.equals("deadline")) {
            addDeadlineTask(arg);
        } else if (cmd.equals("event")) {
            addEventTask(arg);
        } else if (cmd.equals("mark")) {
            try {
                markAsDone(Integer.parseInt(arg));
            } catch (NumberFormatException e) {
                printMessage("Error! Usage: mark TASK_INDEX");
            }
        } else if (cmd.equals("unmark")) {
            try {
                unmarkAsDone(Integer.parseInt(arg));
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
            String cmd = firstSpace == -1 ? input : input.substring(0, firstSpace);
            String arg = firstSpace != -1 && firstSpace + 1 < input.length()
                                ? input.substring(firstSpace + 1)
                                : "";

            if (cmd.equals("bye")) { break; }
            processCommand(cmd, arg);
        }
        scanner.close();

        printMessage("Bye. Hope to see you again soon!");
    }
}
