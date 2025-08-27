package dude.tasklist;

import dude.exception.InvalidArgumentException;
import dude.task.Task;

import java.util.ArrayList;
import java.util.List;



public class TaskList {
    List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public String add(Task t) {
        tasks.add(t);
        return String.format("Got it. I've added this task:\n  %s\nYou now have %d task%s in the list.",
                t, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Marks task with given index as done.
     *
     * @param idx the index of the task to be marked (given as a string)
     */
    public String markAsDone(int idx) throws InvalidArgumentException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.markAsDone();
        return "Nice! I've marked this task as done:\n  " + task;
    }

    /**
     * Unmarks task with given index as done.
     *
     * @param idx the index of the task to be unmarked (given as a string)
     */
    public String unmarkAsDone(int idx) throws InvalidArgumentException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.unmarkAsDone();
        return "Ok, I've marked this task as not done yet:\n  " + task;
    }

    /**
     * Deletes task with given index.
     *
     * @param idx the index of the task to be deleted (given as a string)
     */
    public String deleteTask(int idx) throws InvalidArgumentException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        tasks.remove(idx - 1);
        return String.format("Noted. I've removed the task:\n  %s\nYou now have %d task%s in the list.",
                task, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Returns a csv formatted string for saving
     *
     * @return string in csv format
     */
    public String toCsvString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : tasks) {
            sb.append(t.toCsvString());
            sb.append('\n');
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "List is empty!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d.%s", 1, tasks.get(0)));
        for (int i = 1; i < tasks.size(); ++i) {
            sb.append(String.format("\n%d.%s", i + 1, tasks.get(i)));
        }
        return sb.toString();
    }
}