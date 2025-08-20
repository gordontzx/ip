import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dude {
    private static ArrayList<String> list;

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
            sb.append(String.format("%d. %s", i+1, list.get(i)));
            if (i != list.size() - 1)
                sb.append('\n');
        }
        printMessage(sb.toString());
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

            // Process command
            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                printList();
            } else if (command.equals("add")) {
                if (argument.isEmpty()) {
                    printMessage("Error! Usage: add TASK_NAME");
                    continue;
                }
                list.add(argument);
                printMessage("Added: " + argument);
            } else {
                printMessage("Unknown command!");
            }
        }
        scanner.close();

        printMessage("Bye. Hope to see you again soon!");
    }
}
