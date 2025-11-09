import java.util.*;

class TrendsetterScore extends arrayHandler {

    int windowSize; // window size

    void getWindowSize() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter window size (k): ");
        if (scannerObj.hasNextInt()) {

            windowSize = scannerObj.nextInt();
        } else {
            System.out.println("Enter valid window size (only integers allowed)");
            System.out.println("Exiting...");
            System.exit(1);
        }
    }

    @Override
    public void solver() {
        getWindowSize();

        if (nums == null || sizeOfNums < windowSize) {
            System.out.println("Invalid input: window size greater than array length.");
            return;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int score = 0;

        // Initialize first window
        for (int i = 0; i < windowSize; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        if (hasUniqueMax(freq)) score++;

        // Sliding window
        for (int i = windowSize; i < sizeOfNums; i++) {
            int out = nums[i - windowSize];
            int in = nums[i];

            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            freq.put(in, freq.getOrDefault(in, 0) + 1);

            if (hasUniqueMax(freq)) score++;
        }

        System.out.println("Trendsetter Score: " + score);
    }

    private boolean hasUniqueMax(Map<Integer, Integer> freq) {
        int maxFreq = 0, countMax = 0;
        for (int val : freq.values()) {
            if (val > maxFreq) {
                maxFreq = val;
                countMax = 1;
            } else if (val == maxFreq) {
                countMax++;
            }
        }
        return countMax == 1;
    }
}


class EncodedStringSubsets extends stringHandler {
    @Override
    public void inputArray() {

    }

    String superString, subString;

    void getStrings() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter superstring:");
        superString = scannerObj.nextLine();

        System.out.println("Enter substring:");
        subString = scannerObj.nextLine();

        if (superString.length() == 0 || subString.length() == 0) {
            System.out.println("Strings cannot be empty. Exiting...");
            System.exit(1);
        }
    }

    @Override
    public void solver() {
        getStrings();

        if (subString.length() > superString.length()) {
            System.out.println("Result: false");
            return;
        }

        Map<Character, Integer> subStringFrequency = new HashMap<>();
        Map<Character, Integer> windowFrequency = new HashMap<>();

        // Frequency of substring
        for (char c : subString.toCharArray()) {
            subStringFrequency.put(c, subStringFrequency.getOrDefault(c, 0) + 1);
        }

        int k = subString.length();

        // Initialize first window
        for (int i = 0; i < k; i++) {
            char c = superString.charAt(i);
            windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) + 1);
        }

        if (windowFrequency.equals(subStringFrequency)) {
            System.out.println("Result: true");
            return;
        }

        // Sliding window
        for (int i = k; i < superString.length(); i++) {
            char out = superString.charAt(i - k);
            char in = superString.charAt(i);

            // remove outgoing char
            windowFrequency.put(out, windowFrequency.get(out) - 1);
            if (windowFrequency.get(out) == 0) windowFrequency.remove(out);

            // add incoming char
            windowFrequency.put(in, windowFrequency.getOrDefault(in, 0) + 1);

            if (windowFrequency.equals(subStringFrequency)) {
                System.out.println("Result: true");
                return;
            }
        }

        System.out.println("Result: false");
    }
}


class ECommerceFunnelAnalysis extends stringHandler {
    @Override
    public void inputArray() {

    }

    String[] userActions;

    void getUserActions() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter number of user actions:");
        int numberOfActions = 0;

        if (scannerObj.hasNextInt()) {
            numberOfActions = scannerObj.nextInt();
            scannerObj.nextLine(); // consume newline
        } else {
            System.out.println("Enter valid number of actions (only integers allowed)");
            System.out.println("Exiting...");
            System.exit(1);
        }

