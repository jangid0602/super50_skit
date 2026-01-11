/**
 * @filename - Task10.cpp
 * @description - The Project Builder's Blueprint (Logic & State) 
 * @author - Disha Toshniwal 
 */
#include <bits/stdc++.h>
using namespace std;

void printTasks(vector<string>& tasks, int index, int level) {
    if (index == tasks.size()) return;

    for (int i = 0; i < level; i++) cout << "  ";
    cout << tasks[index] << endl;

    printTasks(tasks, index + 1, level + 1);
}

int main() {
    string input;
    cout << "Enter task chain (Task: X -> Sub: Y -> Sub: Z): ";
    getline(cin, input);

    vector<string> parts;
    size_t pos = 0;
    string delimiter = " -> ";

    while ((pos = input.find(delimiter)) != string::npos) {
        parts.push_back(input.substr(0, pos));
        input.erase(0, pos + delimiter.length());
    }
    parts.push_back(input); 

    vector<string> tasks;
    for (string &p : parts) {
        size_t colon = p.find(':');
        if (colon != string::npos) {
            tasks.push_back(p.substr(colon + 2)); 
        }
    }

    printTasks(tasks, 0, 0);
    return 0;
}
