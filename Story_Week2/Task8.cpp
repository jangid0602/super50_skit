// @filename-Task8.cpp
// @Description: Validates and normalizes SKUs in the format CATEGORY-ID-SIZE
// @Author: Ayushi Shukla

#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>
using namespace std;

class SKUNormalizer
{
public:
    string normalizeSKU(const string &rawSKU)
    {
        string sku = rawSKU;
        // Remove spaces
        sku.erase(remove(sku.begin(), sku.end(), ' '), sku.end());
        // Convert to uppercase
        transform(sku.begin(), sku.end(), sku.begin(), ::toupper);

        int firstDash = sku.find('-');
        int secondDash = sku.find('-', firstDash + 1);

        if (firstDash == string::npos || secondDash == string::npos)
            return "INVALID";

        string category = sku.substr(0, firstDash);
        string productId = sku.substr(firstDash + 1, secondDash - firstDash - 1);
        string sizeCode = sku.substr(secondDash + 1);

        // Validate category: 3-4 letters
        if (category.size() < 3 || category.size() > 4)
            return "INVALID";
        for (char ch : category)
            if (!isalpha(ch))
                return "INVALID";

        // Validate product ID: 4-6 digits
        if (productId.size() < 4 || productId.size() > 6)
            return "INVALID";
        for (char ch : productId)
            if (!isdigit(ch))
                return "INVALID";

        // Validate size code
        if (!(sizeCode == "S" || sizeCode == "M" || sizeCode == "L" || sizeCode == "XL"))
            return "INVALID";

        return category + "-" + productId + "-" + sizeCode;
    }
};

int main()
{
    string rawSKU;
    cout << "Enter SKU: ";
    getline(cin, rawSKU);

    SKUNormalizer normalizer;
    string normalizedSKU = normalizer.normalizeSKU(rawSKU);

    cout << "Normalized SKU: " << normalizedSKU << endl;

    return 0;
}
