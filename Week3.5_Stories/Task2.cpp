/**
 * @filename - Task-2.cpp
 * @description -  The Digital Library System 
 * @author - Diya Garg 
 */
#include <iostream>
#include <vector>
#include <string>
using namespace std;

// ---------------- Book Class ----------------
class Book {
private:
    string title;

public:
    // Constructor
    Book(string t) {
        title = t;
    }

    // Getter
    string getTitle() const {
        return title;
    }
};

// ---------------- Library Class ----------------
class Library {
private:
    vector<Book> books;

public:
    // Add book
    void addBook(string title) {
        books.push_back(Book(title));
    }

    // Remove book
    void removeBook(string title) {
        for (auto it = books.begin(); it != books.end(); ++it) {
            if (it->getTitle() == title) {
                books.erase(it);
                break;
            }
        }
    }

    // Exact match search
    void search(string title) {
        cout << "[";
        bool first = true;

        for (const auto& book : books) {
            if (book.getTitle() == title) {
                if (!first) cout << ", ";
                cout << "Book(\"" << book.getTitle() << "\")";
                first = false;
            }
        }
        cout << "]\n";
    }

    // Partial match search (Polymorphism via overloading)
    void search(string keyword, bool partial) {
        cout << "[";
        bool first = true;

        for (const auto& book : books) {
            if (book.getTitle().find(keyword) != string::npos) {
                if (!first) cout << ", ";
                cout << "Book(\"" << book.getTitle() << "\")";
                first = false;
            }
        }
        cout << "]\n";
    }
};

// ---------------- Main Function ----------------
int main() {
    Library library;

    // Test Case 1
    library.addBook("War");
    library.search("War");   // Exact match

    // Test Case 2
    library.addBook("Data");
    library.addBook("Database");
    library.search("Data", true);   // Partial match

    // Test Case 3
    library.removeBook("A");
    library.search("A", true);

    return 0;
}
