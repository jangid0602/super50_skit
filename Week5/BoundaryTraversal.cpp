/**
 @Filename-BoundaryTraversal.cpp
 @Description-Prints the boundary traversal of a binary tree in anti-clockwise order.
 @Author-Aditya Virmani
*/

#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;

    Node(int val)
    {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};

Node *buildBinaryTree(const vector<string> &inputNodes)
{
    if (inputNodes.empty() || inputNodes[0] == "null")
        return nullptr;

    Node *root = nullptr;

    try
    {
        root = new Node(stoi(inputNodes[0]));
    }
    catch (...)
    {
        cout << "Error: Invalid integer value -> " << inputNodes[0] << endl;
        return nullptr;
    }

    queue<Node *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;
    while (!nodeQueue.empty() && index < inputNodes.size())
    {
        Node *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            try
            {
                currentNode->left = new Node(stoi(inputNodes[index]));
                nodeQueue.push(currentNode->left);
            }
            catch (...)
            {
                cout << "Error: Invalid integer value -> " << inputNodes[index] << endl;
                return nullptr;
            }
        }
        index++;

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            try
            {
                currentNode->right = new Node(stoi(inputNodes[index]));
                nodeQueue.push(currentNode->right);
            }
            catch (...)
            {
                cout << "Error: Invalid integer value -> " << inputNodes[index] << endl;
                return nullptr;
            }
        }
        index++;
    }
    return root;
}

void addLeafNodes(Node *root, vector<int> &boundaryNodes)
{
    if (root == nullptr)
        return;

    addLeafNodes(root->left, boundaryNodes);

    if (root->left == nullptr && root->right == nullptr)
        boundaryNodes.push_back(root->data);

    addLeafNodes(root->right, boundaryNodes);
}

vector<int> boundaryTraversal(Node *root)
{
    if (root == nullptr)
        return {};

    vector<int> boundaryNodes;

    if (root->left || root->right)
        boundaryNodes.push_back(root->data);

    Node *currentNode = root->left;
    while (true)
    {
        if (currentNode == nullptr)
            break;

        if (currentNode->left || currentNode->right)
            boundaryNodes.push_back(currentNode->data);

        if (currentNode->left)
            currentNode = currentNode->left;
        else if (currentNode->right)
            currentNode = currentNode->right;
        else
            break;
    }

    addLeafNodes(root, boundaryNodes);

    stack<int> rightBoundaryStack;
    currentNode = root->right;

    while (true)
    {
        if (currentNode == nullptr)
            break;

        if (currentNode->left || currentNode->right)
            rightBoundaryStack.push(currentNode->data);

        if (currentNode->right)
            currentNode = currentNode->right;
        else if (currentNode->left)
            currentNode = currentNode->left;
        else
            break;
    }

    while (!rightBoundaryStack.empty())
    {
        boundaryNodes.push_back(rightBoundaryStack.top());
        rightBoundaryStack.pop();
    }

    return boundaryNodes;
}

int main()
{
    cout << "Enter tree in level order (use 'null' for empty nodes):\n";
    cout << "Example: 1 2 3 null null 4 5\n";

    string inputLine;
    getline(cin, inputLine);

    stringstream inputStream(inputLine);
    vector<string> inputNodes;
    string token;

    while (inputStream >> token)
        inputNodes.push_back(token);

    Node *root = buildBinaryTree(inputNodes);

    if (root == nullptr)
        return 0;

    vector<int> result = boundaryTraversal(root);

    cout << "\nBoundary Traversal:\n";
    cout << "[";
    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i];
        if (i + 1 < result.size())
            cout << ", ";
    }
    cout << "]\n";

    return 0;
}
