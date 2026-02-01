// @filename - Method.java
// @description - Recursive and backtracking solutions for Week 4 Story
// @author - Divyansh Tak

import java.util.*;

public class Method {

    //Russian Doll Mystery
    static boolean findKey(int size) {
        if(size == 1){
            return true;
        }

        return findKey(size - 1);
    }

    //Staircase Architect
    static int countWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }

        return countWays(n - 1) + countWays(n - 2);
    }

    //Digital Ancestry Tree
    static int calculateLegacy(int wealth, int children[], int idx) {

        if(idx == children.length){
            return wealth;
        }

        return calculateLegacy(wealth + children[idx], children, idx + 1);
    }

    //Word Mirror
    static boolean isPalindrome(String s, int l, int r) {

        if(l >= r){
            return true;
        }

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return isPalindrome(s, l + 1, r - 1);
    }

    //Maze Runner
    static boolean pathExists(int maze[][], int i, int j) {

        int n = maze.length;

        if(i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0){
            return false;
        }

        if(i == n - 1 && j == n - 1){
            return true;
        }

        maze[i][j] = 0;

        return pathExists(maze, i + 1, j) || pathExists(maze, i, j + 1);

    }

    //Perfect Team Assembly
    static void generateSubsets(String arr[], int idx,ArrayList<String> temp,ArrayList<ArrayList<String>> result) {

        if (idx == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        generateSubsets(arr, idx + 1, temp, result);

        temp.add(arr[idx]);
        generateSubsets(arr, idx + 1, temp, result);
        temp.remove(temp.size() - 1);
    }

    //Secure Vault Code
   static void generatePermutations(int arr[],boolean visit[],StringBuilder sb,ArrayList<String> result) {

     
     if (sb.length() == arr.length) {
         result.add(sb.toString());
         return;
      }

       for (int i = 0; i < arr.length; i++) {
           if (!visit[i]) {
              visit[i] = true;

            // include
            sb.append(arr[i]);

            // exclude
            generatePermutations(arr,visit, sb, result);

            // backtrack
            sb.deleteCharAt(sb.length() - 1);
            visit[i] = false;
          }
        }

     }


    //String Tiling Challenge
    static String compressString(String s, int idx) {
        if(idx == s.length()){
            return "";
        }

        char ch = s.charAt(idx);
        int count = 1;
        int i = idx + 1;

        while (i < s.length() && s.charAt(i) == ch) {
            count++;
            i++;
        }

        return count + "" + ch + compressString(s, i);
    }

    //Budget Calculator
    static void combinationSum(int arr[], int target, int idx,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (idx == arr.length || target < 0)
            return;

        temp.add(arr[idx]);
        combinationSum(arr, target - arr[idx], idx, temp, result);
        temp.remove(temp.size() - 1);

        combinationSum(arr, target, idx + 1, temp, result);
    }

    //Project Builder Blueprint
    static void printTasks(String tasks[], int idx, int level) {
        if (idx == tasks.length){
            return;
        }

        for (int i = 0; i < level; i++)
            System.out.print("  ");

        System.out.println(tasks[idx]);
        printTasks(tasks, idx + 1, level + 1);

    }
}
