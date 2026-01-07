/**
 * @filename   : FactoryFloorRobot.cpp
 * @description: Assign labels to item weights based on divisibility rules using loops and conditionals.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

vector<string> labelWeights(vector<int>& weights) {
    vector<string> labels;

    for (int weight : weights) {
        if (weight % 15 == 0) {
            labels.push_back("Hazardous");
        }
        else if (weight % 3 == 0) {
            labels.push_back("Heavy");
        }
        else if (weight % 5 == 0) {
            labels.push_back("Fragile");
        }
        else {
            labels.push_back(to_string(weight));
        }
    }

    return labels;
}

int main() {
    int numberOfItems;
    cin >> numberOfItems;

    vector<int> weights(numberOfItems);
    for (int i = 0; i < numberOfItems; i++) {
        cin >> weights[i];
    }

    vector<string> labels = labelWeights(weights);

    for (const string& label : labels) {
        cout << label << " ";
    }
    cout << endl;

    return 0;
}
