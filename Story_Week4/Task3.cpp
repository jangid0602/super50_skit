/**
 * @filename - Task3.cpp
 * @description - The Digital Ancestry Tree
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <queue>
using namespace std;
// Definition for a binary tree node.
struct Node
{
    int data;
    Node *left;
    Node *right;
    Node(int val)
    {
        data = val;
        left = NULL;
        right = NULL;
    }
};
void inorder(Node *root)
{
    if (root == NULL)
    {
        return;
    }
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

Node *insertTree(Node *root, int val)
{
    if (root == NULL)
    { // tree is empty
        return new Node(val);
    }
    // level order insertion
    queue<Node *> q;
    q.push(root);
    while (!q.empty())
    {
        Node *temp = q.front();
        q.pop();
        if (temp->left == NULL)
        {
            temp->left = new Node(val);
            return root;
        }
        else
        {
            q.push(temp->left);
        }
        if (temp->right == NULL)
        {
            temp->right = new Node(val);
            return root;
        }
        else
        {
            q.push(temp->right);
        }
    }
    return root;
}
void preorder(Node *root)
{
    if (root == NULL)
    {
        return;
    }
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}
int sumOfNodes(Node *root)
{
    if (root == NULL)
    {
        return 0;
    }
    return root->data + sumOfNodes(root->left) + sumOfNodes(root->right);
}
int main()
{
    int n;
    cout << "Enter number of nodes: ";
    cin >> n;
    Node *root = NULL;
    for (int i = 0; i < n; i++)
    {
        int val;
        cin >> val;
        root = insertTree(root, val);
    }
    cout << "Inorder Traversal: ";
    inorder(root);
    cout << endl;
    cout << "Preorder Traversal: ";
    preorder(root);
    cout << endl;
    cout << "Sum of all nodes is: " << sumOfNodes(root);
}