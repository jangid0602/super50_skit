/**
 * @filename   : Story3.cpp
 * @description: Transpose a 2D linked list by swapping right and down pointers.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* right;
    Node* down;

    Node(int value) {
        data = value;
        right = nullptr;
        down = nullptr;
    }
};

Node* build2DList(const vector<vector<int>>& matrix) {

    int rows = matrix.size();
    int cols = matrix[0].size();

    vector<vector<Node*>> nodeGrid(rows, vector<Node*>(cols));

    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            nodeGrid[i][j] = new Node(matrix[i][j]);
        }
    }

    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {

            if(j + 1 < cols)
                nodeGrid[i][j]->right = nodeGrid[i][j + 1];

            if(i + 1 < rows)
                nodeGrid[i][j]->down = nodeGrid[i + 1][j];
        }
    }

    return nodeGrid[0][0];
}

void print2D(Node* head) {

    Node* rowPtr = head;
    while(rowPtr != nullptr) {

        Node* colPtr = rowPtr;
        while(colPtr != nullptr) {
            cout << colPtr->data << " ";
            colPtr = colPtr->right;
        }
        cout << endl;
        rowPtr = rowPtr->down;
    }
}

Node* transpose(Node* head) {

    Node* currentRow = head;

    while(currentRow != nullptr) {

        Node* currentNode = currentRow;
        while(currentNode != nullptr) {
            swap(currentNode->right, currentNode->down);
            currentNode = currentNode->right;
        }

        currentRow = currentRow->right;
    }

    return head->down ? head->down : head;
}

int main() {

    int rows, cols;
    cout << "Enter number of rows: ";
    cin >> rows;

    cout << "Enter number of columns: ";
    cin >> cols;

    vector<vector<int>> matrix(rows, vector<int>(cols));

    cout << "Enter matrix values:\n";
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            cin >> matrix[i][j];
        }
    }

    Node* head = build2DList(matrix);

    cout << "\nOriginal 2D Linked List:\n";
    print2D(head);

    Node* newHead = transpose(head);

    cout << "\nAfter Transpose:\n";
    print2D(newHead);

    return 0;
}
