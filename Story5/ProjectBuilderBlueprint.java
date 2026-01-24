import java.util.*;

/**
 * @Filename-ProjectBuilderBlueprint.java
 * @Description- Manages and displays hierarchical task structures with proper indentation.
 *               Supports nested tasks where main tasks can have sub-tasks, which can also
 *               have their own sub-tasks. Provides utility functions to count tasks and
 *               calculate maximum depth of the hierarchy.
 * @Author-Aman Jeet Singh
 */

public class ProjectBuilderBlueprint {
    
    /**
     * Task class representing a task in the hierarchy
     * Each task can have multiple subtasks (children)
     */
    static class Task {
        String name;
        List<Task> subtasks;
        
        Task(String name) {
            this.name = name;
            this.subtasks = new ArrayList<>();
        }
        
        /**
         * Add a subtask to this task
         */
        public void addSubtask(Task subtask) {
            this.subtasks.add(subtask);
        }
    }
    
    /**
     * Print task hierarchy with indentation
     * Uses recursion to traverse the task tree
     * 
     * @param task The current task to print
     * @param level The indentation level (0 for root tasks)
     */
    public static void printTaskHierarchy(Task task, int level) {
        // Print the current task with proper indentation
        String indent = "  ".repeat(level); // 2 spaces per level
        System.out.println(indent + task.name);
        
        // Recursively print all subtasks at level + 1
        for (Task subtask : task.subtasks) {
            printTaskHierarchy(subtask, level + 1);
        }
    }
    
    /**
     * Print all tasks starting from root level (level 0)
     * Can handle multiple root tasks
     */
    public static void printAllTasks(List<Task> rootTasks) {
        for (Task task : rootTasks) {
            printTaskHierarchy(task, 0);
        }
    }
    
    /**
     * Alternative version: Convert hierarchy to string (useful for testing)
     */
    public static String taskHierarchyToString(Task task, int level) {
        StringBuilder sb = new StringBuilder();
        String indent = "  ".repeat(level);
        sb.append(indent).append(task.name).append("\n");
        
        for (Task subtask : task.subtasks) {
            sb.append(taskHierarchyToString(subtask, level + 1));
        }
        
        return sb.toString();
    }
    
    /**
     * Get total count of tasks in hierarchy (including root)
     */
    public static int countTasks(Task task) {
        int count = 1; // Count current task
        for (Task subtask : task.subtasks) {
            count += countTasks(subtask); // Recursively count subtasks
        }
        return count;
    }
    
    /**
     * Get maximum depth of task hierarchy
     */
    public static int getMaxDepth(Task task) {
        if (task.subtasks.isEmpty()) {
            return 1; // Leaf node has depth 1
        }
        
        int maxSubDepth = 0;
        for (Task subtask : task.subtasks) {
            maxSubDepth = Math.max(maxSubDepth, getMaxDepth(subtask));
        }
        
        return 1 + maxSubDepth; // Add 1 for current level
    }
    
    public static void main(String[] args) {
        
        // Test Case 1: Simple 3-level hierarchy
        // Task: Fix Bugs -> Sub: UI Bugs -> Sub: Button Color
        System.out.println("=== Test Case 1: Simple Hierarchy ===");
        
        Task fixBugs = new Task("Fix Bugs");
        Task uiBugs = new Task("UI Bugs");
        Task buttonColor = new Task("Button Color");
        
        // Build hierarchy
        uiBugs.addSubtask(buttonColor);
        fixBugs.addSubtask(uiBugs);
        
        // Print hierarchy
        printTaskHierarchy(fixBugs, 0);
        System.out.println();
        
        // Test Case 2: More complex hierarchy with multiple branches
        System.out.println("=== Test Case 2: Complex Multi-branch Hierarchy ===");
        
        Task mainProject = new Task("Build Mobile App");
        
        Task frontend = new Task("Frontend Development");
        Task backend = new Task("Backend Development");
        Task testing = new Task("Testing");
        
        Task loginUI = new Task("Login UI");
        Task dashboardUI = new Task("Dashboard UI");
        Task apiEndpoints = new Task("API Endpoints");
        Task database = new Task("Database Setup");
        Task unitTests = new Task("Unit Tests");
        Task integrationTests = new Task("Integration Tests");
        
        // Styling for UI
        Task loginStyling = new Task("CSS Styling");
        Task loginValidation = new Task("Form Validation");
        
        // Build hierarchy
        loginUI.addSubtask(loginStyling);
        loginUI.addSubtask(loginValidation);
        
        frontend.addSubtask(loginUI);
        frontend.addSubtask(dashboardUI);
        
        backend.addSubtask(apiEndpoints);
        backend.addSubtask(database);
        
        testing.addSubtask(unitTests);
        testing.addSubtask(integrationTests);
        
        mainProject.addSubtask(frontend);
        mainProject.addSubtask(backend);
        mainProject.addSubtask(testing);
        
        printTaskHierarchy(mainProject, 0);
        System.out.println();
        
        // Test Case 3: Single deep chain (linear)
        System.out.println("=== Test Case 3: Linear Deep Chain ===");
        
        Task epic = new Task("Epic: Implement Authentication");
        Task feature = new Task("Feature: OAuth Integration");
        Task story = new Task("Story: Add Google Login");
        Task task = new Task("Task: Implement Login Button");
        Task subtask = new Task("Subtask: Add onClick Handler");
        
        epic.addSubtask(feature);
        feature.addSubtask(story);
        story.addSubtask(task);
        task.addSubtask(subtask);
        
        printTaskHierarchy(epic, 0);
        System.out.println();
        
        // Demonstrate other utility functions
        System.out.println("=== Utility Functions ===");
        System.out.println("Total tasks in Test Case 2: " + countTasks(mainProject));
        System.out.println("Max depth in Test Case 2: " + getMaxDepth(mainProject));
        System.out.println("Total tasks in Test Case 3: " + countTasks(epic));
        System.out.println("Max depth in Test Case 3: " + getMaxDepth(epic));
        System.out.println();
        
        // Test Case 4: Multiple root tasks
        System.out.println("=== Test Case 4: Multiple Root Tasks ===");
        
        Task sprint1 = new Task("Sprint 1");
        Task sprint2 = new Task("Sprint 2");
        
        Task task1 = new Task("Task 1.1");
        Task task2 = new Task("Task 1.2");
        Task subtask2 = new Task("Subtask 1.2.1");
        
        Task task3 = new Task("Task 2.1");
        
        sprint1.addSubtask(task1);
        sprint1.addSubtask(task2);
        task2.addSubtask(subtask2);
        
        sprint2.addSubtask(task3);
        
        List<Task> sprints = Arrays.asList(sprint1, sprint2);
        printAllTasks(sprints);
    }
}
