/**
 * @filename   : DigitalAncestry.cpp
 * @description: Calculate total legacy of a person using recursion.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
using namespace std;

// Input: A(100) -> Children: B(50), C(50)
// Output: 200

class Person
{
public:
    int wealth;
    vector<Person *> children;

    Person(int w) : wealth(w) {}
};

int calculateLegacy(Person *person)
{
    if (!person)
        return 0;

    int descendentsWealth = person->wealth;
    for (auto descendents : person->children)
    {
        descendentsWealth += calculateLegacy(descendents);
    }

    return descendentsWealth;
}

int main()
{
    Person *rootPerson = new Person(100);
    Person *childOne = new Person(50);
    Person *childTwo = new Person(50);

    rootPerson->children.push_back(childOne);
    rootPerson->children.push_back(childTwo);

    cout << calculateLegacy(rootPerson);
    return 0;
}
