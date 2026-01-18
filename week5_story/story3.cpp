/**
 * @filename    - story3.cpp
 * @description - Program to find all distant cousins of a given node
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

Node *buildTree(int totalNodes)
{
    if (totalNodes == 0)
        return nullptr;

    int rootData;
    cin >> rootData;

    if (rootData == -1)
        return nullptr;

    Node *root = new Node(rootData);
    queue<Node *> q;
    q.push(root);

    int count = 1;

    while (!q.empty() && count < totalNodes)
    {
        Node *current = q.front();
        q.pop();

        int leftVal, rightVal;

        cin >> leftVal;
        count++;
        if (leftVal != -1)
        {
            current->left = new Node(leftVal);
            q.push(current->left);
        }

        if (count >= totalNodes)
            break;

        cin >> rightVal;
        count++;
        if (rightVal != -1)
        {
            current->right = new Node(rightVal);
            q.push(current->right);
        }
    }

    return root;
}

vector<int> getDistantCousins(Node *root, int target)
{
    vector<int> cousins;
    if (!root || root->data == target)
        return cousins;

    queue<Node *> q;
    q.push(root);

    bool parentLevelFound = false;

    while (!q.empty() && !parentLevelFound)
    {
        int levelSize = q.size();

        for (int i = 0; i < levelSize; i++)
        {
            Node *current = q.front();
            q.pop();

            if ((current->left && current->left->data == target) ||
                (current->right && current->right->data == target))
            {
                parentLevelFound = true;
            }
            else
            {
                if (current->left)
                    q.push(current->left);
                if (current->right)
                    q.push(current->right);
            }
        }
    }

    while (!q.empty())
    {
        cousins.push_back(q.front()->data);
        q.pop();
    }

    return cousins;
}

int main()
{
    int nodeCount;
    cout << "Enter number of nodes: ";
    cin >> nodeCount;

    cout << "Enter tree values (level order, -1 for NULL):\n";
    Node *root = buildTree(nodeCount);

    int targetValue;
    cout << "Enter target value X: ";
    cin >> targetValue;

    vector<int> cousins = getDistantCousins(root, targetValue);

    cout << "Distant Cousins: ";
    if (cousins.empty())
    {
        cout << "-1";
    }
    else
    {
        for (int val : cousins)
            cout << val << " ";
    }

    return 0;
}
