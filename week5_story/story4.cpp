/**
 * @filename    - story4.cpp
 * @description - Program to find minimum cameras needed to cover a binary tree
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
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

/*
Node states:
0 -> Needs camera
1 -> Has camera
2 -> Covered by camera
*/
int totalCameras = 0;

int monitorTree(Node *root)
{
    if (!root)
        return 2;

    int leftState = monitorTree(root->left);
    int rightState = monitorTree(root->right);

    if (leftState == 0 || rightState == 0)
    {
        totalCameras++;
        return 1;
    }

    if (leftState == 1 || rightState == 1)
        return 2;

    return 0;
}

int main()
{
    int nodeCount;
    cout << "Enter number of nodes: ";
    cin >> nodeCount;

    cout << "Enter tree values (level order, -1 for NULL):\n";
    Node *root = buildTree(nodeCount);

    if (monitorTree(root) == 0)
        totalCameras++;

    cout << "Minimum cameras required: " << totalCameras << endl;

    return 0;
}
