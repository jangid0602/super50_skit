/**
 * @filename    - Story7.cpp
 * @description - Boundary Traversal of a Binary Tree
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
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

void insertNode(Node *root, int value, char side)
{
    if (!root)
        return;

    if (side == 'l' || side == 'L')
    {
        if (!root->left)
            root->left = new Node(value);
        else
            insertNode(root->left, value, side);
    }
    else if (side == 'r' || side == 'R')
    {
        if (!root->right)
            root->right = new Node(value);
        else
            insertNode(root->right, value, side);
    }
    else
    {
        cout << "Invalid direction. Try again.\n";
    }
}

vector<vector<int>> getLevelOrder(Node *root)
{
    vector<vector<int>> levels;
    if (!root)
        return levels;

    queue<Node *> q;
    q.push(root);

    while (!q.empty())
    {
        int size = q.size();
        vector<int> level;

        for (int i = 0; i < size; i++)
        {
            Node *current = q.front();
            q.pop();

            level.push_back(current->data);

            if (current->left)
                q.push(current->left);
            if (current->right)
                q.push(current->right);
        }
        levels.push_back(level);
    }
    return levels;
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
        int value;
        char direction;

        cout << "Enter node value: ";
        cin >> value;

        cout << "Enter direction (l/L or r/R): ";
        cin >> direction;

        insertNode(root, value, direction);
    }

    cout << "Tree created successfully\n";

    vector<vector<int>> levels = getLevelOrder(root);
    vector<int> boundary;

    int totalLevels = levels.size();

    // Root
    boundary.push_back(root->data);

    // Left boundary (excluding leaves)
    for (int i = 1; i < totalLevels - 1; i++)
    {
        if (levels[i].size() > 1)
            boundary.push_back(levels[i][0]);
    }

    // Leaf nodes
    for (int i = 1; i < totalLevels; i++)
    {
        int size = levels[i].size();

        if (size == 1)
        {
            boundary.push_back(levels[i][0]);
        }
        else if (i == totalLevels - 1)
        {
            for (int j = 0; j < size; j++)
                boundary.push_back(levels[i][j]);
        }
    }

    // Right boundary (excluding leaves, bottom to top)
    for (int i = totalLevels - 2; i >= 1; i--)
    {
        if (levels[i].size() > 1)
            boundary.push_back(levels[i].back());
    }

    cout << "Boundary Traversal is:\n";
    for (int val : boundary)
        cout << val << " ";

    return 0;
}
