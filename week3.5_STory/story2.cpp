/**
 * @filename - Story2.cpp
 * @description -  The Digital Library system
 * @author - Fatimi Bee
 */
#include<iostream>
using namespace std;
#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Book class
class Book {
private:
    string title;

public:
    Book(string bookName) {
        title = bookName;
    }

    string getTitle() const {
        return title;
    }
};

// Library class
class Library {
private:
    vector<Book> books;

public:
    // Add book
    void addBook(string title) {
        books.push_back(Book(title));
        cout << "Book added successfully!\n";
    }

    // Exact search
    void search(string title) {
        if (books.empty())
            throw runtime_error("Library is empty");

        bool found = false;
        for (const auto& book : books) {
            if (book.getTitle() == title) {
                cout << "Found: " << book.getTitle() << endl;
                found = true;
            }
        }
        if (!found)
            cout << "Book not found.\n";
    }

    // Partial search (Polymorphism)
    void search(string title, bool partial) {
        vector<Book> foundBooks;
        if (books.empty())
            throw runtime_error("Library is empty");

        for (const auto& book : books) {
            if (book.getTitle().find(title) != string::npos) {
               foundBooks.push_back(book);
            }
        }
        cout<<"Books matching the keyword:\n";
        for(const auto& book : foundBooks){
            cout<<book.getTitle()<<endl;
        }
    }

    // Remove book
    void removeBook(string title) {
        if (books.empty())
            throw runtime_error("Library is empty");
        for (auto it = books.begin(); it != books.end(); ++it) {
            if (it->getTitle() == title) {
                books.erase(it);
                cout << "Book removed successfully!\n";
                return;
            }
        }
        cout << "Book not found.\n";
    }
};

int main() {
    Library library;
    int choice;
    string title;

    do {
        try {
            cout << "\n===== Digital Library Menu =====\n";
            cout << "1. Add Book\n";
            cout << "2. Search Book (Exact)\n";
            cout << "3. Search Book (Partial)\n";
            cout << "4. Remove Book\n";
            cout << "5. Exit\n";
            cout << "Enter your choice: ";

            if (!(cin >> choice))
                throw runtime_error("Invalid input type");

            cin.ignore();

            switch (choice) {
            case 1:
                cout << "Enter book title: ";
                getline(cin, title);
                library.addBook(title);
                break;

            case 2:
                cout << "Enter book title to search: ";
                getline(cin, title);
                library.search(title);
                break;

            case 3:
                cout << "Enter keyword to search: ";
                getline(cin, title);
                library.search(title, true);
                break;

            case 4:
                cout << "Enter book title to remove: ";
                getline(cin, title);
                library.removeBook(title);
                break;

            case 5:
                cout << "Exiting Library System...\n";
                break;

            default:
                throw runtime_error("Invalid menu choice");
            }
        }
        catch (const exception& e) {
            cout << "Error: " << e.what() << endl;
            cin.clear();
        }

    } while (choice != 5);

    return 0;
}
