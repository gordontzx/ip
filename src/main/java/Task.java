public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public char getStatusIcon() {
        return isDone ? 'X' : ' ';
    }

    @Override
    public String toString() {
        return String.format("[%c] %s", getStatusIcon(), description);
    }
}
