/**
 * @filename   : DigitalLibrarySystem.cpp
 * @description: Object-oriented digital library system supporting exact and partial title searches using polymorphism.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

class Book {
private:
    string title;

public:
    Book(string t) : title(t) {}

    string getTitle() const {
        return title;
    }
};

class Library {
private:
    vector<Book> books;

public:
    void addBook(const string& title) {
        books.emplace_back(title);
    }

    void removeBook(const string& title) {
        books.erase(
            remove_if(books.begin(), books.end(),
                      [&](const Book& b) {
                          return b.getTitle() == title;
                      }),
            books.end());
    }

    // Polymorphic behavior via parameter
    vector<Book> search(const string& query, bool exactMatch) {
        vector<Book> result;

        for (const Book& book : books) {
            if (exactMatch) {
                if (book.getTitle() == query) {
                    result.push_back(book);
                }
            } else {
                if (book.getTitle().find(query) != string::npos) {
                    result.push_back(book);
                }
            }
        }
        return result;
    }
};

int main() {
    Library library;

    int q;
    cin >> q;   // number of operations

    while (q--) {
        string command;
        cin >> command;

        if (command == "ADD") {
            string title;
            cin >> title;
            library.addBook(title);
        }
        else if (command == "REMOVE") {
            string title;
            cin >> title;
            library.removeBook(title);
        }
        else if (command == "SEARCH_EXACT") {
            string title;
            cin >> title;
            vector<Book> result = library.search(title, true);

            if (result.empty()) {
                cout << "[]" << endl;
            } else {
                for (const Book& b : result) {
                    cout << b.getTitle() << " ";
                }
                cout << endl;
            }
        }
        else if (command == "SEARCH_PARTIAL") {
            string title;
            cin >> title;
            vector<Book> result = library.search(title, false);

            if (result.empty()) {
                cout << "[]" << endl;
            } else {
                for (const Book& b : result) {
                    cout << b.getTitle() << " ";
                }
                cout << endl;
            }
        }
    }

    return 0;
}