        userActions = new String[numberOfActions];
        System.out.println("Enter actions in the format (userID,pageID):");
        for (int i = 0; i < numberOfActions; i++) {
            userActions[i] = scannerObj.nextLine().trim();
            if (!userActions[i].contains(",")) {
                System.out.println("Invalid format. Each action must be 'userID,pageID'");
                System.exit(1);
            }
        }
    }

    @Override
    public void solver() {
        getUserActions();

        // Map to store each user's sequence of visited pages
        Map<String, List<String>> userToPagesMap = new HashMap<>();

        for (String action : userActions) {
            String[] parts = action.split(",");
            String userId = parts[0];
            String pageId = parts[1];

            userToPagesMap.putIfAbsent(userId, new ArrayList<>());
            userToPagesMap.get(userId).add(pageId);
        }

        // Map to count occurrences of all 2-step paths (page1 -> page2)
        Map<String, Integer> pathFrequencyMap = new HashMap<>();

        for (List<String> pageList : userToPagesMap.values()) {
            for (int i = 0; i < pageList.size() - 1; i++) {
                String path = pageList.get(i) + "," + pageList.get(i + 1);
                pathFrequencyMap.put(path, pathFrequencyMap.getOrDefault(path, 0) + 1);
            }
        }

        String mostFrequentPath = "";
        int highestFrequency = 0;

        // Find the most frequent 2-step path (lexicographically smallest if tie)
        for (Map.Entry<String, Integer> entry : pathFrequencyMap.entrySet()) {
            String currentPath = entry.getKey();
            int currentFrequency = entry.getValue();

            if (currentFrequency > highestFrequency ||
                    (currentFrequency == highestFrequency && currentPath.compareTo(mostFrequentPath) < 0)) {
                highestFrequency = currentFrequency;
                mostFrequentPath = currentPath;
            }
        }

        if (mostFrequentPath.isEmpty()) {
            System.out.println("No valid 2-step paths found.");
        } else {
            System.out.println("Most frequent 2-step path: " + mostFrequentPath);
        }
    }
}


class MaximalPairMatching extends arrayHandler {

    int targetSum;

    void getTargetSum() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter target sum (k):");
        if (scannerObj.hasNextInt()) {
            targetSum = scannerObj.nextInt();
        } else {
            System.out.println("Enter valid target sum (only integers allowed)");
            System.out.println("Exiting...");
            System.exit(1);
        }
    }

    @Override
    public void solver() {
        getTargetSum();

        // HashMap to store frequency of each number in the array
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

        for (int i = 0; i < sizeOfNums; i++) {
            int number = nums[i];
            numberFrequencyMap.put(number, numberFrequencyMap.getOrDefault(number, 0) + 1);
        }

        int totalPairs = 0;

        for (int i = 0; i < sizeOfNums; i++) {
            int currentNumber = nums[i];
            int complementNumber = targetSum - currentNumber;

            // If both currentNumber and complementNumber are available
            if (numberFrequencyMap.getOrDefault(currentNumber, 0) > 0 &&
                    numberFrequencyMap.getOrDefault(complementNumber, 0) > 0) {

                // Handle case where both numbers are the same (e.g., k=10, numbers=5)
                if (currentNumber == complementNumber) {
                    if (numberFrequencyMap.get(currentNumber) >= 2) {
                        totalPairs++;
                        numberFrequencyMap.put(currentNumber, numberFrequencyMap.get(currentNumber) - 2);
                    }
                } else {
                    totalPairs++;
                    numberFrequencyMap.put(currentNumber, numberFrequencyMap.get(currentNumber) - 1);
                    numberFrequencyMap.put(complementNumber, numberFrequencyMap.get(complementNumber) - 1);
                }
            }
        }

        System.out.println("Maximum number of pairs with sum " + targetSum + ": " + totalPairs);
    }
}



class SubarrayColorBalance extends arrayHandler {

