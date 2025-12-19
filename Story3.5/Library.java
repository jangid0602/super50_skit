import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    // Add book to library
    public void addBook(String title) {
        books.add(new Book(title));
    }

    // Exact match search
    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Partial match search (polymorphism)
    public List<Book> search(String title, boolean partial) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (partial && book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}
