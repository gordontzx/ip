package dude.task;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Represents deadline tasks.
 */
public class DeadlineTask extends Task {
    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private LocalDate deadline;

    public DeadlineTask(String description, String deadline) {
        this(description, false, deadline);
    }

    public DeadlineTask(String description, boolean isDone, String deadline) throws DateTimeParseException  {
        super(description, isDone);
        this.deadline = LocalDate.parse(deadline);
    }

    private String getPrettyDate() {
        return String.format("%s %d %d",
                MONTHS[deadline.getMonthValue() - 1],
                deadline.getDayOfMonth(),
                deadline.getYear());
    }

    @Override
    public String toCsvString() {
        return String.format("D,%s,%s", super.toCsvString(), deadline);
    }

    @Override
    public String toString() {
        return String.format("%s%s (by: %s)", "[D]", super.toString(), getPrettyDate());
    }
}
