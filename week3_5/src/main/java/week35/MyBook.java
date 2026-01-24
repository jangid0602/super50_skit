public record MyBook(String title) {
    public MyBook {
        if (title == null || title.length() == 0)
            throw new IllegalArgumentException("Title cannot be null or empty");
    }

    @Override
    public String toString() {
        return "Book(" +
                '\"' + title + '\"' +
                ')';
    }
}
