public class DeadlineTask extends Task {
    private String deadline;

    public DeadlineTask(String description, String deadline) {
        this(description, false, deadline);
    }

    public DeadlineTask(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }


    @Override
    public String toString() {
        return String.format("%s%s (by: %s)", "[D]", super.toString(), deadline);
    }
}
