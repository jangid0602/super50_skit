import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


/**
 * @Filename-ProblemSolvingUtils.java
 * @Description- It contains all the question related to array,string that uses Hashmap,Set
 * @Author- Arman Agrawal
 */


public class ProblemSolvingUtils {
    int minDeadline(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int element : array) {
            if (element > firstMax) {
                secondMax = firstMax;
                firstMax = element;
            } else if (element > secondMax) {
                secondMax = element;
            }
        }
        return secondMax;
    }

    List<String> factoryFloorRobot(int[] array) {
        List<String> result = new ArrayList<>();

        for (int element : array) {
            if (element % 15 == 0) {
                result.add("Hazardous");
            } else if (element % 3 == 0) {
                result.add("Heavy");
            } else if (element % 5 == 0) {
                result.add("Fragile");
            } else {
                result.add(String.valueOf(element));
            }
        }
        return result;
    }

    char findExtraChar(String original, String scrambled) {
        int result = 0;

        for (char character : original.toCharArray())
            result ^= character;
        for (char character : scrambled.toCharArray())
            result ^= character;

        return (char) result;
    }

    String firstDuplicateCustomer(String[][] requests) {
        HashSet<String> usedSeats = new HashSet<>();

        for (String[] request : requests) {
            String customer = request[0];
            String seat = request[1];
            if (usedSeats.contains(seat)) {
                return customer;
            }
            usedSeats.add(seat);
        }
        return "-1";
    }

    int weatherStationDataAggregator(String[] temperature) {
        int recordDayCount = 0;
        int maximumTemperature = Integer.MIN_VALUE;

        for (String current : temperature) {
            int currentTemperature = Integer.parseInt(current);

            if (currentTemperature > maximumTemperature) {
                maximumTemperature = currentTemperature;
                recordDayCount++;
            }
        }
        return recordDayCount;

    }

    String findMiddleNode(Node headNode) {
        Node slowPointer = headNode;
        Node fastPointer = headNode;

        while (fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }
        return slowPointer.data;
    }

    static int readInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter an integer.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextInt();
    }

    static int[] readIntArray(Scanner sc, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter integer:");
                sc.next();
            }
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProblemSolvingUtils utils = new ProblemSolvingUtils();

        while (true) {
            System.out.println("""
                    ===== MENU =====
                    1. Cosmic Courier Challenge 
                    2. Factory Floor Robot
                    3. Spy’s Cipher 
                    4. Concert Seat Manager
                    5. Weather Station Data Aggregator
                    6. Midpoint Finder
                    0. Exit""");

            int choice = readInt(scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                case 2:
                    int arraySize = readInt(scanner, "Enter array size: ");

                    if (arraySize <= 0) {
                        System.out.println("Array size must be > 0");
                        break;
                    }

                    System.out.println("Enter array elements:");
                    int[] numbers = readIntArray(scanner, arraySize);

                    if (choice == 1) {
                        if (arraySize < 2) {
                            System.out.println("Need at least 2 elements.");
                        } else {
                            System.out.println("Minimum Deadline: " +
                                    utils.minDeadline(numbers));
                        }
                    } else {
                        System.out.println("Factory Output: " +
                                utils.factoryFloorRobot(numbers));
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter original string: ");
                    String originalText = scanner.nextLine();

                    System.out.print("Enter scrambled string: ");
                    String scrambledText = scanner.nextLine();

                    if (scrambledText.length() != originalText.length() + 1) {
                        System.out.println("Scrambled string must have exactly one extra character.");
                    } else {
                        System.out.println("Extra Character: " +
                                utils.findExtraChar(originalText, scrambledText));
                    }
                    break;

                case 4:
                    int requestCount = readInt(scanner, "Enter number of requests: ");
                    scanner.nextLine();

                    if (requestCount <= 0) {
                        System.out.println("Invalid request count.");
                        break;
                    }

                    String[][] seatRequests = new String[requestCount][2];
                    for (int i = 0; i < requestCount; i++) {
                        System.out.print("Customer name: ");
                        seatRequests[i][0] = scanner.nextLine();
                        System.out.print("Seat number: ");
                        seatRequests[i][1] = scanner.nextLine();
                    }

                    System.out.println("First Duplicate Customer: " +
                            utils.firstDuplicateCustomer(seatRequests));
                    break;

                case 5:
                    int dayCount = readInt(scanner, "Enter number of days: ");

                    if (dayCount <= 0) {
                        System.out.println("Days must be > 0");
                        break;
                    }

                    String[] temperatures = new String[dayCount];
                    System.out.println("Enter temperatures:");
                    for (int i = 0; i < dayCount; i++) {
                        temperatures[i] = String.valueOf(readInt(scanner, ""));
                    }

                    System.out.println("Record Days: " +
                            utils.weatherStationDataAggregator(temperatures));
                    break;

                case 6:
                    int nodeCount = readInt(scanner, "Enter number of nodes: ");
                    scanner.nextLine();

                    if (nodeCount <= 0) {
                        System.out.println("Linked list is empty.");
                        break;
                    }

                    Node head = null, tail = null;
                    System.out.println("Enter node values:");
                    for (int i = 0; i < nodeCount; i++) {
                        String nodeValue = scanner.nextLine();
                        Node newNode = new Node(nodeValue);

                        if (head == null) {
                            head = tail = newNode;
                        } else {
                            tail.nextNode = newNode;
                            tail = newNode;
                        }
                    }

                    System.out.println("Middle Node: " +
                            utils.findMiddleNode(head));
                    break;

                case 0:
                    System.out.println("Program exited successfully.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

}
