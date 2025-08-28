package dude.task;

/**
 * Encapsulates all types of tasks that the program can handle.
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this(description, false);
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a char indicating whether the task is completed.
     *
     * @return 'X' if task is done, ' ' otherwise.
     */
    public char getStatusIcon() {
        return isDone ? 'X' : ' ';
    }

    /**
     * Fetch the task represented as a string for storage in csv format.
     *
     * @return A string in csv format.
     */
    public String toCsvString() {
        return (isDone ? 1 : 0) + "," + description;
    }

    @Override
    public String toString() {
        return String.format("[%c] %s", getStatusIcon(), description);
    }
}
