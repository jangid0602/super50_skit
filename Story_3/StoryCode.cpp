#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <queue>
#include <deque>
#include <cmath>
#include <cstring>

using namespace std;

// --- Node Structures ---
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) {
        val = x;
        next = NULL;
    }
};

struct Node2D {
    int val;
    Node2D* right;
    Node2D* down;
    Node2D(int x) {
        val = x;
        right = NULL;
        down = NULL;
    }
};

struct CountNode {
    string value;
    int count;
    CountNode* next;
    CountNode(string v, int c) {
        value = v;
        count = c;
        next = NULL;
    }
};

struct MultiLevelNode {
    int val;
    MultiLevelNode* prev;
    MultiLevelNode* next;
    MultiLevelNode* child;
    MultiLevelNode(int x) {
        val = x;
        prev = NULL;
        next = NULL;
        child = NULL;
    }
};

// ----------------------
// 1. Average Stack
// ----------------------
class AverageStack {
private:
    stack<int> s;
    double runningSum;
public:
    AverageStack() {
        runningSum = 0;
    }
    void push(int val) {
        s.push(val);
        runningSum = runningSum + val;
    }
    int pop() {
        if (s.empty()) return -1;
        int v = s.top();
        s.pop();
        runningSum = runningSum - v;
        return v;
    }
    double getAverage() {
        if (s.empty()) return 0;
        return runningSum / s.size();
    }
};

// ----------------------
// 2. Python Indentation Validator
// ----------------------
bool isValidIndentation(vector<string> lines) {
    stack<int> s;
    s.push(0); // base indentation
    for (int i = 0; i < lines.size(); i++) {
        string line = lines[i];
        int count = 0;
        for (int j = 0; j < line.length(); j++) {
            if (line[j] == ' ') count++;
            else break;
        }
        if (count > s.top()) {
            s.push(count);
        } else {
            while (!s.empty() && s.top() > count) {
                s.pop();
            }
            if (s.empty() || s.top() != count) {
                return false;
            }
        }
    }
    return true;
}

// ----------------------
// 3. 2D Linked List Transpose
// ----------------------
Node2D* transpose(Node2D* head) {
    if (head == NULL) return NULL;
    Node2D* row = head;
    while (row != NULL) {
        Node2D* col = row;
        Node2D* nextRow = row->right;
        while (col != NULL) {
            Node2D* nextCol = col->down;
            Node2D* temp = col->right;
            col->right = col->down;
            col->down = temp;
            col = nextCol;
        }
        row = nextRow;
    }
    return head;
}

// ----------------------
// 4. K-Zipline Merge
// ----------------------
ListNode* kZiplineMerge(ListNode* h1, ListNode* h2, int k) {
    ListNode dummy(0);
    ListNode* tail = &dummy;

    while (h1 != NULL || h2 != NULL) {
        for (int i = 0; i < k && h1 != NULL; i++) {
            tail->next = h1;
            h1 = h1->next;
            tail = tail->next;
        }
        for (int i = 0; i < k && h2 != NULL; i++) {
            tail->next = h2;
            h2 = h2->next;
            tail = tail->next;
        }
    }
    return dummy.next;
}

// ----------------------
// 5. Prime/Composite Partition
// ----------------------
bool isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

ListNode* partitionPrimes(ListNode* head) {
    ListNode p(0), c(0), o(0);
    ListNode* pt = &p;
    ListNode* ct = &c;
    ListNode* ot = &o;

    while (head != NULL) {
        if (head->val == 1) {
            ot->next = head;
            ot = ot->next;
        } else if (isPrime(head->val)) {
            pt->next = head;
            pt = pt->next;
        } else {
            ct->next = head;
            ct = ct->next;
        }
        head = head->next;
    }
    ot->next = NULL;
    ct->next = o.next;
    pt->next = c.next;
    return p.next;
}

// ----------------------
// 6. Leaky Bucket Queue
// ----------------------
class LeakyBucket {
private:
    deque<int> q;
    int cap;
public:
    LeakyBucket(int capacity) {
        cap = capacity;
    }
    void enqueue(int item) {
        if (q.size() == cap) {
            q.pop_front();
        }
        q.push_back(item);
    }
    void process(int k) {
        cout << "[";
        for (int i = 0; i < k && !q.empty(); i++) {
            cout << q.front();
            q.pop_front();
            if (i != k-1 && !q.empty()) cout << ", ";
        }
        cout << "]" << endl;
    }
};

