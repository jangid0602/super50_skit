/**
 * Filename- DigitalLibrarySystem.java
 * Deescription- determine the minimum possible deadline after optionally removing one route
 * Author - Nancy Jain
 */


import java.util.*;

class DigitalLibrarySystem{
class Book{
    String title;
    Book(String title){
        this.title = title;
    }
    public String toString() {
        return "Book(\"" + title + "\")";
    }
}
class Library{
    private List<Book> books = new ArrayList<>();
    void addBook(String title){
        books.add(new Book(title));
    }

    void removeBook(String title){
        books.removeIf(b->b.title.equals(title));
    }

    //Partial Search - status 0
    //Exact Search - status 1
    List<Book> search(String title , boolean status){
        List<Book> result = new ArrayList<>();
        for(Book b : books){
            if(b.title.contains(title) && status == false){
                result.add(b);
            }
            if(b.title.equals(title) && status == true){
                result.add(b);
            }
        }
        return result;
    } 
}

}
