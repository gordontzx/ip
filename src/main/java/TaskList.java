import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Storage format:
<type>,<is_done>,<task_name>,[by|from,to]

types:
T: todo task
D: deadline task
E: event task

e.g.
T,1,read book
D,0,return book,June 6th
E,0,project meeting,Aug 6th 2pm,4pm
T,1,join sports club
 */

public class TaskList {
    private static final String FILE_DIR = "data";
    private static final String FILE_PATH = "data/data.txt";
    private static final String DELIMITER = ",";
    List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();

        try {
            // Open file for reading
            File directory = new File(FILE_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(FILE_PATH);
            file.createNewFile();

            // Read data
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                parseFileLine(line);
            }

            scanner.close();
        } catch (IOException e) {
            System.err.println("An error occured while creating the file " + FILE_PATH + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void parseFileLine(String line) {
        String[] parts = line.split(DELIMITER);
        boolean isDone = parts[1].equals("1");
        switch (parts[0]) {
            case "T" -> tasks.add(new TodoTask(parts[2], isDone));
            case "D" -> tasks.add(new DeadlineTask(parts[2], isDone, parts[3]));
            case "E" -> tasks.add(new EventTask(parts[2], isDone, parts[3], parts[4]));
        }
    }

    /**
     * Adds a todo task.
     *
     * @param taskDesc string describing the task to be added.
     * @return a string describing the task added.
     * @throws InvalidArgumentsException if taskDesc is empty.
     */
    public String addTodoTask(String taskDesc) throws InvalidArgumentsException {
        if (taskDesc.isEmpty()) {
            throw new InvalidArgumentsException("Error! Usage: todo TASK_NAME");
        }

        TodoTask t = new TodoTask(taskDesc);
        tasks.add(t);
        return String.format("Got it. I've added this task:\n  %s\nYou now have %d task%s in the list.",
                t, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Adds a deadline task.
     *
     * @param taskDesc string describing the task to be added.
     */
    public String addDeadlineTask(String taskDesc) throws InvalidArgumentsException {
        String[] parts = taskDesc.split(" /by ");
        if (parts.length != 2) {
            throw new InvalidArgumentsException("Error! Usage: deadline TASK_NAME /by DEADLINE");
        }

        DeadlineTask t = new DeadlineTask(parts[0], parts[1]);
        tasks.add(t);
        return String.format("Got it. I've added this task:\n  %s\nYou now have %d task%s in the list.",
                t, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Adds an event task.
     *
     * @param taskDesc string describing the task to be added.
     */
    public String addEventTask(String taskDesc) throws InvalidArgumentsException {
        int fromIndex = taskDesc.indexOf(" /from ");
        int toIndex = taskDesc.indexOf(" /to ");
        if (fromIndex == -1 || toIndex == -1
                || fromIndex == 0 || toIndex == taskDesc.length() - 5 || fromIndex == toIndex - 7) {
            throw new InvalidArgumentsException("Error! Usage: event TASK_NAME /from START /to END");
        }

        String taskName = taskDesc.substring(0, fromIndex);
        String start = taskDesc.substring(fromIndex + 7, toIndex);
        String end = taskDesc.substring(toIndex + 5);
        EventTask t = new EventTask(taskName, start, end);
        tasks.add(t);
        return String.format("Got it. I've added this task:\n  %s\nYou now have %d task%s in the list.",
                t, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Marks task with given index as done.
     *
     * @param index the index of the task to be marked (given as a string)
     */
    public String markAsDone(String index) throws InvalidArgumentsException {
        int idx;
        try {
            idx = Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("Error! Usage: mark TASK_INDEX");
        }

        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.markAsDone();
        return "Nice! I've marked this task as done:\n  " + task;
    }

    /**
     * Unmarks task with given index as done.
     *
     * @param index the index of the task to be unmarked (given as a string)
     */
    public String unmarkAsDone(String index) throws InvalidArgumentsException {
        int idx;
        try {
            idx = Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("Error! Usage: unmark TASK_INDEX");
        }

        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.unmarkAsDone();
        return "Ok, I've marked this task as not done yet:\n  " + task;
    }

    /**
     * Deletes task with given index.
     *
     * @param index the index of the task to be deleted (given as a string)
     */
    public String deleteTask(String index) throws InvalidArgumentsException {
        int idx;
        try {
            idx = Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentsException("Error! Usage: delete TASK_INDEX");
        }

        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        tasks.remove(idx - 1);
        return String.format("Noted. I've removed the task:\n  %s\nYou now have %d task%s in the list.",
                task, tasks.size(), tasks.size() == 1 ? "" : "s");
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