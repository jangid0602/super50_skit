/**
 * @filename - Story3.cpp
 * @description -  The Digital Tree
 * @author - Fatimi Bee
 */

#include <iostream>

using namespace std;

// Tree represent the familt tree structure left and right represents the children nodes
class TreeNode
{
public:
    int data;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int value)
    {
        data = value;
        left = NULL;
        right = NULL;
    }
};

// Function to caluculate the legacy of family

int calculateLegacy(TreeNode *root)
{
    if (root == NULL)
    {
        return 0;
    }
    int leftLegacy = calculateLegacy(root->left);
    int rightLegacy = calculateLegacy(root->right);

    int totalLegacy = root->data + leftLegacy + rightLegacy;
    return totalLegacy;
}

void addFamilyMember(TreeNode *&root, TreeNode *member)
{
    if (root == NULL)
    {
        root = member;
        return;
    }

    if (root->left == NULL)
    {
        root->left = member;
        return;
    }

    if (root->right == NULL)
    {
        root->right = member;
        return;
    }

    addFamilyMember(root->left, member);
}

int main()
{
    int numberOfMembers;
    cout << "Enter number of family members: ";
    cin >> numberOfMembers;

    // Creating family tree
    TreeNode *root = NULL;
    for (int i = 0; i < numberOfMembers; i++)
    {
        int memberLegacy;
        cout << "Enter legacy of member " << i + 1 << ": ";
        cin >> memberLegacy;

        TreeNode *member = new TreeNode(memberLegacy);
        addFamilyMember(root, member);
    }

    int legacySum = 0;
    legacySum = calculateLegacy(root);
    cout << "Total legacy of family: " << legacySum << endl;
}