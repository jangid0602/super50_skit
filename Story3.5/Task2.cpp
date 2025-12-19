/**
 * @filename - Task-2.cpp
 * @description - The Digital Library System
 * @author - Avani Shrimali
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Book {
public:
    string title;
    Book(string bookTitle) {
        title = bookTitle;
    }
};

class Library {
private:
    vector<Book> bookCollection;

public:
    void addBook(string title) {
        bookCollection.push_back(Book(title));
    }

    vector<Book> searchBook(string keyword) {
        vector<Book> results;
        for (Book book : bookCollection) {
            if (book.title == keyword) {
                results.push_back(book);
            }
        }
        return results;
    }

    vector<Book> searchBook(string keyword, bool isPartialSearch) {
        vector<Book> results;
        for (Book book : bookCollection) {
            if (book.title.find(keyword) != string::npos) {
                results.push_back(book);
            }
        }
        return results;
    }
};

int main() {
    Library library;
    library.addBook("Data");
    library.addBook("Database");
    library.addBook("War");

    vector<Book> results = library.searchBook("Data", true);
    for (Book book : results) {
        cout << book.title << endl;
    }

    return 0;
}

