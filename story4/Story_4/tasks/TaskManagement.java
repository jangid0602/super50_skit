/**
 * Filename-  TaskManagement.java
 * Description- You are building a Task Management app. A "Main Task" can have 
"Sub-tasks," which can also have "Sub-tasks." Write a recursive 
function to print the entire task hierarchy with indentation levels to show 
the nesting.  
 * Author - Nancy Jain
 * Date - 09/01/2026
 */ 
package tasks;

import java.util.Scanner;

public class TaskManagement{

    public static TaskNode buildTask(Scanner scanner){
        System.out.println("Enter Task name:");
        String name = scanner.nextLine();
        TaskNode task = new TaskNode(name);

        System.out.println("Enter number of sub tasks:");
        int Tasknumber = readInt(scanner);

        for(int i = 0 ; i < Tasknumber ; i++){
            task.addSubtask(buildTask(scanner));
        }
        return task;
    }

    public static void print(TaskNode task) {
        printHierarchy(task,0);
    }

    private static void printHierarchy(TaskNode task ,int indentation) {
        if (task == null) return;
        // print indentation
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(task.getName());
        for (TaskNode subTask : task.getSubTasks()) {
            printHierarchy(subTask,indentation + 1);
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine(); 
                return val;
            } else {
                String bad = scanner.nextLine(); // consume the invalid token/line
                System.out.println("Invalid entry: \"" + bad + "\" is not an integer."); 
                System.out.println("Please enter an integer value.");
            }
        }
    }
}

