import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
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

    public String add(Task t) {
        tasks.add(t);
        save();
        return String.format("Got it. I've added this task:\n  %s\nYou now have %d task%s in the list.",
                t, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    /**
     * Marks task with given index as done.
     *
     * @param idx the index of the task to be marked (given as a string)
     */
    public String markAsDone(int idx) throws InvalidArgumentsException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.markAsDone();
        save();
        return "Nice! I've marked this task as done:\n  " + task;
    }

    /**
     * Unmarks task with given index as done.
     *
     * @param idx the index of the task to be unmarked (given as a string)
     */
    public String unmarkAsDone(int idx) throws InvalidArgumentsException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        task.unmarkAsDone();
        save();
        return "Ok, I've marked this task as not done yet:\n  " + task;
    }

    /**
     * Deletes task with given index.
     *
     * @param idx the index of the task to be deleted (given as a string)
     */
    public String deleteTask(int idx) throws InvalidArgumentsException {
        if (idx <= 0 || idx > tasks.size()) {
            throw new InvalidArgumentsException("Invalid task id!");
        }

        Task task = tasks.get(idx - 1);
        tasks.remove(idx - 1);
        save();
        return String.format("Noted. I've removed the task:\n  %s\nYou now have %d task%s in the list.",
                task, tasks.size(), tasks.size() == 1 ? "" : "s");
    }

    private void save() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            for (Task t : tasks) {
                fw.write(t.toCsvString() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
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