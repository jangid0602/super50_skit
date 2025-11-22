import java.util.Scanner;

class NewNode {
    String val;
    NewNode next;

    NewNode(String val) {
        this.val = val;
        this.next = null;
    }
}

public class ZiplineMerge {

    public static NewNode kZip(NewNode head1, NewNode head2, int k) {

        NewNode curr1 = head1;
        NewNode curr2 = head2;
        NewNode prev = null;

        while (curr1 != null && curr2 != null) {

            int cnt = 1;
            NewNode end1 = curr1;

            while (cnt < k && end1.next != null) {
                end1 = end1.next;
                cnt++;
            }

            NewNode next1 = end1.next;

            cnt = 1;
            NewNode start2 = curr2;
            NewNode end2 = curr2;

            while (cnt < k && end2.next != null) {
                end2 = end2.next;
                cnt++;
            }

            NewNode next2 = end2.next;

            end2.next = next1;
            end1.next = start2;

            prev = end2;
            curr1 = next1;
            curr2 = next2;
        }

        if (curr1 != null && prev != null) prev.next = curr1;
        if (curr2 != null && prev != null) prev.next = curr2;

        return head1;
    }

    public static void printList(NewNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        NewNode head1 = null, head2 = null, merged = null;
        int k = 1;

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Create List 1");
            System.out.println("2. Create List 2");
            System.out.println("3. Enter value of k");
            System.out.println("4. Perform K-Zip");
            System.out.println("5. Print Merged List");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("How many nodes in List 1? ");
                    int n1 = sc.nextInt();

                    head1 = null;
                    NewNode tail1 = null;

                    for (int i = 0; i < n1; i++) {
                        System.out.print("Enter value (number or letter): ");
                        String val = sc.next();

                        NewNode node = new NewNode(val);
                        if (head1 == null) head1 = tail1 = node;
                        else {
                            tail1.next = node;
                            tail1 = node;
                        }
                    }
                    System.out.println("List 1 created.");
                    break;

                case 2:
                    System.out.print("How many nodes in List 2? ");
                    int n2 = sc.nextInt();

                    head2 = null;
                    NewNode tail2 = null;

                    for (int i = 0; i < n2; i++) {
                        System.out.print("Enter value (number or letter): ");
                        String val = sc.next();

                        NewNode node = new NewNode(val);
                        if (head2 == null) head2 = tail2 = node;
                        else {
                            tail2.next = node;
                            tail2 = node;
                        }
                    }
                    System.out.println("List 2 created.");
                    break;

                case 3:
                    System.out.print("Enter k: ");
                    k = sc.nextInt();
                    break;

                case 4:
                    if (head1 == null || head2 == null) {
                        System.out.println("❌ Create both lists first!");
                    } else {
                        merged = kZip(head1, head2, k);
                        System.out.println("✔ Merge completed (in-place).");
                    }
                    break;

                case 5:
                    System.out.print("Merged List: ");
                    printList(merged);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
