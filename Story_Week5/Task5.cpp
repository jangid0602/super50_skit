/**
 * @filename:    Task5.cpp
 * @description: Serializer and Deserializer
 * @author:     Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

struct TreeNode
{
    int value;
    TreeNode *leftChild;
    TreeNode *rightChild;

    TreeNode(int data)
    {
        value = data;
        leftChild = nullptr;
        rightChild = nullptr;
    }
};

TreeNode *buildTreeFromLevelOrder(const vector<int> &levelOrder)
{
    if (levelOrder.empty() || levelOrder[0] == -1)
        return nullptr;

    TreeNode *rootNode = new TreeNode(levelOrder[0]);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;
    while (!nodeQueue.empty() && index < levelOrder.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (levelOrder[index] != -1)
        {
            currentNode->leftChild = new TreeNode(levelOrder[index]);
            nodeQueue.push(currentNode->leftChild);
        }
        index++;

        if (index < levelOrder.size() && levelOrder[index] != -1)
        {
            currentNode->rightChild = new TreeNode(levelOrder[index]);
            nodeQueue.push(currentNode->rightChild);
        }
        index++;
    }
    return rootNode;
}

// Serialize tree using level order traversal
string serializeTree(TreeNode *rootNode)
{
    if (!rootNode)
        return "null";

    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);
    string serializedData = "";

    while (!nodeQueue.empty())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (currentNode)
        {
            serializedData += to_string(currentNode->value) + ",";
            nodeQueue.push(currentNode->leftChild);
            nodeQueue.push(currentNode->rightChild);
        }
        else
        {
            serializedData += "null,";
        }
    }
    return serializedData;
}

// Deserialize string back to tree
TreeNode *deserializeTree(const string &serializedData)
{
    if (serializedData == "null")
        return nullptr;

    vector<string> nodes;
    string temp = "";

    for (char ch : serializedData)
    {
        if (ch == ',')
        {
            nodes.push_back(temp);
            temp.clear();
        }
        else
        {
            temp += ch;
        }
    }

    TreeNode *rootNode = new TreeNode(stoi(nodes[0]));
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;
    while (!nodeQueue.empty() && index < nodes.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (nodes[index] != "null")
        {
            currentNode->leftChild = new TreeNode(stoi(nodes[index]));
            nodeQueue.push(currentNode->leftChild);
        }
        index++;

        if (index < nodes.size() && nodes[index] != "null")
        {
            currentNode->rightChild = new TreeNode(stoi(nodes[index]));
            nodeQueue.push(currentNode->rightChild);
        }
        index++;
    }
    return rootNode;
}

// Print tree in level order
void printTreeLevelOrder(TreeNode *rootNode)
{
    if (!rootNode)
    {
        cout << "null";
        return;
    }

    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    while (!nodeQueue.empty())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (currentNode)
        {
            cout << currentNode->value << " ";
            nodeQueue.push(currentNode->leftChild);
            nodeQueue.push(currentNode->rightChild);
        }
        else
        {
            cout << "null ";
        }
    }
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of elements: ";
    cin >> numberOfNodes;

    vector<int> levelOrder(numberOfNodes);
    cout << "Enter level order values (-1 for null): ";
    for (int i = 0; i < numberOfNodes; i++)
    {
        cin >> levelOrder[i];
    }

    TreeNode *originalRoot = buildTreeFromLevelOrder(levelOrder);

    string serializedTree = serializeTree(originalRoot);
    cout << "Serialized Tree:\n"
         << serializedTree << endl;

    TreeNode *deserializedRoot = deserializeTree(serializedTree);
    cout << "Deserialized Tree (Level Order):\n";
    printTreeLevelOrder(deserializedRoot);

    return 0;
}
