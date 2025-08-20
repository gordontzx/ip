import java.util.ArrayList;
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
            String command = scanner.nextLine();

            // User entered "bye", end program loop
            if (command.equals("bye")) { break; }

            if (command.equals("list")) {
                printList();
            } else {
                list.add(command);
                printMessage("Added: " + command);
            }
        }
        scanner.close();

        printMessage("Bye. Hope to see you again soon!");
    }
}
