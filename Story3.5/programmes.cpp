#include<iostream>
#include<bits/stdc++.h>
using namespace std;
    struct Node
{
    int data;
    Node* next;
    Node(int x)
    {
        data = x;
        next = NULL;
    }
};
class Solution {
    public:

    // -------- Problem 1: The Cosmic Courier Challenge --------
int CosmicCourier(vector<int>& routes)
{
    int maxVal = INT_MIN;
    int countMax = 0;

    // Find maximum value and its frequency
    for (int time : routes)
    {
        if (time > maxVal)
        {
            maxVal = time;
            countMax = 1;
        }
        else if (time == maxVal)
        {
            countMax++;
        }
    }

    // If maximum appears more than once, removing one route won't help
    if (countMax > 1)
        return maxVal;

    // Find second maximum
    int secondMax = INT_MIN;
    for (int time : routes)
    {
        if (time != maxVal)
            secondMax = max(secondMax, time);
    }

    return secondMax;
}


    // -------- Problem 2: The Digital Library System --------
    vector<string> books;   // encapsulated data
    // Add a book
    void addBook(string title)
    {
        books.push_back(title);
    }

    // Remove a book
    void removeBook(string title)
    {
        for (auto it = books.begin(); it != books.end(); it++)
        {
            if (*it == title)
            {
                books.erase(it);
                return;
            }
        }
    }

    // Exact match search 
    bool searchBook(string title)
    {
        for (string book : books)
        {
            if (book == title)
                return true;
        }
        return false;
    }

    // Partial match search
    bool searchBook(string title, bool partial)
    {
        for (string book : books)
        {
            if (book.find(title) != string::npos)
                return true;
        }
        return false;
    }


    // --------Problem 3:The factory Floor Robot--------
    int FactoryFloorRobot(vector<int>& arr,int n)
    {
    for(int i=0;i<n;i++)
    {
        if(arr[i]%15==0)
        {
            cout<<"Hazardous"<<" ";
        }
        else if(arr[i]%3==0)
        {
            cout<<"Heavy"<<"";
        }
        else if(arr[i]%5==0)
        {
            cout<<"Fragile"<< " ";
        }
        else
        {
            cout<<arr[i]<<" ";
        }
    }
}
    //--------Problem 4:The Spy's Cipher--------
    char SpyCipher(string original, string scrambled)
    {
        unordered_map<char,int> freq;
        for(char ch:original)
        {
            freq[ch]++; 
        }
        for(char ch:scrambled)
        {
            freq[ch]--;
            if(freq[ch]<0)
            {
                return ch;
            }
        }   
    }

    // -------- Problem 5: The Concert Seat Manager --------
string ConcertSeatManager(vector<pair<string, int>>& requests)
{
    unordered_set<int> bookedSeats;

    for (auto req : requests)
    {
        string customer = req.first;
        int seat = req.second;

        // if seat already booked
        if (bookedSeats.find(seat) != bookedSeats.end())
        {
            return customer;
        }

        // otherwise book the seat
        bookedSeats.insert(seat);
    }

    return "-1";   // no duplicate seat request
}


    // --------Problem 6:The Weather Station Data Aggregator-------- 
    int countRecordDays(vector<int>& temps)
{
    int maxTemp = temps[0];
    int recordDays = 1;

    for (int i = 1; i < temps.size(); i++)
    {
        if (temps[i] > maxTemp)
        {
            recordDays++;
            maxTemp = temps[i];
        }
    }
    return recordDays;
}

// -------- Problem 7:The Midpoint Finder--------

int findMiddle(Node* head)
{
    Node* slow = head;
    Node* fast = head;
    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow->data;
}

// -------- Problem 8: Browser History Navigator --------
stack<string> backStack;
stack<string> forwardStack;
string currentPage = "NULL";

void visitPage(string page)
{
    if (currentPage != "NULL")
        backStack.push(currentPage);

    currentPage = page;

    // clear forward history
    while (!forwardStack.empty())
        forwardStack.pop();
}

void goBack()
{
    if (backStack.empty())
    {
        currentPage = "NULL";
        return;
    }

    forwardStack.push(currentPage);
    currentPage = backStack.top();
    backStack.pop();
}

void goForward()
{
    if (forwardStack.empty())
    {
        currentPage = "NULL";
        return;
    }

    backStack.push(currentPage);
    currentPage = forwardStack.top();
    forwardStack.pop();
}

string getCurrentPage()
{
    return currentPage;
}

};
int main()
{
    Solution sol;
    int choice;
    cout << "Choose Problem (1-8): ";
    cin >> choice;

    if (choice == 1)
{
    int n;
    cout << "Enter number of routes: ";
    cin >> n;

    vector<int> routes(n);
    cout << "Enter travel times: ";
    for (int i = 0; i < n; i++)
        cin >> routes[i];

    int result = sol.CosmicCourier(routes);
    cout << result << endl;
}

 if (choice == 2)
{
    // Test Case 1
    sol.addBook("War");
    cout << sol.searchBook("War") << endl;   // exact

    // reset for next test
    sol.books.clear();

    // Test Case 2
    sol.addBook("Data");
    sol.addBook("Database");
    cout << sol.searchBook("Data", true) << endl;  // partial

    // reset
    sol.books.clear();

    // Test Case 3
    sol.addBook("A");
    sol.removeBook("A");
    cout << sol.searchBook("A") << endl;
}

    if(choice==3)
    {
    int n;
    cout<<"Enter size of array: ";
    cin>>n;
    vector<int> arr(n);
    cout<<"Enter elements: ";
    for(int i=0;i<n;i++) cin>>arr[i];
    sol.FactoryFloorRobot(arr,n);
    }

    if (choice==4)
    {
        string original, scrambled;
        cout<<"Enter original and scrambled string"<<endl;
        cin >> original >> scrambled;
        char result = sol.SpyCipher(original, scrambled);
        cout<<result;
    }

    if (choice == 5)
   {
    int n;
    cout << "Enter number of requests: ";
    cin >> n;
    vector<pair<string, int>> requests;
    cout << "Enter CustomerID and SeatNumber:\n";
    for (int i = 0; i < n; i++)
    {
        string customer;
        int seat;
        cin >> customer >> seat;
        requests.push_back({customer, seat});
    }
    string result = sol.ConcertSeatManager(requests);
    cout << result << endl;
    }

    if(choice==6)
    {
        int n;
        cout<<"enter number of days:";
        cin>>n;
        vector<int>temps(n);
        for(int i=0;i<n;i++)
        {
            cin>>temps[i];
        }
        int record=sol.countRecordDays( temps);
        cout<<record<<" "<<endl;

    }

    if (choice == 7)
   {
    int n;
    cout << "Enter number of nodes: ";
    cin >> n;
    Node* head = NULL;
    cout << "Enter values: ";
    for (int i = 0; i < n; i++)
    {
        int val;
        cin >> val;
        Node* newNode = new Node(val);
        if (head == NULL)
        {
            head = newNode;
        }
        else
        {
            Node* temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }
    int mid = sol.findMiddle(head);
    cout << "Middle element is: " << mid << endl;
    }
}