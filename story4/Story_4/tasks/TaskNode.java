/**
 * Filename - TaskNode.java
 * Description - Data Structure for TaskManagement.java
 * Author - Nancy Jain
 * Date - 09/01/2026
 */
package tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskNode {
    public String name;
    public List<TaskNode> subtasks;

    public TaskNode(String name) {
        this.name = name;
        this.subtasks = new ArrayList<>();
    }

    public void addSubtask(TaskNode task) {
        subtasks.add(task);
    }

    public String getName() {
        return name;
    }

    public List<TaskNode> getSubTasks() {
        return subtasks;
    }
}
