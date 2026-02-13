/**
 * @filename: Task3.cpp
 * @description: The Distant Cousins
 * @author:Ayushi Shukla
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left, *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode *buildTree(vector<int> &arr)
{
    if (arr.empty() || arr[0] == -1)
        return NULL;

    TreeNode *root = new TreeNode(arr[0]);
    queue<TreeNode *> q;
    q.push(root);
    int i = 1;

    while (!q.empty() && i < arr.size())
    {
        TreeNode *node = q.front();
        q.pop();

        if (arr[i] != -1)
        {
            node->left = new TreeNode(arr[i]);
            q.push(node->left);
        }
        i++;

        if (i < arr.size() && arr[i] != -1)
        {
            node->right = new TreeNode(arr[i]);
            q.push(node->right);
        }
        i++;
    }
    return root;
}

vector<int> findCousins(TreeNode *root, int X)
{
    if (!root || root->val == X)
        return {};

    queue<pair<TreeNode *, TreeNode *>> q;

    q.push({root, NULL});

    while (!q.empty())
    {
        int size = q.size();
        vector<pair<TreeNode *, TreeNode *>> level;
        TreeNode *parentX = NULL;

        while (size--)
        {
            TreeNode *node = q.front().first;
            TreeNode *parent = q.front().second;
            q.pop();

            if (node->val == X)
                parentX = parent;

            level.push_back({node, parent});

            if (node->left)
                q.push({node->left, node});
            if (node->right)
                q.push({node->right, node});
        }

        if (parentX)
        {
            vector<int> cousins;
            for (auto &p : level)
            {
                TreeNode *node = p.first;
                TreeNode *par = p.second;
                if (node->val != X && par != parentX)
                {
                    cousins.push_back(node->val);
                }
            }
            return cousins;
        }
    }
    return {};
}

int main()
{
    int n, x;
    cout << "Enter number of elements in level order: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter tree elements (-1 for NULL): ";
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    cout << "Enter x: ";
    cin >> x;

    TreeNode *root = buildTree(arr);
    vector<int> ans = findCousins(root, x);

    cout << "Cousins: [ ";
    for (int v : ans)
        cout << v << " ";
    cout << "]";
    return 0;
}