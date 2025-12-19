import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Filename-DigitalLibrarySystem.java
 * @Description-Demonstrates a digital library system with exact and partial
 *                           search
 * @Author-Aditya Virmani
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
            if (book.getTitle().equals(title))
                it.remove();
        }
    }

    // method for exact search
    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title))
                result.add(book);
        }
        return result;
    }

    // method for partial search
    public List<Book> search(String title, boolean partial) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title))
                result.add(book);
        }
        return result;
    }
}

public class DigitalLibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("Enter");
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Exact search");
            System.out.println("4.Partial search");
            System.out.println("0.Exit");

            choice = InputHelper.readInt(scanner);
            switch (choice) {
                case 1:
                    System.out.println("Enter Book's title");
                    String title = scanner.next();
                    library.addBook(title);
                    break;

                case 2:
                    System.out.println("Enter Book's title to be removed");
                    title = scanner.next();
                    library.removeBook(title);
                    break;

                case 3:
                    System.out.println("Enter exact title to be matched");
                    title = scanner.next();
                    List<Book> exactMatchedBooks = library.search(title);
                    System.out.println(exactMatchedBooks);
                    break;

                case 4:
                    System.out.println("Enter partial title to be matched");
                    title = scanner.next();
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
