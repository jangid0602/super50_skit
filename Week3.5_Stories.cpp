#include <bits/stdc++.h>
using namespace std;

// 1. Cosmic Courier Challenge ---------

void cosmicCourier(){
    cout<<"\n--- Cosmic Courier Challenge ---\n";
    cout<<"Enter number of routes: ";

    int n;
    cin>>n;

    vector<int> routes(n);
    cout<<"Enter route travel times:\n";
    for(int i=0; i<n; i++){
        cin>>routes[i];
    }
    int max1 = INT_MIN, max2 = INT_MIN;
    for(int x : routes){
        if(x > max1){
            max2 = max1;
            max1 = x;
        }else if(x > max2){
            max2 = x;
        }
    }

    cout<<"Minimum possible deadline: ";
    if(n > 1)
        cout<<max2<<endl;
    else
        cout<<max1<<endl;
}

// 2. Digital Library System ---------

class Book{
public:
    string title;
    Book(string t){
        title = t;
    }
};

class Library{
    vector<Book> books;

public:
    void addBook(string name){
        books.push_back(Book(name));
    }
    void searchBook(string key, bool exact){
        bool found = false;

        for(auto &b : books){
            if(exact && b.title == key){
                cout<<b.title<<" ";
                found = true;
            }
            else if(!exact && b.title.find(key) != string::npos){
                cout << b.title << " ";
                found = true;
            }
        }

        if(!found)
            cout<<"No book found";

        cout<<endl;
    }
};

void digitalLibrary(){
    cout<<"\n--- Digital Library System ---\n";
    cout<<"Sample books added: War, Data, Database\n";

    Library lib;
    lib.addBook("War");
    lib.addBook("Data");
    lib.addBook("Database");

    cout<<"Enter search keyword: ";
    string key;
    cin>>key;

    cout<<"Enter search type (1 = Exact, 0 = Partial): ";
    int type;
    cin>>type;

    cout<<"Search Result: ";
    lib.searchBook(key, type == 1);
}

// 3. Factory Floor Robot ---------
 
void factoryFloorRobot(){
    cout<<"\n--- Factory Floor Robot ---\n";
    cout<<"Enter number of items: ";

    int n;
    cin>>n;

    cout<<"Enter item weights:\n";
    for(int i=0; i<n; i++){
        int w;
        cin>>w;

        if(w % 15 == 0)
            cout<<"Hazardous ";
        else if(w % 3 == 0)
            cout<<"Heavy ";
        else if(w % 5 == 0)
            cout<<"Fragile ";
        else
            cout<<w<< " ";
    }
    cout<<endl;
}

// 4. The Spy’s Cipher ---------
   
void spiesCipher(){
    cout<<"\n--- The Spy's Cipher ---\n";
    cout<<"Enter original string: ";
    string original;
    cin>>original;

    cout<<"Enter scrambled string: ";
    string scrambled;
    cin>>scrambled;

    map<char, int> freq;

    for(char c : scrambled)
        freq[c]++;

    for(char c : original)
        freq[c]--;

    cout<<"Extra character found: ";
    for(auto &p : freq){
        if(p.second == 1){
            cout << p.first << endl;
            return;
        }
    }
}

// 5. Concert Seat Manager ---------
   
void concertSeatManager(){
    cout<<"\n--- Concert Seat Manager ---\n";
    cout<<"Enter number of requests: ";

    int n;
    cin>>n;

    set<int> seats;
    cout<<"Enter customer ID and seat number:\n";
    for(int i=0; i<n; i++){
        string customer;
        int seat;
        cin>>customer>>seat;

        if(seats.count(seat)){
            cout<<"First duplicate seat requested by: "<<customer<<endl;
            return;
        }
        seats.insert(seat);
    }
    cout<<"-1 (No duplicate seat request)\n";
}

// 6. Weather Station Aggregator ---------

void weatherStation(){
    cout<<"\n--- Weather Station Data Aggregator ---\n";
    cout<<"Enter number of days: ";

    int n;
    cin>>n;

    cout<<"Enter temperatures:\n";
    int maxTemp = INT_MIN;
    int recordDays = 0;

    for(int i=0; i<n; i++){
        int temp;
        cin>>temp;

        if(temp > maxTemp){
            recordDays++;
            maxTemp = temp;
        }
    }

    cout<<"Number of record breaking days: " << recordDays << endl;
}

// 7. Midpoint Finder ---------
   
struct Node{
    int data;
    Node* next;
    Node(int x){
        data = x;
        next = NULL;
    }
};

void midpointFinder(){
    cout<<"\n--- Midpoint Finder ---\n";
    cout<<"Enter number of nodes: ";

    int n;
    cin>>n;

    cout<<"Enter node values:\n";
    Node* head = NULL;
    Node* tail = NULL;

    for(int i=0; i<n; i++){
        int x;
        cin>>x;
        Node* node = new Node(x);

        if(!head)
            head = tail = node;
        else{
            tail->next = node;
            tail = node;
        }
    }

    Node* slow = head;
    Node* fast = head;

    while(fast && fast->next){
        slow = slow->next;
        fast = fast->next->next;
    }

    cout<<"Middle element: "<<slow->data<<endl;
}

// 8. Browser History Navigator ---------

void browserHistory(){
    cout<<"\n--- Browser History Navigator ---\n";
    cout<<"Enter number of actions: ";

    int q;
    cin>>q;

    stack<string> backStack, forwardStack;
    string current = "NULL";

    cout<<"Use commands: visit <page>, back, forward\n";
    while(q--){
        string action;
        cin>>action;

        if(action == "visit"){
            string page;
            cin>>page;

            if(current != "NULL")
                backStack.push(current);

            current = page;

            while(!forwardStack.empty())
                forwardStack.pop();
        }
        else if(action == "back"){
            if(!backStack.empty()){
                forwardStack.push(current);
                current = backStack.top();
                backStack.pop();
            }
        }
        else if(action == "forward"){
            if(!forwardStack.empty()){
                backStack.push(current);
                current = forwardStack.top();
                forwardStack.pop();
            }
        }
    }

    cout<<"Current page: "<<current<<endl;
}

// MAIN MENU WITH EXIT ---------

int main(){
    while(true){
        cout<<"\n========================================\n";
        cout<<" Week 3.5 - Menu Driven Program\n";
        cout<<"========================================\n";
        cout<<"1. Cosmic Courier Challenge\n";
        cout<<"2. Digital Library System\n";
        cout<<"3. Factory Floor Robot\n";
        cout<<"4. The Spy's Cipher\n";
        cout<<"5. Concert Seat Manager\n";
        cout<<"6. Weather Station Data Aggregator\n";
        cout<<"7. Midpoint Finder\n";
        cout<<"8. Browser History Navigator\n";
        cout<<"9. Exit\n";

        cout<<"Enter your choice: ";
        int choice;
        cin>>choice;

        switch(choice){
            case 1: cosmicCourier(); break;
            case 2: digitalLibrary(); break;
            case 3: factoryFloorRobot(); break;
            case 4: spiesCipher(); break;
            case 5: concertSeatManager(); break;
            case 6: weatherStation(); break;
            case 7: midpointFinder(); break;
            case 8: browserHistory(); break;
            case 9:
                cout<<"Exiting program. Thank you!\n";
                return 0;
            default:
                cout<<"Invalid choice. Try again.\n";
        }
    }
}

