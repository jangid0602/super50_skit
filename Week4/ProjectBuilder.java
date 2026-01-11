import java.util.*;

class Task {
    String name;
    List<Task> subTasks;

    Task(String name) {
        this.name = name;
        this.subTasks = new ArrayList<>();
    }

    void addSubTask(Task task) {
        subTasks.add(task);
    }
}

public class ProjectBuilder {

    static void printTasks(Task task, int level) {
        // Print indentation
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        // Print task name
        System.out.println(task.name);

        // Recursive call for sub-tasks
        for (Task sub : task.subTasks) {
            printTasks(sub, level + 1);
        }
    }


}
