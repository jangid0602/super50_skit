/* @file: Task3.cpp
@Description: The Digital Library System
@Author: Ayushi Shukla */
#include <iostream>
#include <vector>
using namespace std;

// -------- Book Class --------
class Book
{
private:
    string title;

public:
    // Constructor using this pointer
    Book(string title)
    {
        this->title = title;
    }

    string getTitle() const
    {
        return this->title;
    }
};

// -------- Library Class --------
class Library
{
private:
    vector<Book> books;

public:
    // Add book (user input comes from main)
    void addBook(string title)
    {
        Book b(title);
        this->books.push_back(b);
    }

    // Remove book by title
    void removeBook(string title)
    {
        for (auto it = this->books.begin(); it != this->books.end();)
        {
            if (it->getTitle() == title)
            {
                it = this->books.erase(it);
            }
            else
            {
                ++it;
            }
        }
    }

    // Exact search (polymorphism)
    vector<Book> searchBook(string title)
    {
        vector<Book> result;
        for (auto &b : this->books)
        {
            if (b.getTitle() == title)
            {
                result.push_back(b);
            }
        }
        return result;
    }

    // Partial search (polymorphism)
    vector<Book> searchBook(string keyword, bool partial)
    {
        vector<Book> result;
        if (partial)
        {
            for (auto &b : this->books)
            {
                if (b.getTitle().find(keyword) != string::npos)
                {
                    result.push_back(b);
                }
            }
        }
        return result;
    }
};

// Function to print books
void printBooks(const vector<Book> &res)
{
    cout << "[";
    for (int i = 0; i < res.size(); i++)
    {
        cout << "Book(\"" << res[i].getTitle() << "\")";
        if (i != res.size() - 1)
            cout << ", ";
    }
    cout << "]\n";
}

// -------- Main (USER INPUT) --------
int main()
{
    Library lib;
    int choice;
    cout << "Digital Library System\n";

    do
    {
        cout << "\n1. Add Book\n2. Remove Book\n3. Search Exact\n4. Search Partial\n5. Exit\n";
        cin >> choice;

        if (choice == 1)
        {
            string title;
            cin >> title;
            lib.addBook(title);
        }
        else if (choice == 2)
        {
            string title;
            cin >> title;
            lib.removeBook(title);
        }
        else if (choice == 3)
        {
            string title;
            cin >> title;
            printBooks(lib.searchBook(title));
        }
        else if (choice == 4)
        {
            string key;
            cin >> key;
            printBooks(lib.searchBook(key, true));
        }

    } while (choice != 5);

    return 0;
}
