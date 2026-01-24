import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the Task with full hierarchy management
 *
 * @author Bhavya Jain
 * @Date 8 Jan 2025
 */
public class Task {
    private String description;
    private List<Task> subTasks;

    public Task(String description) {
        this.description = description;
        subTasks = null;
    }

    public Task(String description, List<Task> subTasks) {
        this.description = description;
        this.subTasks = subTasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void addSubTask(Task task) {
        if (subTasks == null) subTasks = new ArrayList<>();
        subTasks.add(task);
    }
}
