import java.util.Scanner;

public class Dude {
    // Wraps message between horizontal lines and prints it
    private static void printMessage(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    public static void main(String[] args) {
        printMessage("Hello! I'm Dude.\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(": ");
            String command = scanner.nextLine();

            // User entered "bye", end program loop
            if (command.equals("bye")) { break; }

            // Temporarily echo user command
            printMessage(command);
        }
        scanner.close();

        printMessage("Bye, Hope to see you again soon!");
    }
}
