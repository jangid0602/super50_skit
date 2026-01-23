package Test1;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {

        MyMemory obj = new MyMemory();

        boolean exit = false;

        while (!exit) {

            System.out.println("Choose Options : ");
            System.out.println("1. ALLOCATE");
            System.out.println("2. FREE");
            System.out.println("3. SHOW");
            System.out.println("4. EXIT");

            int choice;

            Scanner input = new Scanner(System.in);

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter memory to allocate : ");
                    int allocate_value = input.nextInt();
                    obj.allocate(allocate_value);
                    break;

                case 2:
                    System.out.println("Enter memory to deallocate : ");
                    int deallocate_value = input.nextInt();
                    obj.free(deallocate_value);
                    break;

                case 3:
                    System.out.print("Available Memory : ");
                    System.out.println(obj.show());
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Plese enter valid choice.");
            }

        }

    }
}
