import java.util.List;
import java.util.Scanner;

/**
 * Filename- Main.java
 * Deescription-  1. The Cosmic Courier Challenge
                  2. The Digital Library System
                  3. The Factory Floor Robot
                  4. The Spy’s Cipher
                  5. The Concert Seat Manager
                  6. The Weather Station Data Aggregator
                  7. The Midpoint Finder
                  8. The Browser History Navigator
 * Author - Nancy Jain
 */

public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;
        do{
        System.out.println("\n1. The Cosmic Courier Challenge\r\n" + 
                        "2. The Digital Library System\r\n" + 
                        "3. The Factory Floor Robot\r\n" + 
                        "4. The Spy's Cipher\r\n" + 
                        "5. The Concert Seat Manager\r\n" + 
                        "6. The Weather Station Data Aggregator\r\n" + 
                        "7. The Midpoint Finder\r\n" + 
                        "8. The Browser History Navigator\r\n" + 
                        "9. Exit\n");
        System.out.println("Enter your Choice");
        choice = readInt(scanner);
        switch(choice){
            case 1:
                System.out.println("Enter number of routes :");
                int numberOfRoutes = readInt(scanner);
                int[] routes = new int[numberOfRoutes];
                System.out.println("Enter routes: ");
                for(int i=0;i<numberOfRoutes;i++){
                    routes[i]= readInt(scanner);
                }
                int result = CosmicCourier.minDeadline(routes);
                System.out.println("Minimum possible Deadline : " + result +"\n");
                break;
            case 2: 
                DigitalLibrarySystem system = new DigitalLibrarySystem();
                DigitalLibrarySystem.Library library = system.new Library();
                boolean running1 = true;

                while (running1) {
                    System.out.println("\n1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. Search Book (Exact)");
                    System.out.println("4. Search Book (Partial)");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");
                    int choice2 = readInt(scanner);

                    switch (choice2) {

                        case 1:
                            System.out.print("Enter book title to add: ");
                            String addTitle = scanner.nextLine();
                            library.addBook(addTitle);
                            System.out.println("Book added.");
                            break;

                        case 2:
                            System.out.print("Enter book title to remove: ");
                            String removeTitle = scanner.nextLine();
                            library.removeBook(removeTitle);
                            System.out.println("Book removed.");
                            break;

                        case 3:
                            System.out.print("Enter title for exact search: ");
                            String exact = scanner.nextLine();
                            System.out.println(library.search(exact, true));
                            break;

                        case 4:
                            System.out.print("Enter title for partial search: ");
                            String partial = scanner.nextLine();
                            System.out.println(library.search(partial, false));
                            break;

                        case 5:
                            running1 = false;
                            System.out.println("Exiting Digital Library System...");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                        }
                    }
                    break;

            case 3:
                System.out.println("Enter number of weights : ");
                int numberOfWeights = readInt(scanner);
                int[] weights = new int[numberOfWeights];
                System.out.println("Enter weights :");
                for(int i=0;i<numberOfWeights;i++)
                    weights[i]=readInt(scanner);
                List<String> result3 =FactoryRobot.label(weights);
                System.out.println("Labels: "+ result3);
                break;

            case 4:
                System.out.println("Enter Original String :");
                String originalString = scanner.nextLine();
                System.out.println("Enter Scrambled String :");
                String scrambledString = scanner.nextLine();
                char result4 = SpyCipher.findChar(originalString, scrambledString);
                System.out.println("Extra character :"+ result4);
                break;

            case 5:
                System.out.println("Enter number of requests :");
                int numberOfRequests = readInt(scanner);
                String[][] requests = new String[numberOfRequests][2];
                for(int i=0;i<numberOfRequests;i++){
                    System.out.println("Enter Customer ID :");
                    requests[i][0]= scanner.nextLine();
                    System.out.println("Enter Seat Number :");
                    requests[i][1] = scanner.nextLine();
                }
                String result5 = ConcertSeatManager.DuplicateDetection(requests);
                if (result5.equals("-1"))
                System.out.println("No duplicate seat request found.");
                else
                System.out.println("First duplicate seat requested by: " + result5);
                break;

            case 6:
                System.out.println("Enter number of days on which temperature is recorded:");
                int numberOfDays = readInt(scanner);
                int[] days = new int[numberOfDays];
                System.out.println("Enter temperatures");
                for(int i=0;i<numberOfDays;i++)
                    days[i] = readInt(scanner);
                int result6 = WeatherStation.recordDays(days);
                System.out.println("Number of new temperature record :"+ result6);
                break;
                
            case 7:
                System.out.print("Enter number of nodes: ");
                int n = readInt(scanner);
                if(n<=0){
                    System.out.println("List is empty.");
                    break;
                }
                
                System.out.print("Enter value for node 1: ");
                MidpointFinder.Node head = new MidpointFinder.Node(readInt(scanner));
                MidpointFinder.Node current = head;

                for (int i = 2; i <= n; i++) {
                    System.out.print("Enter value for node " + i + ": ");
                    current.next = new MidpointFinder.Node(readInt(scanner));
                    current = current.next;
                }
                int middle = MidpointFinder.findMiddle(head);
                System.out.println("Middle node value: " + middle);
                break;

            case 8:
                BrowserHistory bh = new BrowserHistory();
                boolean running3 = true;

                while (running3) {
                    System.out.println("\n1. Visit Page");
                    System.out.println("2. Back");
                    System.out.println("3. Forward");
                    System.out.println("4. Show Current Page");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    int choice3 = readInt(scanner);
                    switch (choice3) {

                        case 1:
                            System.out.print("Enter page name: ");
                            String page = scanner.nextLine();
                            bh.Visit(page);
                            System.out.println("Visited: " + page);
                            break;

                        case 2:
                            bh.backPage();
                            System.out.println("Current Page: " + bh.current);
                            break;

                        case 3:
                            bh.forward();
                            System.out.println("Current Page: " + bh.current);
                            break;

                        case 4:
                            System.out.println("Current Page: " + bh.current);
                            break;

                        case 5:
                            running = false;
                            System.out.println("Exiting Browser History Navigator...");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }
                break;

            case 9:
                System.out.print("Do you want to quit? (y/n): ");
                    char confirmQuit;
                    while(true){
                        String input = scanner.next().trim().toLowerCase();
                        if(input.equals("y") || input.equals("n")){
                            confirmQuit = input.charAt(0);
                            break;
                        }else{
                            System.out.println("Invalid input! Please enter y or n:");
                        }
                    }
                        if (confirmQuit == 'y') {
                            running = false;
                            System.out.println("Exiting...");
                    }
                    break;
                default:
                    System.out.println("Wrong choice! Try again.");
                    break;
            }
        }while(running);
        
    }

    private static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine(); // consume rest of line
                return val;
            } else {
                String bad = sc.nextLine(); // consume the invalid token/line
                System.out.println("Invalid entry: \"" + bad + "\" is not an integer."); 
                System.out.println("Please enter an integer value.");
            }
        }
    }
}