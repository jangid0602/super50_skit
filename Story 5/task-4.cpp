/**
 * @filename - Task-4.cpp
 * @description - Minimum Camera Coverage (Greedy) 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode
{
    int value;
    TreeNode *leftChild;
    TreeNode *rightChild;

    TreeNode(int data)
    {
        value = data;
        leftChild = NULL;
        rightChild = NULL;
    }
};

TreeNode *buildTreeFromLevelOrder(const vector<int> &levelOrderValues)
{
    if (levelOrderValues.empty() || levelOrderValues[0] == -1)
        return NULL;

    TreeNode *rootNode = new TreeNode(levelOrderValues[0]);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;
    while (!nodeQueue.empty() && index < levelOrderValues.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (levelOrderValues[index] != -1)
        {
            currentNode->leftChild = new TreeNode(levelOrderValues[index]);
            nodeQueue.push(currentNode->leftChild);
        }
        index++;

        if (index < levelOrderValues.size() && levelOrderValues[index] != -1)
        {
            currentNode->rightChild = new TreeNode(levelOrderValues[index]);
            nodeQueue.push(currentNode->rightChild);
        }
        index++;
    }
    return rootNode;
}

int cameraCount = 0;

int placeCamerasUsingDFS(TreeNode *currentNode)
{
    if (!currentNode)
        return 2;

    int leftState = placeCamerasUsingDFS(currentNode->leftChild);
    int rightState = placeCamerasUsingDFS(currentNode->rightChild);

    if (leftState == 0 || rightState == 0)
    {
        cameraCount++;
        return 1;
    }

    if (leftState == 1 || rightState == 1)
        return 2;

    return 0;
}

int minimumCameraCover(TreeNode *rootNode)
{
    cameraCount = 0;
    if (placeCamerasUsingDFS(rootNode) == 0)
        cameraCount++;
    return cameraCount;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of elements in level order: ";
    cin >> numberOfNodes;

    vector<int> levelOrderValues(numberOfNodes);
    cout << "Enter elements (-1 for NULL): ";
    for (int i = 0; i < numberOfNodes; i++)
        cin >> levelOrderValues[i];

    TreeNode *rootNode = buildTreeFromLevelOrder(levelOrderValues);

    int result = minimumCameraCover(rootNode);
    cout << "Minimum cameras needed: " << result << endl;

    return 0;
}
