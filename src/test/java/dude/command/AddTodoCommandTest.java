package dude.command;

import dude.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTodoCommandTest {
    @Test
    public void isExitTest() {
        assertFalse(new AddTodoCommand("").isExit());
    }

    @Test
    public void invalidCommandTest() {
        AddTodoCommand invalidArgs = new AddTodoCommand("");
        assertThrows(InvalidArgumentException.class,
                () -> invalidArgs.execute(null, null, null));
    }
}
