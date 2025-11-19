/**
 * @filename - Task-3.cpp
 * @description - The 2D Linked List Transpose
 * @autor - Ayushi Shukla
 */

#include <iostream>
#include <vector>
using namespace std;

struct Node
{
    int value;
    Node *right;
    Node *down;

    Node(int data) : value(data), right(nullptr), down(nullptr) {}
};

// Function to build the 2D linked list from a matrix
Node *build2DList(const vector<vector<int>> &matrix)
{

    int totalRows = matrix.size();
    int totalColumns = matrix[0].size();

    vector<vector<Node *>> nodeGrid(totalRows, vector<Node *>(totalColumns, nullptr));

    // Create nodes
    for (int rowIndex = 0; rowIndex < totalRows; ++rowIndex)
    {
        for (int columnIndex = 0; columnIndex < totalColumns; ++columnIndex)
        {
            nodeGrid[rowIndex][columnIndex] = new Node(matrix[rowIndex][columnIndex]);
        }
    }

    // Link nodes
    for (int rowIndex = 0; rowIndex < totalRows; ++rowIndex)
    {
        for (int columnIndex = 0; columnIndex < totalColumns; ++columnIndex)
        {

            // Link right and down pointers
            if (columnIndex + 1 < totalColumns)
                nodeGrid[rowIndex][columnIndex]->right =
                    nodeGrid[rowIndex][columnIndex + 1];

            // Link down pointer
            if (rowIndex + 1 < totalRows)
                nodeGrid[rowIndex][columnIndex]->down =
                    nodeGrid[rowIndex + 1][columnIndex];
        }
    }

    return nodeGrid[0][0];
}

void print2D(Node *headNode)
{

    for (Node *rowPointer = headNode; rowPointer != nullptr; rowPointer = rowPointer->down)
    {

        for (Node *columnPointer = rowPointer; columnPointer != nullptr; columnPointer = columnPointer->right)
        {
            cout << columnPointer->value;
            if (columnPointer->right)
                cout << " ";
        }

        cout << "\n";
    }
}

// Function to transpose the 2D linked list
void transpose(Node *headNode)
{

    for (Node *rowPointer = headNode; rowPointer != nullptr; rowPointer = rowPointer->down)
    {

        for (Node *columnPointer = rowPointer; columnPointer != nullptr; columnPointer = columnPointer->right)
        {
            swap(columnPointer->right, columnPointer->down);
        }
    }
}

int main()
{

    int totalRows, totalColumns;

    cout << "Enter number of rows: ";
    cin >> totalRows;

    cout << "Enter number of columns: ";
    cin >> totalColumns;

    vector<vector<int>> matrix(totalRows, vector<int>(totalColumns));

    cout << "Enter matrix values:\n";
    for (int rowIndex = 0; rowIndex < totalRows; ++rowIndex)
        for (int columnIndex = 0; columnIndex < totalColumns; ++columnIndex)
            cin >> matrix[rowIndex][columnIndex];

    Node *headNode = build2DList(matrix);

    cout << "\nOriginal 2D Linked List:\n";
    print2D(headNode);

    Node *newHead = headNode;
    transpose(headNode);

    cout << "\nAfter Transpose:\n";
    print2D(newHead);

    return 0;
}
