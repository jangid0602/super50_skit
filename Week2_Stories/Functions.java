import java.util.*;

public class Functions {

    // 1. The Trendsetter Score
    public void trendsetterScore(Scanner sc){
        try{
            System.out.print("Enter number of posts: ");
            int n = Integer.parseInt(sc.nextLine());
            int[] posts = new int[n];

            System.out.println("Enter post IDs separated by space:");
            String[] arr = sc.nextLine().split(" ");
            for (int i=0; i<n; i++){
                posts[i] = Integer.parseInt(arr[i]);
            }

            System.out.print("Enter window size k: ");
            int k = Integer.parseInt(sc.nextLine());

            int score = 0;

            for (int i=0; i<=n-k; i++){
                int[] freq = new int[1000];
                for (int j=i; j<i+k; j++){
                    freq[posts[j]]++;
                }

                int max=0, count=0;
                for (int f:freq){
                    if (f>max) max=f;
                }
                for (int f:freq){
                    if (f==max) count++;
                }

                if (count==1) score++;
            }

            System.out.println("Trendsetter Score: " + score);
        }catch(NumberFormatException e){
            System.out.println("Please enter valid numbers only!");
        }catch(Exception e){
            System.out.println("Something went wrong. Try again.");
        }
    }

    // 2. Encoded String Subsets
    public void encodedSubset(Scanner sc){
        try{
            System.out.print("Enter superstring: ");
            String s1 = sc.nextLine();
            System.out.print("Enter substring: ");
            String s2 = sc.nextLine();

            boolean found=false;
            for (int i=0; i<=s1.length()-s2.length(); i++){
                String part = s1.substring(i, i+s2.length());
                if (checkSameLetters(part, s2)){
                    found=true;
                    break;
                }
            }

            System.out.println(found ? "true" : "false");
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    private boolean checkSameLetters(String a, String b){
        int[] count = new int[26];
        for (char c:a.toCharArray()) count[c-'a']++;
        for (char c:b.toCharArray()) count[c-'a']--;
        for (int x:count) if (x!=0) return false;
        return true;
    }

    // 3. E-Commerce Funnel Analysis
    public void ecommerceFunnel(Scanner sc){
        try{
            System.out.print("Enter number of actions: ");
            int n = Integer.parseInt(sc.nextLine());
            String[] actions = new String[n];

            System.out.println("Enter actions (userID,pageID):");
            for (int i=0; i<n; i++){
                actions[i] = sc.nextLine();
            }

            String bestPath="";
            int bestCount=0;

            for (int i=0; i<n-1; i++){
                String[] a1 = actions[i].split(",");
                String[] a2 = actions[i+1].split(",");
                if (a1[0].equals(a2[0])){
                    String path = a1[1]+","+a2[1];
                    int count=0;
                    for (int j=0; j<n-1; j++){
                        String[] b1 = actions[j].split(",");
                        String[] b2 = actions[j+1].split(",");
                        if (b1[0].equals(b2[0]) && (b1[1]+","+b2[1]).equals(path)){
                            count++;
                        }
                    }
                    if (count>bestCount || (count==bestCount && path.compareTo(bestPath)<0)){
                        bestPath=path;
                        bestCount=count;
                    }
                }
            }

            System.out.println("Most frequent path: " + bestPath);
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 4. Maximal Pair Matching
    public void maxPairMatching(Scanner sc){
        try{
            System.out.print("Enter array size: ");
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = new int[n];

            System.out.println("Enter array elements:");
            String[] input = sc.nextLine().split(" ");
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            System.out.print("Enter target sum: ");
            int k = Integer.parseInt(sc.nextLine());

            boolean[] used = new boolean[n];
            int pairs=0;

            for (int i=0; i<n; i++){
                if (used[i]) continue;
                for (int j=i+1; j<n; j++){
                    if (!used[j] && arr[i]+arr[j]==k){
                        pairs++;
                        used[i]=true;
                        used[j]=true;
                        break;
                    }
                }
            }

            System.out.println("Max pairs: " + pairs);
        }catch(NumberFormatException e){
            System.out.println("Please enter valid numbers only!");
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 5. Subarray Color Balance
    public void colorBalance(Scanner sc){
        try{
            System.out.print("Enter array size: ");
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = new int[n];

            System.out.println("Enter elements (0,1,2):");
            String[] a = sc.nextLine().split(" ");
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(a[i]);
            }

            int max=0;
            for (int i=0; i<n; i++){
                int red=0, blue=0;
                for (int j=i; j<n; j++){
                    if (arr[j]==1) red++;
                    if (arr[j]==2) blue++;
                    if (red==blue && red>0){
                        int len = j-i+1;
                        if (len>max) max=len;
                    }
                }
            }

            System.out.println("Longest balanced subarray length: " + max);
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 6. Text Editor Non-Overlapping Replace
    public void textReplace(Scanner sc){
        try{
            System.out.print("Enter text: ");
            String text = sc.nextLine();
            System.out.print("Enter word to find: ");
            String find = sc.nextLine();
            System.out.print("Enter word to replace with: ");
            String repl = sc.nextLine();

            String result="";
            int i=0;

            while (i<text.length()){
                if (i+find.length()<=text.length() && text.substring(i, i+find.length()).equals(find)){
                    result += repl;
                    i += find.length();
                }else{
                    result += text.charAt(i);
                    i++;
                }
            }

            System.out.println("Result: " + result);
        }catch(Exception e){
            System.out.println("Something went wrong!");
        }
    }

    // 7. Log File Compaction
    public void logCompaction(Scanner sc){
        try{
            System.out.print("Enter log levels (space-separated): ");
            String[] logs = sc.nextLine().split(" ");
            String result="";
            int count=1;

            for (int i=1; i<=logs.length; i++){
                if (i<logs.length && logs[i].equals(logs[i-1])){
                    count++;
                }else{
                    result += logs[i-1] + "(" + count + ") ";
                    count=1;
                }
            }

            System.out.println("Compacted logs: " + result.trim());
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 8. SKU Normalization
    public void skuNormalization(Scanner sc){
        try{
            System.out.print("Enter SKU: ");
            String sku = sc.nextLine().toUpperCase();
            String[] parts = sku.split("-");

            if (parts.length!=3){
                System.out.println("INVALID");
                return;
            }

            String cat = parts[0];
            String id = parts[1];
            String size = parts[2];

            boolean valid=true;

            if (cat.length()<3 || cat.length()>4) valid=false;
            if (id.length()<4 || id.length()>6) valid=false;
            for (int i=0; i<id.length(); i++){
                if (!Character.isDigit(id.charAt(i))) valid=false;
            }
            if (!(size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL"))) valid=false;

            if (valid){
                System.out.println(cat + "-" + id + "-" + size);
            }else{
                System.out.println("INVALID");
            }
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 9. Chat Message Redaction
    public void chatRedaction(Scanner sc){
        try{
            System.out.print("Enter message: ");
            String msg = sc.nextLine();
            System.out.print("Enter number of banned words: ");
            int n = Integer.parseInt(sc.nextLine());
            String[] banned = new String[n];

            System.out.println("Enter banned words:");
            for (int i=0; i<n; i++){
                banned[i] = sc.nextLine();
            }

            for (int i=0; i<n; i++){
                String word = banned[i];
                String stars = "";
                for (int j=0; j<word.length(); j++){
                    stars += "*";
                }
                msg = msg.replace(word, stars);
            }

            System.out.println("Redacted message: " + msg);
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }

    // 10. Resume Keyword Versioning
    public void resumeVersioning(Scanner sc){
        try{
            System.out.print("Enter number of words in Resume 1: ");
            int n1 = Integer.parseInt(sc.nextLine());
            String[] r1 = new String[n1];
            System.out.println("Enter words of Resume 1:");
            for (int i=0; i<n1; i++){
                r1[i] = sc.nextLine();
            }

            System.out.print("Enter number of words in Resume 2: ");
            int n2 = Integer.parseInt(sc.nextLine());
            String[] r2 = new String[n2];
            System.out.println("Enter words of Resume 2:");
            for (int i=0; i<n2; i++){
                r2[i] = sc.nextLine();
            }

            int score=0;
            boolean[] used = new boolean[n2];

            for (int i=0; i<n1; i++){
                for (int j=0; j<n2; j++){
                    if (!used[j] && r1[i].equals(r2[j])){
                        score++;
                        used[j]=true;
                        break;
                    }
                }
            }

            System.out.println("Similarity Score: " + score);
        }catch(NumberFormatException e){
            System.out.println("Please enter valid numbers only!");
        }catch(Exception e){
            System.out.println("Invalid input!");
        }
    }
}
