/**
 @Filename-VerticalSilhouette.cpp
 @Description-Returns the values of nodes grouped by their horizontal distance from left to right.
 @Author-Aditya Virmani
 */

#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
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

vector<vector<int>> verticalSilhouette(TreeNode *root)
{
    vector<vector<int>> result;
    if (root == nullptr)
        return result;

    queue<pair<TreeNode *, pair<int, int>>> nodeQueue;
    map<int, map<int, multiset<int>>> verticalMap;

    nodeQueue.push({root, {0, 0}});

    while (!nodeQueue.empty())
    {
        auto current = nodeQueue.front();
        nodeQueue.pop();

        TreeNode *currentNode = current.first;
        int horizontalDistance = current.second.first;
        int currentLevel = current.second.second;

        verticalMap[horizontalDistance][currentLevel].insert(currentNode->value);

        if (currentNode->left)
            nodeQueue.push({currentNode->left, {horizontalDistance - 1, currentLevel + 1}});

        if (currentNode->right)
            nodeQueue.push({currentNode->right, {horizontalDistance + 1, currentLevel + 1}});
    }

    for (auto &verticalEntry : verticalMap)
    {
        vector<int> column;
        for (auto &levelEntry : verticalEntry.second)
        {
            for (int val : levelEntry.second)
            {
                column.push_back(val);
            }
        }
        result.push_back(column);
    }

    return result;
}

int main()
{
    cout << "Enter tree in level order (use 'null' for empty nodes).Only null and integer values are allowed:\n";
    cout << "Example: 3 9 20 null null 15 7\n";

    string inputLine;
    getline(cin, inputLine);

    if (inputLine.empty())
    {
        cout << "Error: No input provided.\n";
        return 0;
    }

    stringstream stream(inputLine);
    vector<string> inputNodes;
    string token;

    while (stream >> token)
    {
        inputNodes.push_back(token);
    }

    if (inputNodes[0] == "null")
    {
        cout << "Error: Root node cannot be null.\n";
        return 0;
    }

    TreeNode *root = buildBinaryTree(inputNodes);

    if (root == nullptr)
        return 0;

    vector<vector<int>> output = verticalSilhouette(root);

    cout << "\nVertical Silhouette Output:\n";
    cout << "[";
    for (int i = 0; i < output.size(); i++)
    {
        cout << "[";
        for (int j = 0; j < output[i].size(); j++)
        {
            cout << output[i][j];
            if (j + 1 < output[i].size())
                cout << ", ";
        }
        cout << "]";
        if (i + 1 < output.size())
            cout << ", ";
    }
    cout << "]\n";

    return 0;
}