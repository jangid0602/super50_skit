/**
 * @filename    - Story2.cpp
 * @description - Vertical Silhouette of a Binary Tree
 * @author      - Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

Node *buildTreeLevelOrder(int totalNodes)
{
    if (totalNodes <= 0)
        return nullptr;

    int rootData;
    cin >> rootData;

    if (rootData == -1)
        return nullptr;

    Node *root = new Node(rootData);
    queue<Node *> q;
    q.push(root);

    int count = 1;

    while (!q.empty() && count < totalNodes)
    {
        Node *current = q.front();
        q.pop();

        int leftVal, rightVal;

        cin >> leftVal;
        count++;
        if (leftVal != -1)
        {
            current->left = new Node(leftVal);
            q.push(current->left);
        }

        if (count >= totalNodes)
            break;

        cin >> rightVal;
        count++;
        if (rightVal != -1)
        {
            current->right = new Node(rightVal);
            q.push(current->right);
        }
    }

    return root;
}

vector<vector<int>> getVerticalSilhouette(Node *root)
{
    vector<vector<int>> output;
    if (!root)
        return output;

    queue<pair<Node *, int>> q;
    q.push({root, 0});

    vector<vector<int>> bucket(2000);
    int minHD = 0, maxHD = 0;

    while (!q.empty())
    {
        auto front = q.front();
        q.pop();

        Node *curr = front.first;
        int hd = front.second;

        bucket[hd + 1000].push_back(curr->data);

        minHD = min(minHD, hd);
        maxHD = max(maxHD, hd);

        if (curr->left)
            q.push({curr->left, hd - 1});
        if (curr->right)
            q.push({curr->right, hd + 1});
    }

    for (int i = minHD; i <= maxHD; i++)
        output.push_back(bucket[i + 1000]);

    return output;
}

int main()
{
    int nodeCount;
    cout << "Enter number of nodes: ";
    cin >> nodeCount;

    if (nodeCount == 0)
    {
        cout << "Tree is empty\n";
        return 0;
    }

    cout << "Enter values (level order, -1 for NULL):\n";
    Node *root = buildTreeLevelOrder(nodeCount);

    vector<vector<int>> silhouette = getVerticalSilhouette(root);

    cout << "\nVertical Silhouette:\n";
    for (auto &col : silhouette)
    {
        cout << "[ ";
        for (int val : col)
            cout << val << " ";
        cout << "] ";
    }

    return 0;
}
