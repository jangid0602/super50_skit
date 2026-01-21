/**
 @Filename-LCAOfSet.cpp
 @Description-Finds the Lowest Common Ancestor (LCA) of a set of nodes in a binary tree.
 @Author-Aditya Virmani
*/

#include <bits/stdc++.h>
using namespace std;

class TreeNode
{
public:
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int val)
    {
        value = val;
        left = nullptr;
        right = nullptr;
    }
};

TreeNode *buildBinaryTree(const vector<string> &inputNodes)
{
    if (inputNodes.empty() || inputNodes[0] == "null")
        return nullptr;

    TreeNode *root = nullptr;

    try
    {
        root = new TreeNode(stoi(inputNodes[0]));
    }
    catch (...)
    {
        cout << "Error: Invalid integer value -> " << inputNodes[0] << endl;
        return nullptr;
    }

    queue<TreeNode *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;
    while (!nodeQueue.empty() && index < inputNodes.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            try
            {
                currentNode->left = new TreeNode(stoi(inputNodes[index]));
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
                currentNode->right = new TreeNode(stoi(inputNodes[index]));
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

TreeNode *findLCA(TreeNode *root, TreeNode *firstNode, TreeNode *secondNode)
{
    if (root == nullptr || root == firstNode || root == secondNode)
        return root;

    TreeNode *leftLCA = findLCA(root->left, firstNode, secondNode);
    TreeNode *rightLCA = findLCA(root->right, firstNode, secondNode);

    if (leftLCA && rightLCA)
        return root;

    return leftLCA ? leftLCA : rightLCA;
}

TreeNode *findNode(TreeNode *root, int targetValue)
{
    if (root == nullptr)
        return nullptr;

    if (root->value == targetValue)
        return root;

    TreeNode *leftSearch = findNode(root->left, targetValue);
    if (leftSearch)
        return leftSearch;

    return findNode(root->right, targetValue);
}

TreeNode *findLCAOfSet(TreeNode *root, vector<TreeNode *> &nodeList)
{
    if (nodeList.empty())
        return nullptr;

    TreeNode *currentLCA = nodeList[0];

    for (int i = 1; i < nodeList.size(); i++)
    {
        currentLCA = findLCA(root, currentLCA, nodeList[i]);
    }
    return currentLCA;
}

int main()
{
    cout << "Enter tree in level order (use 'null' for empty nodes):\n";
    cout << "Example: 1 2 3 4 5 6 7\n";

    string inputLine;
    getline(cin, inputLine);

    stringstream inputStream(inputLine);
    vector<string> inputNodes;
    string token;

    while (inputStream >> token)
        inputNodes.push_back(token);

    TreeNode *root = buildBinaryTree(inputNodes);
    if (root == nullptr)
        return 0;

    int numberOfNodes;
    cout << "\nEnter number of nodes in the set: ";
    cin >> numberOfNodes;

    vector<TreeNode *> nodeSet;
    cout << "Enter node values:\n";

    for (int i = 0; i < numberOfNodes; i++)
    {
        int value;
        cin >> value;

        TreeNode *nodePtr = findNode(root, value);
        if (nodePtr == nullptr)
        {
            cout << "Error: Node " << value << " not found in tree.\n";
            return 0;
        }
        nodeSet.push_back(nodePtr);
    }

    TreeNode *lcaResult = findLCAOfSet(root, nodeSet);

    if (lcaResult)
        cout << "\nLowest Common Ancestor of given set: " << lcaResult->value << endl;
    else
        cout << "\nLCA not found.\n";

    return 0;
}
