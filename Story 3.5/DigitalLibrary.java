import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;


/**
 * @Filename-DigitalLibrary.java
 * @Description-Demonstrates a digital library system with exact and partial search
 * @Author-Arman Agrawal
 */



class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Book(\"" + title + "\")";
    }
}


class Library {
    private HashSet<Book> books = new HashSet<>();

    public void addBook(String title) {
        books.add(new Book(title));
    }

    public void removeBook(String title) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
            }
        }

    }

    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
                break;
            }
        }
        return result;
    }

    public List<Book> search(String title, boolean isPartial) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

public class DigitalLibrary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== Digital Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book (Exact Match)");
            System.out.println("4. Search Book (Partial Match)");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title to add: ");
                    String addTitle = scanner.nextLine();
                    library.addBook(addTitle);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    System.out.println("Book removed (if it existed).");
                    break;

                case 3:
                    System.out.print("Enter exact book title to search: ");
                    String exactTitle = scanner.nextLine();
                    List<Book> exactResult = library.search(exactTitle);

                    if (exactResult.isEmpty()) {
                        System.out.println("No book found.");
                    } else {
                        System.out.println("Search Result: " + exactResult);
                    }
                    break;

                case 4:
                    System.out.print("Enter keyword for partial search: ");
                    String partialTitle = scanner.nextLine();
                    List<Book> partialResult = library.search(partialTitle, true);

                    if (partialResult.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        System.out.println("Search Results:");
                        System.out.println("[");
                        for (Book b : partialResult) {
                            System.out.print(b);
                            System.out.print(",");
                        }
                        System.out.println("]");

                    }
                    break;

                case 5:
                    System.out.println("Exiting Digital Library...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}


