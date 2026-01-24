// @filename - Main.java
// @description - Menu-driven program for Week 6 Story
// @author - Divyansh Tak

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- WEEK 6 ASSIGNMENT ---");
                System.out.println("1. Minimum Time to Complete All Tasks");
                System.out.println("2. Dijkstra Using Adjacency Matrix");
                System.out.println("3. Detect Cycle in Directed Graph");
                System.out.println("4. Minimum Cost Path in Grid");
                System.out.println("5. Strongly Connected Components Count");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.print("Enter number of tasks: ");
                        int n = sc.nextInt();
                        int time[] = new int[n];
                        for(int i = 0;i < n;i++){

                            time[i] = sc.nextInt();
                        }

                        System.out.print("Enter number of dependencies: ");
                        int e = sc.nextInt();
                        int edges[][] = new int[e][2];

                        for(int i = 0;i < e;i++) {

                            edges[i][0] = sc.nextInt();
                            edges[i][1] = sc.nextInt();

                        }

                        System.out.println("Minimum Time = " + Method.minTimeTasks(time, edges, n));
                        break;

                    case 2:
                        System.out.print("Enter number of vertices: ");
                        int v = sc.nextInt();
                        int mat[][] = new int[v][v];

                        for(int i = 0;i < v;i++){
                            for (int j = 0;j < v;j++){

                                mat[i][j] = sc.nextInt();

                            }
                        }

                        System.out.print("Enter source: ");
                        int src = sc.nextInt();
                        int dist[] = Method.dijkstraMatrix(mat, src);
                        System.out.println(Arrays.toString(dist));
                        break;

                    case 3:
                        System.out.print("Enter number of nodes: ");
                        int nNodes = sc.nextInt();
                        System.out.print("Enter number of edges: ");
                        int eEdges = sc.nextInt();
                        int ed[][] = new int[eEdges][2];
                        
                        for(int i = 0;i < eEdges;i++) {

                            ed[i][0] = sc.nextInt();
                            ed[i][1] = sc.nextInt();

                        }

                        System.out.println(Method.hasCycle(nNodes, ed));
                        break;

                    case 4:
                        System.out.print("Enter rows: ");
                        int r = sc.nextInt();
                        System.out.print("Enter cols: ");
                        int c = sc.nextInt();

                        int grid[][] = new int[r][c];

                        for(int i = 0;i < r;i++){
                            for(int j = 0;j < c; j++){

                                grid[i][j] = sc.nextInt();

                            }
                        }

                        System.out.println("Minimum Cost = " + Method.minCostGrid(grid));
                        break;

                    case 5:
                        System.out.print("Enter number of nodes: ");
                        int sNodes = sc.nextInt();
                        System.out.print("Enter number of edges: ");
                        int sEdges = sc.nextInt();

                        int sed[][] = new int[sEdges][2];

                        for(int i = 0;i < sEdges;i++) {
                            sed[i][0] = sc.nextInt();
                            sed[i][1] = sc.nextInt();
                        }

                        System.out.println("SCC Count = " + Method.countSCC(sNodes, sed));
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}
