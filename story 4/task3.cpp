/**
 * @filename - Task3.cpp
 * @description - The Digital Ancestry Tree (Recursion) 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <queue>
using namespace std;

struct Node {
    int value;
    Node* left;
    Node* right;
    Node(int v) : value(v), left(NULL), right(NULL) {}
};

Node* buildTree() {
    int rootValue;
    cout << "Enter root value: ";
    cin >> rootValue;

    Node* root = new Node(rootValue);
    queue<Node*> pendingNodes;
    pendingNodes.push(root);

    while (!pendingNodes.empty()) {
        Node* current = pendingNodes.front();
        pendingNodes.pop();

        int leftValue, rightValue;
        cout << "Enter left value: ";
        cin >> leftValue;
        cout << "Enter right value: ";
        cin >> rightValue;

        if (leftValue != -1) {
            current->left = new Node(leftValue);
            pendingNodes.push(current->left);
        }
        if (rightValue != -1) {
            current->right = new Node(rightValue);
            pendingNodes.push(current->right);
        }
    }
    return root;
}

int calculateSum(Node* root) {
    if (root == NULL) return 0;
    return root->value + calculateSum(root->left) + calculateSum(root->right);
}

int main() {
    cout << "Enter tree values in level order\n";
    Node* root = buildTree();
    int totalSum = calculateSum(root);
    cout << totalSum;
    return 0;
}
