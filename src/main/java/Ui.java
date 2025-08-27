import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    // Wraps message between horizontal lines and prints it
    public void printMessage(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    public void printWelcome() {
        printMessage("Hello! I'm Dude.\nWhat can I do for you?");
    }

    public void printBye() {
        printMessage("Bye. Hope to see you again soon!");
    }

    public String read() {
        System.out.print(": ");
        return scanner.nextLine().trim();
    }
}