    @Override
    public void solver() {

        // Map to store the first occurrence of each balance value
        Map<Integer, Integer> balanceIndexMap = new HashMap<>();

        int currentBalance = 0; // +1 for red (1), -1 for blue (2), 0 for neutral or equal reds & blues
        int maxBalancedLength = 0;

        // Initialize: balance 0 occurs before the array starts
        balanceIndexMap.put(0, -1);

        for (int index = 0; index < sizeOfNums; index++) {
            int currentColor = nums[index];

            if (currentColor == 1) {
                currentBalance += 1; // red adds +1
            } else if (currentColor == 2) {
                currentBalance -= 1; // blue adds -1
            }

            // If this balance value was seen before, subarray between them is balanced
            if (balanceIndexMap.containsKey(currentBalance)) {
                int previousIndex = balanceIndexMap.get(currentBalance);
                int subarrayLength = index - previousIndex;
                maxBalancedLength = Math.max(maxBalancedLength, subarrayLength);
            } else {
                // Store first occurrence of this balance
                balanceIndexMap.put(currentBalance, index);
            }
        }

        System.out.println("Length of longest color-balanced subarray: " + maxBalancedLength);
    }
}
class TextEditorNonOverlappingReplace extends stringHandler {
    public void inputArray() {
        // No default string input needed
    }
    @Override
    public void solver() {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);

        System.out.println("Enter the text:");
        String inputText = scannerObj.nextLine();

        System.out.println("Enter the string to find:");
        String findString = scannerObj.nextLine();

        System.out.println("Enter the replacement string:");
        String replaceString = scannerObj.nextLine();

        StringBuilder resultBuilder = new StringBuilder();
        int index = 0;

        while (index < inputText.length()) {
            // If findString matches from the current position
            if (index + findString.length() <= inputText.length() &&
                    inputText.substring(index, index + findString.length()).equals(findString)) {

                resultBuilder.append(replaceString);
                index += findString.length(); // move past this match (non-overlapping)
            } else {
                resultBuilder.append(inputText.charAt(index));
                index++;
            }
        }

        System.out.println("Result after replacement: " + resultBuilder.toString());
    }
}
class LogFileCompaction extends stringHandler {
    public void inputArray() {
        // No default string input needed
    }
    @Override
    public void solver() {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);

        System.out.println("Enter the log string (space-separated):");
        String logString = scannerObj.nextLine();

        // Split log entries by spaces
        String[] logEntries = logString.split(" ");

        if (logEntries.length == 0) {
            System.out.println("No logs found.");
            return;
        }

        StringBuilder compactedLogs = new StringBuilder();
        String currentLog = logEntries[0];
        int currentCount = 1;

        // Iterate through log entries to count consecutive occurrences
        for (int i = 1; i < logEntries.length; i++) {
            if (logEntries[i].equals(currentLog)) {
                currentCount++;
            } else {
                compactedLogs.append(currentLog).append("(").append(currentCount).append(") ");
                currentLog = logEntries[i];
                currentCount = 1;
            }
        }

        // Append the last log and its count
        compactedLogs.append(currentLog).append("(").append(currentCount).append(")");

        System.out.println("Compacted log output: " + compactedLogs.toString());
    }
}
class EcommerceSKUNormalization extends stringHandler {
    @Override
    public void inputArray() {

    }

    @Override
    public void solver() {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);

        System.out.println("Enter the SKU string:");
        String rawSku = scannerObj.nextLine();

        // Convert to uppercase and trim any extra spaces
        String normalizedSku = rawSku.trim().toUpperCase();

        // Split the SKU into its parts
        String[] skuParts = normalizedSku.split("-");

        // Validation: must have exactly 3 parts
        if (skuParts.length != 3) {
            System.out.println("Result: INVALID");
            return;
        }

        String categoryPart = skuParts[0];
        String idPart = skuParts[1];
        String sizePart = skuParts[2];

        // Validate CATEGORY: must be 3 to 4 letters only
        boolean isValidCategory = categoryPart.matches("[A-Z]{3,4}");

        // Validate ID: must be 4 to 6 digits only
        boolean isValidId = idPart.matches("\\d{4,6}");

        // Validate SIZE: must be S, M, L, or XL
        boolean isValidSize = sizePart.equals("S") || sizePart.equals("M") || sizePart.equals("L") || sizePart.equals("XL");

