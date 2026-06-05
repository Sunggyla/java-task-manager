import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        manager.loadTasks();

        while (true) {

            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Показать задачи");
            System.out.println("3. Выполнить задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Введите ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введите название задачи: ");
                    String title = scanner.nextLine();

                    manager.addTask(new Task(id, title));

                    System.out.println("Задача добавлена");
                    break;

                case 2:

                    manager.showTasks();
                    break;

                case 3:

                    System.out.print("Введите ID задачи: ");
                    int completeId = scanner.nextInt();

                    manager.completeTask(completeId);

                    System.out.println("Задача выполнена");
                    break;

                case 4:

                    System.out.print("Введите ID задачи: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteTask(deleteId);

                    System.out.println("Задача удалена");
                    break;

                case 5:

                    manager.saveTasks();

                    System.out.println("Задачи сохранены");
                    System.out.println("Выход...");

                    return;

                default:

                    System.out.println("Неверный выбор");
            }
        }
    }
}
