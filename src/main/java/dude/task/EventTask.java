package dude.task;

public class EventTask extends Task {
    private String start;
    private String end;

    public EventTask(String description, String start, String end) {
        this(description, false, start, end);
    }

    public EventTask(String description, boolean isDone, String start, String end) {
        super(description, isDone);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toCsvString() {
        return String.format("E,%s,%s,%s", super.toCsvString(), start, end);
    }

    @Override
    public String toString() {
        return String.format("%s%s (from: %s to: %s)", "[E]", super.toString(), start, end);
    }
}