        if (isValidCategory && isValidId && isValidSize) {
            System.out.println("Result: " + normalizedSku);
        } else {
            System.out.println("Result: INVALID");
        }
    }
}
class ChatMessageRedaction extends stringHandler {
    @Override
    public void inputArray() {

    }

    @Override
    public void solver() {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);

        // Input message
        System.out.println("Enter the chat message:");
        String message = scannerObj.nextLine();

        // Input banned words
        System.out.println("Enter the number of banned words:");
        int bannedWordCount = scannerObj.nextInt();
        scannerObj.nextLine(); // consume newline

        String[] bannedWords = new String[bannedWordCount];
        System.out.println("Enter banned words one by one:");
        for (int i = 0; i < bannedWordCount; i++) {
            bannedWords[i] = scannerObj.nextLine().trim();
        }

        // Redact banned words from message
        String redactedMessage = redactBannedWords(message, bannedWords);

        System.out.println("Redacted Message: " + redactedMessage);
    }

    private String redactBannedWords(String message, String[] bannedWords) {
        String lowerCaseMessage = message.toLowerCase();
        StringBuilder resultMessage = new StringBuilder(message);

        for (String banned : bannedWords) {
            String lowerCaseBanned = banned.toLowerCase();
            int searchIndex = 0;

            while (true) {
                // Find next occurrence of banned word (case-insensitive)
                int foundIndex = lowerCaseMessage.indexOf(lowerCaseBanned, searchIndex);

                if (foundIndex == -1)
                    break; // no more matches

                // Replace the banned word with asterisks (*) of same length
                for (int j = 0; j < banned.length(); j++) {
                    resultMessage.setCharAt(foundIndex + j, '*');
                }

                // Move search index beyond this match (non-overlapping)
                searchIndex = foundIndex + banned.length();
            }
        }

        return resultMessage.toString();
    }
}
class ResumeKeywordVersioning extends stringHandler {

    @Override
    public void solver() {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);

        // Input for Resume V1
        System.out.println("Enter number of keywords in Resume V1:");
        int sizeOfResumeV1 = scannerObj.nextInt();
        scannerObj.nextLine(); // consume newline
        String[] resumeV1 = new String[sizeOfResumeV1];
        System.out.println("Enter Resume V1 keywords:");
        for (int i = 0; i < sizeOfResumeV1; i++) {
            resumeV1[i] = scannerObj.nextLine().trim();
        }

        // Input for Resume V2
        System.out.println("Enter number of keywords in Resume V2:");
        int sizeOfResumeV2 = scannerObj.nextInt();
        scannerObj.nextLine(); // consume newline
        String[] resumeV2 = new String[sizeOfResumeV2];
        System.out.println("Enter Resume V2 keywords:");
        for (int i = 0; i < sizeOfResumeV2; i++) {
            resumeV2[i] = scannerObj.nextLine().trim();
        }

        // Compute and print similarity score
        int similarityScore = calculateSimilarityScore(resumeV1, resumeV2);
        System.out.println("Similarity Score: " + similarityScore);
    }

    private int calculateSimilarityScore(String[] resumeV1, String[] resumeV2) {
        java.util.HashMap<String, Integer> frequencyMapV1 = new java.util.HashMap<>();
        java.util.HashMap<String, Integer> frequencyMapV2 = new java.util.HashMap<>();

        // Count frequency of each keyword in Resume V1
        for (String keyword : resumeV1) {
            frequencyMapV1.put(keyword, frequencyMapV1.getOrDefault(keyword, 0) + 1);
        }

        // Count frequency of each keyword in Resume V2
        for (String keyword : resumeV2) {
            frequencyMapV2.put(keyword, frequencyMapV2.getOrDefault(keyword, 0) + 1);
        }

        int totalScore = 0;

        // Compare frequencies and add the minimum count for common keywords
        for (String keyword : frequencyMapV1.keySet()) {
            if (frequencyMapV2.containsKey(keyword)) {
                int commonFrequency = java.lang.Math.min(frequencyMapV1.get(keyword), frequencyMapV2.get(keyword));
                totalScore += commonFrequency;
            }
        }

        return totalScore;
    }
}




