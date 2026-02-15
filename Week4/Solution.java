import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
        // Example usage of Recursion class
        Recursion recursion = new Recursion();
        System.out.println("Enter the number of stairs:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Number of ways to climb " + n + " stairs: " + recursion.stairArchitect(n));

        System.out.println("Enter a string to check for palindrome:");
        String str = scanner.next();    
        System.out.println("Is palindrome: " + recursion.isPalindrome(str, 0, str.length() - 1));

        System.out.println("Enter a string to generate subsets:");
        str = scanner.next();   
        java.util.List<String> subsets = recursion.generateSubsets(str, 0, new java.util.ArrayList<>(), "");
        System.out.println("Subsets: " + subsets);

        System.out.println("Enter digits to generate codes (space separated):");
        scanner.nextLine(); // consume newline
        int[] digits = new int[3];
        System.out.println("Enter 3 digits:");
        for (int i = 0; i < 3; i++) {
            digits[i] = scanner.nextInt();
        }
        List<Integer> codes = new java.util.ArrayList<>();
        recursion.generateCodes(digits, new boolean[digits.length], codes ,"");
        System.out.println("Generated codes: " + codes);

        System.out.println("Enter a string to compress:");
        scanner.nextLine(); // consume newline  
        str = scanner.nextLine();
        System.out.println("Compressed string: " + recursion.compressString(str));

        System.out.println("Enter no. of items:");
        int items = scanner.nextInt();
        int[] amounts = new int[items];
        System.out.println("Enter the amounts:");
        for (int i = 0; i < items; i++) {
            amounts[i] = scanner.nextInt();
        }
        System.out.println("Enter target amount:");
        int target = scanner.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion.combinationSum(amounts, target, res , temp  , 0);
        System.out.println("Number of ways to make change: " + res.size());
        System.out.println("Combinations: " + res);

        System.out.println("Enter no. of Dolls");
        int dolls = scanner.nextInt();
        for(int i=0;i<dolls;i++){
            System.out.println("Enter the size of" + (i+1) + " Doll:");
            int size = scanner.nextInt();
            System.out.println("Does doll have key? (true/false):");
            boolean hasKey = scanner.nextBoolean();
            Doll innerDoll = null;
            if(i>0){    
                innerDoll = new Doll(size, hasKey, null);
            }
            Doll doll = new Doll(size, hasKey, innerDoll);
            if(i==dolls-1){
                doll.findKey();
            }
        }

        System.out.println("Enter maze size (n x n):");
        int mazeSize = scanner.nextInt();
        int[][] maze = new int[mazeSize][mazeSize];
        System.out.println("Enter maze row by row (0 for blocked, 1 for open):");
        for(int i=0;i<mazeSize;i++){
            for(int j=0;j<mazeSize;j++){
                maze[i][j] = scanner.nextInt();
            }
        }
        boolean pathExists = Maze.isPath(maze, 0, 0);
        System.out.println("Path exists from start to end: " + pathExists);

        System.out.println("Building Project Task Hierarchy:");
        Task mainTask = new Task("Main Project");
        Task subTask1 = new Task("Design Phase");
        Task subTask2 = new Task("Implementation Phase");
        Task subTask3 = new Task("Testing Phase");
        mainTask.addSubTask(subTask1);
        mainTask.addSubTask(subTask2);
        mainTask.addSubTask(subTask3);
        Task subSubTask1 = new Task("Unit Testing");
        Task subSubTask2 = new Task("Integration Testing");
        subTask3.addSubTask(subSubTask1);
        subTask3.addSubTask(subSubTask2);
        ProjectBuilder.printTasks(mainTask, 0);

        System.out.println("Enter the name and wealth of a person:");
        String name = scanner.next();
        int wealth = scanner.nextInt();
        Person person = new Person(name, wealth);
        System.out.println("Enter the number of children:");
        int childrenCount = scanner.nextInt();
        for (int i = 0; i < childrenCount; i++) {
            System.out.println("Enter the name and wealth of child " + (i + 1) + ":");
            String childName = scanner.next();
            int childWealth = scanner.nextInt();
            Person child = new Person(childName, childWealth);
            person.addChild(child);
        }
        System.out.println("Total legacy wealth: " + PersonLegacyCalculator.calculateLegacy(person));
        scanner.close();
    }
}
