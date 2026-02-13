/**
 * @filename:   Task8.cpp
 * @description: Lowest Common Ancestor (LCA) of a Set
 * @author:      Ayushi Shukla
 */

#include <iostream>
#include <vector>
using namespace std;

class TreeNode
{
public:
    int data;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int value)
    {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

void insertNode(TreeNode *rootNode, int nodeValue, char direction)
{
    if (!rootNode)
        return;

    if (direction == 'l' || direction == 'L')
    {
        if (!rootNode->left)
            rootNode->left = new TreeNode(nodeValue);
        else
            insertNode(rootNode->left, nodeValue, direction);
    }
    else if (direction == 'r' || direction == 'R')
    {
        if (!rootNode->right)
            rootNode->right = new TreeNode(nodeValue);
        else
            insertNode(rootNode->right, nodeValue, direction);
    }
    else
    {
        cout << "Invalid direction\n";
    }
}

// Find a node by value
TreeNode *findNode(TreeNode *rootNode, int value)
{
    if (!rootNode)
        return nullptr;

    if (rootNode->data == value)
        return rootNode;

    TreeNode *leftResult = findNode(rootNode->left, value);
    if (leftResult)
        return leftResult;

    return findNode(rootNode->right, value);
}

// LCA of two nodes
TreeNode *lowestCommonAncestor(
    TreeNode *rootNode,
    TreeNode *firstNode,
    TreeNode *secondNode)
{
    if (!rootNode)
        return nullptr;

    if (rootNode == firstNode || rootNode == secondNode)
        return rootNode;

    TreeNode *leftLCA =
        lowestCommonAncestor(rootNode->left, firstNode, secondNode);
    TreeNode *rightLCA =
        lowestCommonAncestor(rootNode->right, firstNode, secondNode);

    if (leftLCA && rightLCA)
        return rootNode;

    return leftLCA ? leftLCA : rightLCA;
}

// LCA of a set of nodes
TreeNode *findCommonAncestor(TreeNode *rootNode, vector<TreeNode *> &nodes)
{
    if (nodes.empty())
        return nullptr;

    if (nodes.size() == 1)
        return nodes[0];

    TreeNode *ancestor =
        lowestCommonAncestor(rootNode, nodes[0], nodes[1]);

    for (int i = 2; i < nodes.size(); i++)
    {
        ancestor =
            lowestCommonAncestor(rootNode, ancestor, nodes[i]);
    }
    return ancestor;
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

    int rootValue;
    cout << "Enter the root node value: ";
    cin >> rootValue;

    TreeNode *rootNode = new TreeNode(rootValue);

    for (int i = 0; i < numberOfNodes - 1; i++)
    {
        int nodeValue;
        char direction;

        cout << "Enter node value: ";
        cin >> nodeValue;

        cout << "Enter direction (L/R): ";
        cin >> direction;

        insertNode(rootNode, nodeValue, direction);
    }

    cout << "Tree created successfully\n";

    int setSize;
    cout << "Enter number of nodes to find LCA: ";
    cin >> setSize;

    if (setSize == 0)
    {
        cout << "Set cannot be empty\n";
        return 0;
    }

    vector<TreeNode *> setOfNodes;

    for (int i = 0; i < setSize; i++)
    {
        int value;
        cout << "Enter node value: ";
        cin >> value;

        TreeNode *node = findNode(rootNode, value);
        if (node)
            setOfNodes.push_back(node);
        else
            cout << "Node " << value << " not found in tree\n";
    }

    TreeNode *answer =
        findCommonAncestor(rootNode, setOfNodes);

    if (answer)
        cout << "Common Ancestor is: " << answer->data << endl;
    else
        cout << "No common ancestor found\n";

    return 0;
}
