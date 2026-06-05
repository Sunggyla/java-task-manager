import java.io.*;
import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.completed = true;
            }
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.id == id);
    }
    public void saveTasks() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {

            for (Task task : tasks) {
                writer.write(task.id + ";" + task.title + ";" + task.completed);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Ошибка сохранения");
        }
    }

    public void loadTasks() {

        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                Task task = new Task(
                        Integer.parseInt(data[0]),
                        data[1]
                );

                task.completed = Boolean.parseBoolean(data[2]);

                tasks.add(task);
            }

        } catch (IOException e) {
            System.out.println("Файл пока не существует");
        }
    }
}