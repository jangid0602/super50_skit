import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @Filename-DigitalLibrary.java
 * @Description-Demonstrates a digital library system with exact and partial search
 * @Author-Anushka Kumawat
 **/

class Book {
    private String title;

    Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book(\"" + title + "\")";
    }
}

class Library {
    private List<Book> books = new ArrayList<>();


    void addBook(String title) {
        books.add(new Book(title));
    }

    
    void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    
    List<Book> search(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

   
    List<Book> search(String keyword, boolean partial) {
        List<Book> result = new ArrayList<>();
        if (partial) {
            for (Book book : books) {
                if (book.getTitle().contains(keyword)) {
                    result.add(book);
                }
            }
        }
        return result;
    }
}

public class Oops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- Digital Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book (Exact)");
            System.out.println("4. Search Book (Partial)");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String addTitle = sc.nextLine();
                    lib.addBook(addTitle);
                    System.out.println("Book added");
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = sc.nextLine();
                    lib.removeBook(removeTitle);
                    System.out.println("Book removed");
                    break;

                case 3:
                    System.out.print("Enter title for exact search: ");
                    String exact = sc.nextLine();
                    System.out.println(lib.search(exact));
                    break;

                case 4:
                    System.out.print("Enter keyword for partial search: ");
                    String partial = sc.nextLine();
                    System.out.println(lib.search(partial, true));
                    break;

                case 5:
                    System.out.println("Exiting Library System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
