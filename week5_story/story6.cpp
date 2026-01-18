/**
 * @filename    - story6.cpp
 * @description - Find the longest path in a binary tree with given k-sum
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

void insertNode(Node *root, int value)
{
    queue<Node *> q;
    q.push(root);

    while (!q.empty())
    {
        Node *current = q.front();
        q.pop();

        if (!current->left)
        {
            current->left = new Node(value);
            return;
        }
        else
            q.push(current->left);

        if (!current->right)
        {
            current->right = new Node(value);
            return;
        }
        else
            q.push(current->right);
    }
}

int maxPathLength = INT_MIN;

void calculatePath(Node *root, int targetSum, int currentSum, int length)
{
    if (!root)
        return;

    currentSum += root->data;
    length++;

    if (currentSum == targetSum)
        maxPathLength = max(maxPathLength, length);

    calculatePath(root->left, targetSum, currentSum, length);
    calculatePath(root->right, targetSum, currentSum, length);
}

void evaluateAllPaths(Node *root, int targetSum)
{
    if (!root)
        return;

    calculatePath(root, targetSum, 0, 0);
    evaluateAllPaths(root->left, targetSum);
    evaluateAllPaths(root->right, targetSum);
}

int main()
{
    int nodeCount;
    cout << "Enter number of nodes: ";
    cin >> nodeCount;

    if (nodeCount == 0)
    {
        cout << "Tree cannot be empty\n";
        return 0;
    }

    int rootValue;
    cout << "Enter the root node value: ";
    cin >> rootValue;

    Node *root = new Node(rootValue);

    for (int i = 0; i < nodeCount - 1; i++)
    {
        int val;
        cout << "Enter node value: ";
        cin >> val;
        insertNode(root, val);
    }

    cout << "Tree created successfully\n";

    int targetSum;
    cout << "Enter the target sum: ";
    cin >> targetSum;

    evaluateAllPaths(root, targetSum);

    cout << "The longest path is: "
         << (maxPathLength == INT_MIN ? -1 : maxPathLength)
         << endl;

    return 0;
}
