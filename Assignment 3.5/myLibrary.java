/*
 @filename - myLibrary.java
 @description - The Digital Library System
 @author - Kalp Mundra
 */

import java.util.ArrayList;
import java.util.List;

public class myLibrary {

    // Represents a single book
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

    // Manages the collection of books
    class Library {
        private List<Book> books;

        public Library() {
            books = new ArrayList<>();
        }

        // Adds a book to the library
        public void addBook(String title) {
            books.add(new Book(title));
        }

        // Removes a book with the given title
        public void removeBook(String title) {
            books.removeIf(book -> book.getTitle().equals(title));
        }

        // Searches for books with exact title match
        public List<Book> search(String title) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    result.add(book);
                }
            }
            return result;
        }

        // Searches for books with exact or partial title match
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