// ----------------------
// 7. C-String Interweaver
// ----------------------
char* interweave(char* s1, char* s2) {
    int l1 = strlen(s1);
    int l2 = strlen(s2);
    char* res = new char[l1 + l2 + 1];
    int i = 0, j = 0, k = 0;
    while (i < l1 || j < l2) {
        if (i < l1) res[k++] = s1[i++];
        if (j < l2) res[k++] = s2[j++];
    }
    res[k] = '\0';
    return res;
}

// ----------------------
// 8. Collapsing Count List
// ----------------------
CountNode* collapse(CountNode* head) {
    if (head == NULL) return NULL;
    stack<CountNode*> s;
    CountNode* curr = head;
    while (curr != NULL) {
        if (!s.empty() && s.top()->value == curr->value) {
            s.top()->count = s.top()->count + curr->count;
        } else {
            s.push(curr);
        }
        curr = curr->next;
    }

    CountNode* newHead = NULL;
    while (!s.empty()) {
        CountNode* temp = s.top();
        s.pop();
        temp->next = newHead;
        newHead = temp;
    }
    return newHead;
}

// ----------------------
// 9. Zigzag Multi-Level Flatten
// ----------------------
void zigzagFlatten(MultiLevelNode* head) {
    if (head == NULL) return;
    deque<MultiLevelNode*> q;
    q.push_back(head);
    bool lr = true;

    while (!q.empty()) {
        int size = q.size();
        vector<int> level;
        for (int i = 0; i < size; i++) {
            MultiLevelNode* curr = q.front();
            q.pop_front();
            while (curr != NULL) {
                level.push_back(curr->val);
                if (curr->child != NULL) q.push_back(curr->child);
                curr = curr->next;
            }
        }
        if (!lr) {
            for (int i = level.size()-1; i >= 0; i--) {
                cout << level[i] << " ";
            }
        } else {
            for (int i = 0; i < level.size(); i++) {
                cout << level[i] << " ";
            }
        }
        lr = !lr;
    }
    cout << endl;
}

// ----------------------
// Main
// ----------------------
int main() {
    int choice;
    cout << "Enter Problem Number (1-9): ";
    cin >> choice;

    if (choice == 1) {
        AverageStack as;
        as.push(10);
        as.push(20);
        cout << "Avg: " << as.getAverage() << endl;
    } else if (choice == 2) {
        vector<string> lines;
        lines.push_back("def func():");
        lines.push_back("  x=1");
        lines.push_back("  y=2");
        if (isValidIndentation(lines)) cout << "Valid" << endl;
        else cout << "Invalid" << endl;
    } else if (choice == 3) {
        Node2D* head = new Node2D(1);
        head->right = new Node2D(2);
        head->down = new Node2D(4);
        transpose(head);
        cout << "Transposed (1->down): " << head->down->val << endl;
    } else if (choice == 4) {
        ListNode* h1 = new ListNode(1);
        h1->next = new ListNode(2);
        ListNode* h2 = new ListNode(10);
        h2->next = new ListNode(20);
        ListNode* res = kZiplineMerge(h1, h2, 1);
        while (res != NULL) {
            cout << res->val << " ";
            res = res->next;
        }
        cout << endl;
    } else if (choice == 5) {
        ListNode* h = new ListNode(3);
        h->next = new ListNode(4);
        h->next->next = new ListNode(1);
        ListNode* res = partitionPrimes(h);
        while (res != NULL) {
            cout << res->val << " ";
            res = res->next;
        }
        cout << endl;
    } else if (choice == 6) {
        LeakyBucket lb(3);
        lb.enqueue(1);
        lb.enqueue(2);
        lb.enqueue(3);
        lb.enqueue(4);
        lb.process(2);
    } else if (choice == 7) {
        char s1[] = "abc";
        char s2[] = "DEF";
        char* res = interweave(s1, s2);
        cout << res << endl;
        delete[] res;
    } else if (choice == 8) {
        CountNode* h = new CountNode("A", 2);
        h->next = new CountNode("A", 3);
        CountNode* res = collapse(h);
        cout << res->value << ": " << res->count << endl;
    } else if (choice == 9) {
        MultiLevelNode* h = new MultiLevelNode(1);
        h->next = new MultiLevelNode(2);
        h->child = new MultiLevelNode(5);
        zigzagFlatten(h);
    } else {
        cout << "Invalid choice." << endl;
    }

    return 0;
}
