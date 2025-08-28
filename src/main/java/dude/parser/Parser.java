package dude.parser;

import dude.command.*;

public class Parser {
    public static Command parse(String input) {
        int firstSpace = input.indexOf(" ");
        String cmd = firstSpace == -1 ? input : input.substring(0, firstSpace);
        String args = firstSpace != -1 && firstSpace + 1 < input.length()
                      ? input.substring(firstSpace + 1)
                      : "";

        return switch (cmd) {
            case "bye"      ->  new ExitCommand();
            case "list"     ->  new ListCommand();
            case "todo"     ->  new AddTodoCommand(args);
            case "deadline" ->  new AddDeadlineCommand(args);
            case "event"    ->  new AddEventCommand(args);
            case "mark"     ->  new MarkCommand(args);
            case "unmark"   ->  new UnmarkCommand(args);
            case "delete"   ->  new DeleteCommand(args);
            case "find"     ->  new FindCommand(args);
            default         ->  new InvalidCommand();
        };
    }
}
