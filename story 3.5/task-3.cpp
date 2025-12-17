/**
 * @filename - Task-3.cpp
 * @description -  The Factory Floor Robot 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<string> assignLabels(const vector<int>& objectWeights) {
    vector<string> assignedLabels;

    for (int index = 0; index < objectWeights.size(); index++) {
        if (objectWeights[index] % 15 == 0) {
            assignedLabels.push_back("Hazardous");
        }
        else if (objectWeights[index] % 3 == 0) {
            assignedLabels.push_back("Heavy");
        }
        else if (objectWeights[index] % 5 == 0) {
            assignedLabels.push_back("Fragile");
        }
        else {
            assignedLabels.push_back(to_string(objectWeights[index]));
        }
    }
    return assignedLabels;
}

int main() {
    int numberOfWeights;
    cout << "Enter number of weights: ";
    cin >> numberOfWeights;

    vector<int> objectWeights(numberOfWeights);
    cout << "Enter weights:\n";
    for (int index = 0; index < numberOfWeights; index++) {
        cin >> objectWeights[index];
    }

    vector<string> labelResults = assignLabels(objectWeights);

    cout << "List of labels: ";
    for (const string& label : labelResults) {
        cout << label << " ";
    }

    return 0;
}
