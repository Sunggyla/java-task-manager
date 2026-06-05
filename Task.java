public class Task {

    int id;
    String title;
    boolean completed;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    @Override
    public String toString() {
        return id + ". " + title + " | Выполнено: " + completed;
    }
}