/**
 * @filename - task8.cpp
 * @description - Jaipur tech Hub Route
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

long long memoDP[20][200][2];
vector<int> digitList;
bool primeCheck[200];

void sieve()
{
    for (int i = 0; i < 200; i++)
        primeCheck[i] = true;

    primeCheck[0] = false;
    primeCheck[1] = false;

    for (int i = 2; i * i < 200; i++)
    {
        if (primeCheck[i])
        {
            for (int j = i * i; j < 200; j += i)
                primeCheck[j] = false;
        }
    }
}

long long digitDP(int position, int digitSum, int isTight)
{
    if (position == digitList.size())
    {
        return primeCheck[digitSum] ? 1 : 0;
    }

    if (memoDP[position][digitSum][isTight] != -1)
        return memoDP[position][digitSum][isTight];

    long long totalCount = 0;
    int digitLimit = isTight ? digitList[position] : 9;

    for (int currentDigit = 0; currentDigit <= digitLimit; currentDigit++)
    {
        totalCount += digitDP(position + 1, digitSum + currentDigit,
                              (isTight && currentDigit == digitLimit));
    }

    return memoDP[position][digitSum][isTight] = totalCount;
}

long long countNumbersWithPrimeDigitSum(long long number)
{
    if (number < 0)
        return 0;

    digitList.clear();

    while (number > 0)
    {
        digitList.push_back(number % 10);
        number /= 10;
    }

    reverse(digitList.begin(), digitList.end());

    memset(memoDP, -1, sizeof(memoDP));
    return digitDP(0, 0, 1);
}

int main()
{
    sieve();

    long long lowerBound, upperBound;
    cout << "Enter L: ";
    cin >> lowerBound;
    cout << "Enter R: ";
    cin >> upperBound;

    long long result =
        countNumbersWithPrimeDigitSum(upperBound) -
        countNumbersWithPrimeDigitSum(lowerBound - 1);

    cout << "Count = " << result << endl;

    return 0;
}