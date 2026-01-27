/**
 * @filename - Task3.cpp
 * @description - Find all distant cousins of a given node
 * @author - Diya Garg
 */

#include <iostream>
#include <queue>
#include <vector>
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

TreeNode *createTree(int nodeCount)
{
    if (nodeCount == 0)
        return nullptr;

    int rootValue;
    cin >> rootValue;
    if (rootValue == -1)
        return nullptr;

    TreeNode *root = new TreeNode(rootValue);
    queue<TreeNode *> q;
    q.push(root);

    int index = 1;
    while (!q.empty() && index < nodeCount)
    {
        TreeNode *current = q.front();
        q.pop();

        int leftValue, rightValue;

        cin >> leftValue;
        index++;
        if (leftValue != -1)
        {
            current->left = new TreeNode(leftValue);
            q.push(current->left);
        }

        if (index >= nodeCount)
            break;

        cin >> rightValue;
        index++;
        if (rightValue != -1)
        {
            current->right = new TreeNode(rightValue);
            q.push(current->right);
        }
    }
    return root;
}

vector<int> findCousins(TreeNode *root, int targetValue)
{
    vector<int> cousins;
    if (!root || root->value == targetValue)
        return cousins;

    queue<TreeNode *> q;
    q.push(root);

    bool foundParentLevel = false;

    while (!q.empty() && !foundParentLevel)
    {
        int levelSize = q.size();

        for (int i = 0; i < levelSize; i++)
        {
            TreeNode *current = q.front();
            q.pop();

            // If current node is parent of X
            if ((current->left && current->left->value == targetValue) ||
                (current->right && current->right->value == targetValue))
            {
                foundParentLevel = true;
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

    // Remaining nodes in queue are cousins
    while (!q.empty())
    {
        cousins.push_back(q.front()->value);
        q.pop();
    }

    return cousins;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    cout << "Enter tree values (level order, -1 for NULL):\n";
    TreeNode *root = createTree(numberOfNodes);

    int target;
    cout << "Enter target value X: ";
    cin >> target;

    vector<int> result = findCousins(root, target);

    cout << "Distant Cousins: ";
    if (result.empty())
    {
        cout << "-1";
    }
    else
    {
        for (int value : result)
            cout << value << " ";
    }

    return 0;
}
 