public class Library {
    private int size;
    private MyBook[] books;

    public Library() {
        books = new MyBook[5];
        size = 0;
    }

    public void addBook(MyBook book) {
        ensureCapacity();
        books[size++] = book;
    }

    public void removeBook(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title().equals(title)) {
                shiftLeft(i);
                size--;
                return;
            }
        }
    }

    public MyBook[] search(String key) {
        return search(key, false);
    }

    public MyBook[] search(String key, boolean partial) {
        if (key == null || key.length() == 0) return new MyBook[0];
        MyBook[] result = new MyBook[size];
        int count = 0;

        int[] lps = null;
        if (partial) {
            lps = new int[key.length()];
            calculateLPSArray(key, lps);
        }

        for (int i = 0; i < size; i++) {
            String title = books[i].title();
            if (partial) {
                if (contains(title, key, lps)) result[count++] = books[i];
            } else {
                if (key.equals(title)) result[count++] = books[i];
            }
        }
        return trim(result, count);
    }

    private boolean contains(String text, String pattern, int[] lps) {
        int n = text.length();
        int m = pattern.length();
        if (m > n) return false;
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) return true;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }

    private void calculateLPSArray(String pattern, int[] lps) {
        int n = pattern.length();

        int len = 0, i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) lps[i++] = ++len;
            else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
    }

    private void ensureCapacity() {
        if (size == books.length) {
            MyBook[] bigger = new MyBook[books.length * 2];
            // Can be replaced with System.arraycopy()
            System.arraycopy(books, 0, bigger, 0, books.length);
            books = bigger;
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++)
            books[i] = books[i + 1];
        books[size - 1] = null;
    }

    private MyBook[] trim(MyBook[] books, int count) {
        if (count == 0) return new MyBook[0];
        MyBook[] result = new MyBook[count];
        // Can be replaced with System.arraycopy()
        System.arraycopy(books, 0, result, 0, count);
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            // Can be optimized using StringBuilder class
            s = s + books[i];
            if (i < size - 1) s = s + ", ";
        }
        return "[ " + s + " ]";
    }
}
