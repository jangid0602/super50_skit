/**
 * @filename   : RussianDoll.cpp
 * @description: Recursive search to find a key inside nested Russian dolls.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

const string KEY_FOUND_MESSAGE = "Key Found!";

class Doll
{
public:
    int size;
    bool hasKey;
    Doll *innerDoll;

    Doll(int s, bool key = false, Doll *inner = nullptr)
        : size(s), hasKey(key), innerDoll(inner) {}
};

void findKey(Doll *doll)
{
    if (!doll)
        return;
    if (doll->hasKey == true)
    {
        cout << KEY_FOUND_MESSAGE << endl;
        return;
    }
    findKey(doll->innerDoll);
}
int main()
{
    Doll *d1 = new Doll(1, true);
    Doll *d2 = new Doll(2, false, d1);
    Doll *d3 = new Doll(3, false, d2);
    Doll *d4 = new Doll(4, false, d3);
    Doll *d5 = new Doll(5, false, d4);

    findKey(d5);
    return 0;
}
