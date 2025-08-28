package dude.ui;

import java.util.Scanner;

/**
 * Object that handles user IO.
 */
public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Wraps message between horizontal lines and prints it.
     *
     * @param message
     */
    public void print(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    /**
     * Prints welcome message.
     */
    public void printWelcome() {
        print("Hello! I'm dude.Dude.\nWhat can I do for you?");
    }

    /**
     * Prints goodbye message.
     */
    public void printBye() {
        print("Bye. Hope to see you again soon!");
    }

    /**
     * Reads user input from standard input.
     *
     * @return
     */
    public String read() {
        System.out.print(": ");
        return scanner.nextLine().trim();
    }
}
