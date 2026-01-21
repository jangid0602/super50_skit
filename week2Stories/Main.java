/**
 * @Filename - Main.java
 * @Description - Story 2 Tasks 
 *  1. The Trendsetter Score
 *  2. Encoded String Subsets
 *  3. E-Commerce Funnel Analysis
 *  4. Maximal Pair Matching
 *  5. Subarray Color Balance
 *  6. Text Editor Non-Overlapping Replace
 *  7. Log File Compaction
 *  8. E-commerce SKU Normalization
 *  9. Chat Message Redaction
 *  10.Resume Keyword Versioning
 * @Author - Nancy Jain
 */

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("OPERATIONS :");
            System.out.println("1. The Trendsetter Score");
            System.out.println("2. Encoded String Subsets");
            System.out.println("3. E-Commerce Funnel Analysis");
            System.out.println("4. Maximal Pair Matching");
            System.out.println("5. Subarray Color Balance");
            System.out.println("6. Text Editor Non-Overlapping Replace");
            System.out.println("7. Log File Compaction");
            System.out.println("8. E-commerce SKU Normalization");
            System.out.println("9. Chat Message Redaction");
            System.out.println("10. Resume Keyword Versioning");
            System.out.println("11. Quit");
            System.out.println("Enter your choice (1-11): ");

            int choice = readInt(scanner);

            switch (choice) {

                // 1. Trendsetter Score
                case 1 -> {
                    System.out.println("Enter number of posts and window size :");
                    int n = readInt(scanner);
                    int k = readInt(scanner);
                    System.out.println("Enter posts");
                    List<Integer> posts = new ArrayList<>();
                    for(int i = 0; i < n; i++){
                        posts.add(readInt(scanner));
                    }
                    System.out.println("Trendsetter Score : " + MyNumber.TrendsetterScore(posts, k));
                }

                // 2. Encoded String Subsets
                case 2 -> {
                    System.out.println("Enter superstring :");
                    String superstring = scanner.next();
                    System.out.println("Enter substring :");
                    String substring = scanner.next();
                    System.out.println(MyString.encodedSubset(superstring, substring) ? "True" : "False");
                }

                // 3. E-Commerce Funnel
                case 3 -> {
                    System.out.println("Enter number of actions :");
                    int size = readInt(scanner);
                    List<String[]> actions = new ArrayList<>();

                    System.out.println("Enter actions (user,page):");
                    for(int i = 0; i < size; i++) {

                        String line = scanner.nextLine().trim();
                        if(line.isEmpty()) {
                            i--;
                            continue;
                        }

                        if(!line.contains(",")) {
                            System.out.println("Invalid input. Expected format: user,page");
                            i--;
                            continue;
                        }

                        String[] parts = line.split(",");
                        if(parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                            System.out.println("Invalid input. Expected format: user,page");
                            i--;
                            continue;
                        }

                        actions.add(parts);
                    }

                    // ✅ Print result only once after all inputs are collected
                    System.out.println("Most Frequent 2 Step Path : " + MyString.twoStepPath(actions));
                }


                // 4. Maximal Pair Matching
                case 4 -> {
                    System.out.println("Enter number of elements:");
                    int size = readInt(scanner);
                    int[] nums = new int[size];
                    System.out.println("Enter elements:");
                    for(int i=0;i<size;i++) nums[i]=readInt(scanner);
                    System.out.println("Enter target sum:");
                    int target = readInt(scanner);
                    System.out.println("Answer : " + MyNumber.maxPairs(nums,target));
                }

                // 5. Subarray Color Balance
                case 5 -> {
                    System.out.println("Enter number of elements:");
                    int size = readInt(scanner);
                    int[] nums = new int[size];
                    System.out.println("Enter elements (0/1/2):");
                    for(int i=0;i<size;i++) {
                        int num=readInt(scanner);
                        if(num==0||num==1||num==2){
                            nums[i]=num;
                        }else{
                            System.out.println("Invalid Input . Please enter valid input again.");
                            i--;
                        }
                    }
                    System.out.println("Answer : " + MyNumber.longestBalanced(nums));
                }

                // 6. Non-Overlapping Replace
                case 6 -> {
                    System.out.println("Enter text:");
                    String text = scanner.next();
                    System.out.println("Enter string to find:");
                    String find = scanner.next();
                    System.out.println("Enter replacement:");
                    String rep = scanner.next();
                    System.out.println("Modified Text : " + MyString.replaceNonOverlap(text, find, rep));
                }

                // 7. Log File Compaction
                case 7 -> {
                    System.out.println("Enter logs :");
                    String logs = scanner.nextLine();
                    System.out.println("Output: " + MyString.compactLog(logs));
                }

                // 8. SKU Normalization
                case 8 -> {
                    System.out.println("Enter SKU:");
                    String sku = scanner.next();
                    System.out.println("Normalized SKU : " + MyString.normalizeSKU(sku));
                }

                // 9. Chat Redaction
                case 9 -> {
                    System.out.println("Enter message :");
                    String message = scanner.nextLine();
                    System.out.println("Enter number of banned words:");
                    int s = readInt(scanner);
                    List<String> banned = new ArrayList<>();
                    System.out.println("Enter banned words:");
                    for(int i=0;i<s;i++) banned.add(scanner.next());
                    System.out.println("Redacted Message : " + MyString.redact(message, banned));
                }

                // 10. Resume Keyword Versioning
                case 10 -> {
                    System.out.println("Enter size of resume V1 and V2:");
                    int a = scanner.nextInt(), b = scanner.nextInt();
                    List<String> r1 = new ArrayList<>(), r2 = new ArrayList<>();
                    System.out.println("Enter resume V1 keywords:");
                    for(int i=0;i<a;i++) r1.add(scanner.next());
                    System.out.println("Enter resume V2 keywords:");
                    for(int i=0;i<b;i++) r2.add(scanner.next());
                    System.out.println("Output : " + MyString.resumeScore(r1,r2));
                }

                // Quit
                case 11 -> {
                    System.out.println("Do you want to exit? Press 1 for Yes, 0 for No:");
                    int action = scanner.nextInt();
                    if(action == 1){
                        System.out.println("Exiting...");
                        running = false;
                    }
                }
            }
        }
        scanner.close();
    }

    // Safe Integer Input
    private static int readInt(Scanner sc) {
        while(true) {
            if(sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                String bad = sc.nextLine();
                System.out.println("Invalid Input: \""+ bad +"\" is not an Integer. Try again.");
            }
        }
    }
}
