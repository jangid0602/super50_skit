/**
 * @filename   : SecureVaultCode.cpp
 * @description: Generate all possible 3-digit vault codes using permutations.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
using namespace std;

void generateCodes(int index, vector<int>& digits) {
    // Base case: one permutation formed
    if (index == digits.size()) {
        for (int d : digits)
            cout << d;
        cout << endl;
        return;
    }

    for (int i = index; i < digits.size(); i++) {
        swap(digits[index], digits[i]);
        generateCodes(index + 1, digits);
        swap(digits[index], digits[i]); 
    }
}

int main() {
    vector<int> digits = {1, 2, 3};

    generateCodes(0, digits);

    return 0;
}
