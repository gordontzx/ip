package dude.parser;

import dude.command.AddDeadlineCommand;
import dude.command.AddEventCommand;
import dude.command.AddTodoCommand;
import dude.command.Command;
import dude.command.DeleteCommand;
import dude.command.ExitCommand;
import dude.command.FindCommand;
import dude.command.InvalidCommand;
import dude.command.ListCommand;
import dude.command.MarkCommand;
import dude.command.UnmarkCommand;

/**
 * Contains method(s) that parse commands sent by the user.
 */
public class Parser {
    /**
     * Parses user command.
     *
     * @param input Full command sent by user.
     * @return Command object that represents the command to be executed.
     */
    public static Command parse(String input) {
        String[] parts = splitInput(input);
        String cmd = parts[0];
        String args = parts[1];

        assert !cmd.contains(" ") : "Command keyword contains no spaces.";
        assert cmd.length() + args.length() <= input.length() : "Length of cmd and args do not exceed length of input.";

        assert !cmd.contains(" ") : "Command keyword contains no spaces.";
        assert cmd.length() + args.length() <= input.length() : "Length of cmd and args do not exceed length of input.";

        return switch (cmd) {
        case "bye" -> new ExitCommand();
        case "list" -> new ListCommand();
        case "todo" -> new AddTodoCommand(args);
        case "deadline" -> new AddDeadlineCommand(args);
        case "event" -> new AddEventCommand(args);
        case "mark" -> new MarkCommand(args);
        case "unmark" -> new UnmarkCommand(args);
        case "delete" -> new DeleteCommand(args);
        case "find" -> new FindCommand(args);
        default -> new InvalidCommand();
        };
    }

    /**
     * Split input into cmd and arg parts.
     * @param input user input.
     * @return array containing the parts.
     */
    private static String[] splitInput(String input) {
        int firstSpace = input.indexOf(" ");

        boolean hasSpace = firstSpace != -1;
        boolean hasTrailingCharsAfterFirstSpace = firstSpace + 1 < input.length();

        String cmd = hasSpace ? input.substring(0, firstSpace) : input;
        String args = hasSpace && hasTrailingCharsAfterFirstSpace
                ? input.substring(firstSpace + 1)
                : "";

        return new String[]{cmd, args};
    }
}
