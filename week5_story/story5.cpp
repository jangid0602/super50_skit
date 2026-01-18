/**
 * @filename    - Story5.cpp
 * @description - Binary Tree Serialization and Deserialization
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
#include <queue>
#include <sstream>
using namespace std;

/* Binary Tree Node */
struct Node
{
    int data;
    Node *left;
    Node *right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

Node *buildTreeFromInput()
{
    int rootVal;
    cout << "Enter root value (-1 for NULL): ";
    cin >> rootVal;

    if (rootVal == -1)
        return nullptr;

    Node *root = new Node(rootVal);
    queue<Node *> q;
    q.push(root);

    while (!q.empty())
    {
        Node *current = q.front();
        q.pop();

        int leftVal, rightVal;

        cout << "Enter left child of " << current->data << ": ";
        cin >> leftVal;
        if (leftVal != -1)
        {
            current->left = new Node(leftVal);
            q.push(current->left);
        }

        cout << "Enter right child of " << current->data << ": ";
        cin >> rightVal;
        if (rightVal != -1)
        {
            current->right = new Node(rightVal);
            q.push(current->right);
        }
    }
    return root;
}

class Codec
{
public:
    string serialize(Node *root)
    {
        if (!root)
            return "";

        string result;
        queue<Node *> q;
        q.push(root);

        while (!q.empty())
        {
            Node *current = q.front();
            q.pop();

            if (!current)
            {
                result += "#,";
            }
            else
            {
                result += to_string(current->data) + ",";
                q.push(current->left);
                q.push(current->right);
            }
        }
        return result;
    }

    Node *deserialize(const string &data)
    {
        if (data.empty())
            return nullptr;

        stringstream ss(data);
        string token;

        getline(ss, token, ',');
        Node *root = new Node(stoi(token));

        queue<Node *> q;
        q.push(root);

        while (!q.empty())
        {
            Node *current = q.front();
            q.pop();

            getline(ss, token, ',');
            if (token != "#")
            {
                current->left = new Node(stoi(token));
                q.push(current->left);
            }

            getline(ss, token, ',');
            if (token != "#")
            {
                current->right = new Node(stoi(token));
                q.push(current->right);
            }
        }
        return root;
    }
};

void printLevelOrder(Node *root)
{
    if (!root)
        return;

    queue<Node *> q;
    q.push(root);

    while (!q.empty())
    {
        Node *current = q.front();
        q.pop();

        if (current)
        {
            cout << current->data << " ";
            q.push(current->left);
            q.push(current->right);
        }
    }
}

int main()
{
    Node *root = buildTreeFromInput();

    Codec codec;
    string serializedTree = codec.serialize(root);
    cout << "\nSerialized Tree: " << serializedTree << endl;

    Node *restoredRoot = codec.deserialize(serializedTree);

    cout << "Level Order of Deserialized Tree: ";
    printLevelOrder(restoredRoot);

    return 0;
}
