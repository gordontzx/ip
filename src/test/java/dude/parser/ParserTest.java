package dude.parser;

import dude.command.Command;
import dude.command.ExitCommand;
import dude.command.InvalidCommand;
import dude.command.ListCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ParserTest {
    @Test
    public void parseListCommandTest() {
        assertInstanceOf(ListCommand.class, Parser.parse("list"));
    }

    @Test
    public void parseExitCommandTest() {
        assertInstanceOf(ExitCommand.class, Parser.parse("bye"));
    }

    @Test
    public void parseReturnsCommandTest() {
        assertInstanceOf(Command.class, Parser.parse("todo event"));
    }

    @Test
    public void parseInvalidCommandTest() {
        assertInstanceOf(InvalidCommand.class, Parser.parse("aksldjf"));
    }
}
