/**
 * @filename - Story8.cpp
 * @description - Lowest Common Ancestor (LCA) of a Set
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;

class TreeNode {
public:
    int data;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int value) {
        data = value;
        left = NULL;
        right = NULL;
    }
};

void insert(TreeNode* root, int node, char direction) {
    if (!root) return;

    if (direction == 'l' || direction == 'L') {
        if (!root->left)
            root->left = new TreeNode(node);
        else
            insert(root->left, node, direction);
    }
    else if (direction == 'r' || direction == 'R') {
        if (!root->right)
            root->right = new TreeNode(node);
        else
            insert(root->right, node, direction);
    }
    else {
        cout << "Invalid direction\n";
    }
}

// Find a node by value in the tree
TreeNode* findNode(TreeNode* root, int data) {
    if (!root) return NULL;
    if (root->data == data) return root;

    TreeNode* left = findNode(root->left, data);
    if (left) return left;

    return findNode(root->right, data);
}

// LCA of two nodes
TreeNode* commonAncestor(TreeNode* root, TreeNode* firstNode, TreeNode* secondNode) {
    if (!root) return NULL;
    if (root == firstNode || root == secondNode) return root;

    TreeNode* foundFromLeft = commonAncestor(root->left, firstNode, secondNode);
    TreeNode* foundFromRight = commonAncestor(root->right, firstNode, secondNode);

    if (foundFromLeft &&foundFromRight) return root;
    return foundFromLeft ? foundFromLeft : foundFromRight;
}

// LCA of a set of nodes
TreeNode* findCommonAncestor(TreeNode* root, vector<TreeNode*> nodes) {
    if (nodes.size() == 0) return NULL;
    if (nodes.size() == 1) return nodes[0];

    TreeNode* ancestor = commonAncestor(root, nodes[0], nodes[1]);
    for (int i = 2; i < nodes.size(); i++) {
        ancestor = commonAncestor(root, ancestor, nodes[i]);
    }
    return ancestor;
}

int main() {
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes == 0) {
        cout << "Tree cannot be empty\n";
        return 0;
    }

    int value;
    cout << "Enter the root node value: ";
    cin >> value;

    TreeNode* root = new TreeNode(value);

    for (int i = 0; i < numberOfNodes - 1; i++) {
        int nodeValue;
        char direction;

        cout << "Enter node value: ";
        cin >> nodeValue;

        cout << "Enter direction (l/L or r/R): ";
        cin >> direction;

        insert(root, nodeValue, direction);
    }

    cout << "Tree created successfully\n";

    int setSize;
    cout << "Enter number of nodes to find LCA: ";
    cin >> setSize;

    if (setSize == 0) {
        cout << "Set cannot be empty\n";
        return 0;
    }

    vector<TreeNode*> setOfNodes;
    for (int i = 0; i < setSize; i++) {
        int data;
        cout << "Enter node value: ";
        cin >> data;

        TreeNode* node = findNode(root, data);
        if (node)
            setOfNodes.push_back(node);
        else
            cout << "Node " << data << " not found in tree\n";
    }

    TreeNode* answer = findCommonAncestor(root, setOfNodes);

    if (answer)
        cout << "Common Ancestor is: " << answer->data << endl;
    else
        cout << "No common ancestor found\n";

    return 0;
}
