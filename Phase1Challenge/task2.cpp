/**
 * @filename - task2.cpp
 * @description - Missing page number
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
void findMissingPages(vector<int> pages, int totalPages, vector<string> &missingPages)
{
    sort(pages.begin(), pages.end());

    int firstMissingpage = pages[0] - 1;
    if (firstMissingpage == 1)
        missingPages.push_back("1");
    else if (firstMissingpage != 0)
        missingPages.push_back("1-" + to_string(firstMissingpage));

    for (int i = 1; i < pages.size(); i++)
    {

        int previousPageMissing = pages[i - 1] + 1;
        if (previousPageMissing == pages[i])
            continue;

        int currentPageMissing = pages[i] - 1;
        if (currentPageMissing == previousPageMissing)
            missingPages.push_back(to_string(currentPageMissing));
        else
            missingPages.push_back(to_string(previousPageMissing) + "-" + to_string(currentPageMissing));
    }

    int lastMissingPage = totalPages - pages[pages.size() - 1];
    if (lastMissingPage == 1)
        missingPages.push_back(to_string(totalPages));
    else if (lastMissingPage > 1)
        missingPages.push_back(to_string(pages[pages.size() - 1] + 1) + "-" + to_string(totalPages));
}
int main()
{
    int totalPages;
    cout << "Enter total Pages : ";
    cin >> totalPages;
    cout << "Enter number of pages yu have " << endl;
    int size;
    cin >> size;
    vector<int> pages(size);
    for (int i = 0; i < size; i++)
    {
        cout << "Enter exist page : ";
        cin >> pages[i];
    }
    vector<string> missingPages;

    findMissingPages(pages, totalPages, missingPages);
    for (auto it : missingPages)
        cout << it << " ";
    cout << endl;
}