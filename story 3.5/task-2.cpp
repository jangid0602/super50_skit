/**
 * @filename - Task-2.cpp
 * @description -  The Digital Library System 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Book {
private:
    string bookTitle;
    string bookAuthor;

public:
    Book(string title, string author) {
        bookTitle = title;
        bookAuthor = author;
    }

    string getTitle() const {
        return bookTitle;
    }

    void display() const {
        cout << "Title: " << bookTitle << " | Author: " << bookAuthor << endl;
    }
};

class Library {
private:
    vector<Book> bookCollection;

public:
    void addBook(const Book& newBook) {
        bookCollection.push_back(newBook);
    }

    // 🔹 Exact Match Search
    void search(string searchTitle) {
        bool isFound = false;
        cout << "\nExact Match Result:\n";

        for (const auto& currentBook : bookCollection) {
            if (currentBook.getTitle() == searchTitle) {
                currentBook.display();
                isFound = true;
            }
        }

        if (!isFound)
            cout << "No book found.\n";
    }

    void search(string keyword, bool partialMatch) {
        bool isFound = false;
        cout << "\nPartial Match Results:\n";

        for (const auto& currentBook : bookCollection) {
            if (currentBook.getTitle().find(keyword) != string::npos) {
                currentBook.display();
                isFound = true;
            }
        }

        if (!isFound)
            cout << "No book found.\n";
    }
};

int main() {
    Library digitalLibrary;
    int numberOfBooks;

    cout << "Enter number of books: ";
    cin >> numberOfBooks;
    cin.ignore();  

    for (int index = 0; index < numberOfBooks; index++) {
        string titleInput, authorInput;
        cout << "\nEnter title of book " << index + 1 << ": ";
        getline(cin, titleInput);
        cout << "Enter author of book " << index + 1 << ": ";
        getline(cin, authorInput);

        digitalLibrary.addBook(Book(titleInput, authorInput));
    }

    int userChoice;
    cout << "\nSearch Options:\n";
    cout << "1. Exact Match Search\n";
    cout << "2. Partial Match Search\n";
    cout << "Enter your choice: ";
    cin >> userChoice;
    cin.ignore();

    string searchQuery;
    cout << "Enter book title / keyword: ";
    getline(cin, searchQuery);

    if (userChoice == 1) {
        digitalLibrary.search(searchQuery);            // Exact match
    } else if (userChoice == 2) {
        digitalLibrary.search(searchQuery, true);      // Partial match
    } else {
        cout << "Invalid choice!\n";
    }

    return 0;
}
