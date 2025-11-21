/**
 * @filename - story3.cpp
 * @description - The 2D Linked List Transpose
 * @author - Fatimi Bee 
 */
#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int val;
    Node* right;
    Node* down;
    Node(int v) : val(v), right(nullptr), down(nullptr) {}
};

Node* build2DList(const vector<vector<int>>& mat) {
    int r = mat.size(), c = mat[0].size();
    vector<vector<Node*>> nodes(r, vector<Node*>(c, nullptr));
    for (int i = 0; i < r; ++i)
        for (int j = 0; j < c; ++j)
            nodes[i][j] = new Node(mat[i][j]);
    for (int i = 0; i < r; ++i)
        for (int j = 0; j < c; ++j) {
            if (j + 1 < c) nodes[i][j]->right = nodes[i][j + 1];
            if (i + 1 < r) nodes[i][j]->down  = nodes[i + 1][j];
        }
    return nodes[0][0];
}

void print2D(Node* head) {
    for (Node* row = head; row != nullptr; row = row->down) {
        for (Node* cur = row; cur != nullptr; cur = cur->right) {
            cout << cur->val;
            if (cur->right) cout << " ";
        }
        cout << "\n";
    }
}

void transpose(Node* head) {
    for (Node* row = head; row != nullptr; row = row->down) {
        for (Node* cur = row; cur != nullptr; cur = cur->right) {
            swap(cur->right, cur->down);
        }
    }
}

int main() {
    int rows, cols;
    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    vector<vector<int>> mat(rows, vector<int>(cols));
    cout << "Enter matrix values:\n";
    for (int i = 0; i < rows; ++i)
        for (int j = 0; j < cols; ++j)
            cin >> mat[i][j];

    Node* head = build2DList(mat);

    cout << "\nOriginal 2D Linked List:\n";
    print2D(head);
    Node* newHead = head;
    transpose(head);
    cout << "\nAfter Transpose:\n";
    print2D(newHead);

    return 0;
}
