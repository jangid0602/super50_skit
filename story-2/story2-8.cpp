#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>
using namespace std;

string validateAndNormalizeSKU(string inputSKU) {
    inputSKU.erase(remove(inputSKU.begin(), inputSKU.end(), ' '), inputSKU.end());
    transform(inputSKU.begin(), inputSKU.end(), inputSKU.begin(), ::toupper);

    int firstDashPosition = inputSKU.find('-');
    int secondDashPosition = inputSKU.find('-', firstDashPosition + 1);

    if (firstDashPosition == string::npos || secondDashPosition == string::npos)
        return "INVALID";

    string categoryCode = inputSKU.substr(0, firstDashPosition);
    string productId = inputSKU.substr(firstDashPosition + 1, secondDashPosition - firstDashPosition - 1);
    string sizeCode = inputSKU.substr(secondDashPosition + 1);

    if (categoryCode.size() < 3 || categoryCode.size() > 4)
        return "INVALID";
    for (char ch : categoryCode)
        if (!isalpha(ch))
            return "INVALID";

    if (productId.size() < 4 || productId.size() > 6)
        return "INVALID";
    for (char ch : productId)
        if (!isdigit(ch))
            return "INVALID";

    if (!(sizeCode == "S" || sizeCode == "M" || sizeCode == "L" || sizeCode == "XL"))
        return "INVALID";

    return categoryCode + "-" + productId + "-" + sizeCode;
}

int main() {
    string inputSKU;
    cout << "Enter SKU: ";
    getline(cin, inputSKU);

    string normalizedSKU = validateAndNormalizeSKU(inputSKU);
    cout << "Normalized SKU: " << normalizedSKU << endl;

    return 0;
}
