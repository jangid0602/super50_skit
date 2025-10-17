#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
#include <conio.h>  // for _getch() - Windows only

using namespace std;

#define SIZE 4

int board[SIZE][SIZE];
int score = 0;

// Function to print the board
void printBoard() {
    system("cls");  // clear screen
    cout << "\n\t2048 Game in C++\n";
    cout << "\t----------------\n";
    cout << "\tScore: " << score << "\n\n";

    for (int i = 0; i < SIZE; i++) {
        cout << "\t";
        for (int j = 0; j < SIZE; j++) {
            if (board[i][j] == 0)
                cout << setw(6) << ".";
            else
                cout << setw(6) << board[i][j];
        }
        cout << "\n\n";
    }
}

// Function to generate a new tile (2 or 4)
void addNewTile() {
    int x, y;
    do {
        x = rand() % SIZE;
        y = rand() % SIZE;
    } while (board[x][y] != 0);

    board[x][y] = (rand() % 10 < 9) ? 2 : 4;  // 90% chance of 2, 10% chance of 4
}

// Check if there are any moves left
bool movesAvailable() {
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            if (board[i][j] == 0)
                return true;

    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE - 1; j++)
            if (board[i][j] == board[i][j + 1] || board[j][i] == board[j + 1][i])
                return true;

    return false;
}

// Compress tiles to the left
bool compress() {
    bool moved = false;
    for (int i = 0; i < SIZE; i++) {
        int pos = 0;
        int newRow[SIZE] = {0};
        for (int j = 0; j < SIZE; j++) {
            if (board[i][j] != 0) {
                newRow[pos] = board[i][j];
                if (j != pos) moved = true;
                pos++;
            }
        }
        for (int j = 0; j < SIZE; j++)
            board[i][j] = newRow[j];
    }
    return moved;
}

// Merge equal tiles
bool merge() {
    bool merged = false;
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE - 1; j++) {
            if (board[i][j] != 0 && board[i][j] == board[i][j + 1]) {
                board[i][j] *= 2;
                score += board[i][j];
                board[i][j + 1] = 0;
                merged = true;
            }
        }
    }
    return merged;
}

// Reverse each row (used for RIGHT move)
void reverse() {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE / 2; j++) {
            swap(board[i][j], board[i][SIZE - j - 1]);
        }
    }
}

// Transpose matrix (used for UP/DOWN moves)
void transpose() {
    for (int i = 0; i < SIZE; i++) {
        for (int j = i + 1; j < SIZE; j++) {
            swap(board[i][j], board[j][i]);
        }
    }
}

// Move Left
bool moveLeft() {
    bool c1 = compress();
    bool m1 = merge();
    bool c2 = compress();
    return c1 || m1 || c2;
}

// Move Right
bool moveRight() {
    reverse();
    bool moved = moveLeft();
    reverse();
    return moved;
}

// Move Up
bool moveUp() {
    transpose();
    bool moved = moveLeft();
    transpose();
    return moved;
}

// Move Down
bool moveDown() {
    transpose();
    bool moved = moveRight();
    transpose();
    return moved;
}

// Check if 2048 tile reached
bool checkWin() {
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            if (board[i][j] == 2048)
                return true;
    return false;
}

int main() {
    srand(time(0));
    addNewTile();
    addNewTile();

    while (true) {
        printBoard();

        if (checkWin()) {
            cout << "\n🎉 Congratulations! You made 2048!\n";
            break;
        }

        if (!movesAvailable()) {
            cout << "\n😢 Game Over! No more moves possible.\n";
            break;
        }

        cout << "Move (W/A/S/D): ";
        char move;
        cin >> move;

        switch (toupper(move)) {
            case 'W': move = moveUp(); break;
            case 'A': move = moveLeft(); break;
            case 'S': move = moveDown(); break;
            case 'D': move = moveRight(); break;
            case 'Q': cout << "\nExiting game...\n"; return 0;
            default: continue;
        }

        if (move) addNewTile();
    }

    return 0;
}
