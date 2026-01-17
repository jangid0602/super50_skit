/**
 * @filename - Story5.cpp
 * @description -  Binary Tree Serialization and desearlization
 * @author - Fatimi Bee
 */

 #include <iostream>
#include <queue>
#include <sstream>
using namespace std;

/* Binary Tree Node */
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int value) {
        val = value;
        left = NULL;
        right = NULL;
    }
};


TreeNode* createTreeFromUserInput() {
    int rootValue;
    cout << "Enter root value (-1 for NULL): ";
    cin >> rootValue;

    if (rootValue == -1) return NULL;

    TreeNode* rootNode = new TreeNode(rootValue);
    queue<TreeNode*> nodeQueue;
    nodeQueue.push(rootNode);

    while (!nodeQueue.empty()) {
        TreeNode* currentNode = nodeQueue.front();
        nodeQueue.pop();

        int leftValue, rightValue;

        cout << "Enter left child of " << currentNode->val << ": ";
        cin >> leftValue;
        if (leftValue != -1) {
            currentNode->left = new TreeNode(leftValue);
            nodeQueue.push(currentNode->left);
        }

        cout << "Enter right child of " << currentNode->val << ": ";
        cin >> rightValue;
        if (rightValue != -1) {
            currentNode->right = new TreeNode(rightValue);
            nodeQueue.push(currentNode->right);
        }
    }
    return rootNode;
}


class Code {
public:
    string serialize(TreeNode* rootNode) {
        if (!rootNode) return "";

        string serializedString = "";
        queue<TreeNode*> nodeQueue;
        nodeQueue.push(rootNode);

        while (!nodeQueue.empty()) {
            TreeNode* currentNode = nodeQueue.front();
            nodeQueue.pop();

            if (currentNode == NULL) {
                serializedString += "#,";
            } else {
                serializedString += to_string(currentNode->val) + ",";
                nodeQueue.push(currentNode->left);
                nodeQueue.push(currentNode->right);
            }
        }
        return serializedString;
    }

    TreeNode* deserialize(string serializedData) {
        if (serializedData.size() == 0) return NULL;

        stringstream stringStream(serializedData);
        string currentValue;

        getline(stringStream, currentValue, ',');
        TreeNode* rootNode = new TreeNode(stoi(currentValue));

        queue<TreeNode*> nodeQueue;
        nodeQueue.push(rootNode);

        while (!nodeQueue.empty()) {
            TreeNode* currentNode = nodeQueue.front();
            nodeQueue.pop();

            getline(stringStream, currentValue, ',');
            if (currentValue != "#") {
                currentNode->left = new TreeNode(stoi(currentValue));
                nodeQueue.push(currentNode->left);
            }

           
            getline(stringStream, currentValue, ',');
            if (currentValue != "#") {
                currentNode->right = new TreeNode(stoi(currentValue));
                nodeQueue.push(currentNode->right);
            }
        }
        return rootNode;
    }
};


void printLevelOrder(TreeNode* rootNode) {
    if (!rootNode) return;

    queue<TreeNode*> nodeQueue;
    nodeQueue.push(rootNode);

    while (!nodeQueue.empty()) {
        TreeNode* currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (currentNode) {
            cout << currentNode->val << " ";
            nodeQueue.push(currentNode->left);
            nodeQueue.push(currentNode->right);
        }
    }
}

int main() {
    
    TreeNode* rootNode = createTreeFromUserInput();

    // Step 2: Serialize
    Code codeObject;
    string serializedTree = codeObject.serialize(rootNode);
    cout << "\nSerialized Tree: " << serializedTree << endl;

   
    TreeNode* deserializedRoot = codeObject.deserialize(serializedTree);

    
    cout << "Level Order of Deserialized Tree: ";
    printLevelOrder(deserializedRoot);

    return 0;
}
