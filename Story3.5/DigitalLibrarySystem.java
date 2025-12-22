import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Filename-DigitalLibrarySystem.java
 * @Description-This program demonstrates a digital library system that allows users to
 *                   manage a collection of books. Users can add books to the library, remove
 *                   books by title, and search for books using both exact match and partial
 *                   substring search functionality. The system maintains a list of Book objects
 *                   and provides efficient search operations for library management.
 * @Author- Aman Jeet Singh
 */
class Book {
    private String title;

    public Book(String title) {
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

    public void addBook(String title) {
        books.add(new Book(title));
    }

    public void removeBook(String title) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getTitle().equals(title)) {
                it.remove();
            }
        }
    }

    /**
     * Method for exact search - finds books with titles that exactly match the given title.
     * 
     * @param title The exact title to search for
     * @return List of books with matching titles
     */
    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Method for partial search - finds books with titles that contain the given substring.
     * 
     * @param title The partial title to search for
     * @param partial Flag indicating partial search (must be true)
     * @return List of books with titles containing the given substring
     */
    public List<Book> search(String title, boolean partial) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

public class DigitalLibrarySystem {
    /**
     * Safely reads an integer from the scanner, prompting user until valid input is provided.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // consume the invalid input
        }
        return scanner.nextInt();
    }

    /**
     * Safely reads a non-empty string from the scanner, prompting user until valid input is provided.
     */
    private static String readString(Scanner scanner) {
        String input = scanner.next().trim();
        while (input.isEmpty()) {
            System.out.println("Invalid input! Please enter a non-empty string.");
            input = scanner.next().trim();
        }
        return input;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("Enter:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Exact search");
            System.out.println("4. Partial search");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(scanner);
            switch (choice) {
                case 1:
                    System.out.print("Enter Book's title: ");
                    String title = readString(scanner);
                    library.addBook(title);
                    break;

                case 2:
                    System.out.print("Enter Book's title to be removed: ");
                    title = readString(scanner);
                    library.removeBook(title);
                    break;

                case 3:
                    System.out.print("Enter exact title to be matched: ");
                    title = readString(scanner);
                    List<Book> exactMatchedBooks = library.search(title);
                    System.out.println(exactMatchedBooks);
                    break;

                case 4:
                    System.out.print("Enter partial title to be matched: ");
                    title = readString(scanner);
                    List<Book> partialMatchedBooks = library.search(title, true);
                    System.out.println(partialMatchedBooks);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter valid input");
            }
        } while (choice != 0);

        scanner.close();
    }
}