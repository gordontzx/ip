public class Dude {
    // Wraps message between horizontal lines and prints it
    private static void printMessage(String message) {
        System.out.println("--------------------------------------------------\n"
                + message
                + "\n--------------------------------------------------");
    }

    public static void main(String[] args) {
        printMessage("Hello! I'm Dude.\nWhat can I do for you?");

        printMessage("Bye, Hope to see you again soon!");
    }
}
