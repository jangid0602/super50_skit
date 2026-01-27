/**
 * @filename - Story2.cpp
 * @description -  Vertical Silhouette
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class TreeNode
{
public:
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data)
    {
        value = data;
        left = right = nullptr;
    }
};

TreeNode *createTreeLevelOrder(int nodeCount)
{
    if (nodeCount == 0)
        return nullptr;

    int rootValue;
    cin >> rootValue;

    if (rootValue == -1)
        return nullptr;

    TreeNode *root = new TreeNode(rootValue);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;

    while (!nodeQueue.empty() && index < nodeCount)
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        int leftValue, rightValue;

        // Left child
        cin >> leftValue;
        index++;
        if (leftValue != -1)
        {
            currentNode->left = new TreeNode(leftValue);
            nodeQueue.push(currentNode->left);
        }

        if (index >= nodeCount)
            break;

        // Right child
        cin >> rightValue;
        index++;
        if (rightValue != -1)
        {
            currentNode->right = new TreeNode(rightValue);
            nodeQueue.push(currentNode->right);
        }
    }

    return root;
}

vector<vector<int>> verticalSilhouette(TreeNode *root)
{
    vector<vector<int>> result;
    if (!root)
        return result;

    queue<pair<TreeNode *, int>> nodeQueue;
    nodeQueue.push({root, 0});

    vector<vector<int>> columns(2000);
    int minHorizontalDistance = 0, maxHorizontalDistance = 0;

    while (!nodeQueue.empty())
    {
        auto current = nodeQueue.front();
        nodeQueue.pop();

        TreeNode *currentNode = current.first;
        int horizontalDistance = current.second;

        columns[horizontalDistance + 1000].push_back(currentNode->value);

        minHorizontalDistance = min(minHorizontalDistance, horizontalDistance);
        maxHorizontalDistance = max(maxHorizontalDistance, horizontalDistance);

        if (currentNode->left)
            nodeQueue.push({currentNode->left, horizontalDistance - 1});

        if (currentNode->right)
            nodeQueue.push({currentNode->right, horizontalDistance + 1});
    }

    for (int hd = minHorizontalDistance; hd <= maxHorizontalDistance; hd++)
    {
        result.push_back(columns[hd + 1000]);
    }

    return result;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes == 0)
    {
        cout << "Tree is empty\n";
        return 0;
    }

    cout << "Enter values (level order, -1 for NULL):\n";
    TreeNode *root = createTreeLevelOrder(numberOfNodes);

    vector<vector<int>> answer = verticalSilhouette(root);

    cout << "\nVertical Silhouette:\n";
    for (auto column : answer)
    {
        cout << "[ ";
        for (int value : column)
        {
            cout << value << " ";
        }
        cout << "] ";
    }

    return 0;
}
