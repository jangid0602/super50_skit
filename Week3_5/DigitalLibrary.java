package Week3_5;

public class DigitalLibrary {
    private Book[] books = new Book[8];
    private int size = 0;

    public void addBook(String title) {
        ensureCapacity(size + 1);
        books[size++] = new Book(title);
    }

    public void removeBook(String title) {
        int write = 0;
        for (int i = 0; i < size; i++) {
            if (!books[i].title.equals(title)) {
                books[write++] = books[i];
            }
        }
        // Null out the tail references to avoid stale pointers
        for (int i = write; i < size; i++) {
            books[i] = null;
        }
        size = write;
    }

    // Exact match search
    public Book[] search(String title) {
        Book[] tmp = new Book[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].title.equals(title)) tmp[count++] = books[i];
        }
        return trim(tmp, count);
    }

    // Partial match search (polymorphic behavior via overloading)
    public Book[] search(String title, boolean partial) {
        if (!partial) return search(title);
        Book[] tmp = new Book[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].title.contains(title)) tmp[count++] = books[i];
        }
        return trim(tmp, count);
    }

    private void ensureCapacity(int desired) {
        if (desired <= books.length) return;
        int newCap = books.length * 2;
        while (newCap < desired) newCap *= 2;
        Book[] newArr = new Book[newCap];
        System.arraycopy(books, 0, newArr, 0, size);
        books = newArr;
    }

    private Book[] trim(Book[] arr, int count) {
        Book[] result = new Book[count];
        if (count > 0) System.arraycopy(arr, 0, result, 0, count);
        return result;
    }

    public static String formatBooks(Book[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static class Book {
        public final String title;
        public Book(String title) {
            this.title = title;
        }
        @Override public String toString() { return "Book(\"" + title + "\")"; }
    }
}
