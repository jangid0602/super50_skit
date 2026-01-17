/**
 * @filename - Story7.cpp
 * @description -  Boundry traversal
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <queue>
#include <set>
using namespace std;

class TreeNode
{
public:
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data) : value(data), left(nullptr), right(nullptr) {}
};

void insert(TreeNode *root, int node, char direction)
{
    if (!root)
        return;

    if (direction == 'l' || direction == 'L')
    {
        if (!root->left)
        {
            root->left = new TreeNode(node);
            return;
        }
        else
        {
            insert(root->left, node, direction);
        }
    }
    else if (direction == 'r' || direction == 'R')
    {
        if (!root->right)
        {
            root->right = new TreeNode(node);
            return;
        }
        else
        {
            insert(root->right, node, direction);
        }
    }
    else
    {
        cout << "Invalid input. Try again.\n";
        insert(root, node, direction);
    }
}
vector<vector<int>> levelOrder(TreeNode *root)
{
    queue<TreeNode *> store;
    vector<vector<int>> levelWise;
    if (!root)
        return levelWise;
    store.push(root);

    while (!store.empty())
    {
        int storeSize = store.size();
        vector<int> level;
        for (int i = 0; i < storeSize; i++)
        {
            TreeNode *currentNode = store.front();
            store.pop();
            level.push_back(currentNode->value);

            if (currentNode->left)
                store.push(currentNode->left);
            if (currentNode->right)
                store.push(currentNode->right);
        }
        levelWise.push_back(level);
    }
    return levelWise;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes == 0)
    {
        cout << "Tree cannot be empty\n";
        return 0;
    }

    int value;
    cout << "Enter the root node value: ";
    cin >> value;

    TreeNode *root = new TreeNode(value);

    for (int i = 0; i < numberOfNodes - 1; i++)
    {
        int nodeValue;
        char direction;

        cout << "Enter node value: ";
        cin >> nodeValue;

        cout << "Enter direction (l/L or r/R): ";
        cin >> direction;

        insert(root, nodeValue, direction);
    }

    cout << "Tree created successfully\n";

    vector<vector<int>> levelWise = levelOrder(root);
    vector<int> boundaryTraversal;

    int totalLevel = levelWise.size();

    boundaryTraversal.push_back(root->value);

    /*  Left boundary (excluding leaves) */
    for (int i = 1; i < totalLevel - 1; i++)
    {
        if (levelWise[i].size() > 1)
            boundaryTraversal.push_back(levelWise[i][0]);
    }

    /* Leaf nodes (left to right) */
    for (int i = 1; i < totalLevel; i++)
    {
        int levelSize = levelWise[i].size();

        // skewed tree case
        if (levelSize == 1)
        {
            boundaryTraversal.push_back(levelWise[i][0]);
        }
        // last level leaves
        else if (i == totalLevel - 1)
        {
            for (int j = 0; j < levelSize; j++)
                boundaryTraversal.push_back(levelWise[i][j]);
        }
    }

    /*  Right boundary (excluding leaves, bottom → top) */
    for (int i = totalLevel - 2; i >= 1; i--)
    {
        if (levelWise[i].size() > 1)
            boundaryTraversal.push_back(
                levelWise[i][levelWise[i].size() - 1]);
    }


    cout << "Boundry Travesal is : \n";
    for (auto it : boundaryTraversal)
    {
        cout << it << " ";
    }
}