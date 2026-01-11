package Oneup.Story2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Oneup.MyArray;
import Oneup.MyString;

public class Main {
    public static void main(String[] args) {
         MyArray obj = new MyArray();
        
        

        Scanner sc = new Scanner(System.in);  //object of scanner class for further user defined input
        int ch=0;  // variable for taking user choice (initialization in case of catch block execution)

        do {
            System.out.println("""
                    *** Choose a problem to solve ***
                    1. Trendsetter Problem
                    2. Max Pair
                    3. Longest Balanced String
                    4. Encoded Subset
                    5. Two Step Path
                    6. Replace Non Overlap
                    7. Compact Logs
                    8. Normalize SKU
                    9. Chat Message Redaction
                    10.Resume Keyword Versioning
                    3. Exit
                    """);
                    try {
                        System.out.print("Enter your choice: ");
            ch = sc.nextInt();
                    } catch (Exception e) {
                        System.err.println("enter a valid input");
                         sc.nextLine();   //to clearinvalid inputs

                    }
                     boolean k=true;
            switch (ch) {
               
        case 1:
                    int windowsize=0;  // for taking widow size input from user
                    boolean reenter;
                    do{
                        
                    obj.inputArray();
                     reenter = obj.getArrayConfirmation();
                    } while (reenter);
        
                boolean resize=false;
                while (!resize){
                try {
                    System.out.println("enter window size");
                    windowsize=sc.nextInt();
                    int arraysize=obj.array.size();
                    
                    if(windowsize>arraysize){
                    System.out.println("window size is greater than array size");
                    //resize=true;
                        sc.nextLine();
                        } else if (windowsize <= 0) {
                     System.out.println("⚠️ Window size must be a positive integer. Please try again.");
            }


            
            else resize=true;
    

        } catch (Exception e) {
            System.out.println("enter a valid integer number");
            sc.nextLine(); 
            
        }
    }
    
   
        Arrayoperations obj1=new  Arrayoperations(obj.array);
        System.out.println("Score of trendsetter is:"+obj1.gettrendsetterScore(windowsize));
       case 2:
        obj.inputArray();
        obj.getArrayConfirmation();
        int sum = 0;
        while (true) {
        try {
            System.out.print("Enter sum: ");
            sum = sc.nextInt();
            break; //valid input exit loop
        }   catch (InputMismatchException e) {
            System.out.println("❌ Enter a valid integer value!");
            sc.nextLine(); // clear invalid input
        }
    }

                             //This part runs *after* valid input
                Arrayoperations obj2 = new Arrayoperations(obj.array);
                System.out.println("Result: " + obj2.getmaxpairs(sum));
                break; //  don't fall through to next case


                case 3:
                    obj.inputArray();
                    obj.getArrayConfirmation();
                    Arrayoperations obj3= new Arrayoperations(obj.array);
                    System.out.println("result"+obj3.getlongestbalanced());


                case 4:
                    System.out.println("enter a Supersrting");
                    String Superstring=sc.next();
                    System.out.println("Enter substring :");
                    String substring = sc.next();
                    Stringoperations obj4=new Stringoperations(Superstring);
                    System.out.println(obj4.getencodedSubset(substring) ? "True" : "False");


                case 5:
                   // ---------- TRY CATCH FOR NUMBER ----------
                        int size = 0;

                        try {
                            System.out.println("Enter number of actions :");
                    
                        size= sc.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please enter an integer.");
                            break;   // stop this case safely
                        }

                        String actions = "";
                        System.out.println("Enter actions (user,page):");

                        for (int i = 0; i < size; i++) {

                            try {
                                String line = sc.nextLine().trim();

                                if (line.isEmpty()) {
                                    i--;
                                    continue;
                                }

                                if (!line.contains(",")) {
                                    System.out.println("Invalid input. Expected format: user,page");
                                    i--;
                                    continue;
                                }

                                String[] parts = line.split(",");

                                if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                                    System.out.println("Invalid input. Expected format: user,page");
                                    i--;
                                    continue;
                                }

                            actions += parts[0] + "," + parts[1] + " | ";


                            } catch (Exception e) {
                                System.out.println("Error processing input. Please try again.");
                                i--;   // retry this iteration
                            }
                        }

                        // ---------- TRY CATCH FOR RESULT ----------
                        Stringoperations obj5=new Stringoperations(actions);
                        try {
                            System.out.println("Most Frequent 2 Step Path : " +obj5.gettwoStepPath(actions));
                        } catch (Exception e) {
                            System.out.println("Error calculating result.");
                        }


            case 6:
                     // 6. Non-Overlapping Replace
                
                    System.out.println("Enter text:");
                    String text = sc.next();
                    System.out.println("Enter string to find:");
                    String find = sc.next();
                    System.out.println("Enter replacement:");
                    String rep = sc.next();
                    Stringoperations obj6=new Stringoperations(text);
                    System.out.println("Modified Text : " + obj6.replaceNonOverlap(find, rep));
                
                case 7:
                       // 7. Log File Compaction
                    System.out.println("Enter logs :");
                    String logs = sc.nextLine();
                    Stringoperations obj7=new Stringoperations(logs);
                    System.out.println("Output: " + obj7.getcompactLog());
                
                case 8:
                  // 8. SKU Normalization
                    System.out.println("Enter SKU:");
                    String sku = sc.next();
                    Stringoperations obj8=new Stringoperations(sku);
                    System.out.println("Normalized SKU : " + obj8.normalizeSKU());
                


                case 9:
                    sc.nextLine(); 
                    System.out.println("Enter message :");
                    String message = sc.nextLine();
                    int s=0;
                    while (true) {
                        
                    
                    System.out.println("Enter number of banned words:");
                   
                    try {
                         s = sc.nextInt();
                          sc.nextLine(); 
                         break;
                        
                    } catch (Exception e) {
                        System.out.println("enter valid number");
                         sc.nextLine(); 
                    }
                }
                    List<String> banned = new ArrayList<>();
                    System.out.println("Enter banned words:");
                    for(int i=0;i<s;i++) banned.add(sc.next());
                    Stringoperations obj9=new Stringoperations(message);
                    System.out.println("Redacted Message : " + obj9.getmsgredact(banned));

                case 10:
              int a = 0, b = 0;

while (true) {
    System.out.println("Enter size of resume V1 and V2:");

    try {
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine(); // clear buffer
        break;         // exit loop if both numbers are valid

    } catch (Exception e) {
        System.out.println("Enter valid number");
        sc.nextLine(); // clear invalid input
    }
}

                    List<String> r1 = new ArrayList<>(), r2 = new ArrayList<>();
                    System.out.println("Enter resume V1 keywords:");
                    for(int i=0;i<a;i++) r1.add(sc.next());
                    System.out.println("Enter resume V2 keywords:");
                    for(int i=0;i<b;i++) r2.add(sc.next());
                    Stringoperations obj10=new Stringoperations();
                    System.out.println("Output : " + obj10.resumeScore(r1,r2));
                


                case 11:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println(); 
        } 
        while (ch!= 3);

        sc.close();
    }

   
}
