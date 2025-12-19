// 2. The Digital Library System

import java.util.ArrayList;
import java.util.List;

public class MyLibrary {

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
        private List<Book> books;

        public Library() {
            books = new ArrayList<>();
        }

        public void addBook(String title) {
            books.add(new Book(title));
        }

        public void removeBook(String title) {
            books.removeIf(book -> book.getTitle().equals(title));
        }

        public List<Book> search(String title) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    result.add(book);
                }
            }
            return result;
        }

        public List<Book> search(String title, boolean partial) {
            if (!partial) {
                return search(title);
            }

            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle().contains(title)) {
                    result.add(book);
                }
            }
            return result;
        }
    }

}
