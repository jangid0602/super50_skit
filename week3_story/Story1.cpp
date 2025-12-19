/**
 * @filename   : Story1.cpp
 * @description: Implement a stack supporting push, pop, top, and O(1) average retrieval.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

class AverageStack {
private:
    long long sum;
    vector<int> averageStack;

public:
    AverageStack() {
        sum = 0;
    }

    void push(int val) {
        averageStack.push_back(val);
        sum += val;
    }

    int pop() {
        if (averageStack.empty()) {
            return -1;   // stack underflow
        }
        int removed = averageStack.back();
        averageStack.pop_back();
        sum -= removed;
        return removed;
    }

    int top() {
        if (averageStack.empty()) {
            return -1;
        }
        return averageStack.back();
    }

    double getAverage() {
        if (averageStack.empty()) {
            return 0.0;
        }
        return (double)sum/averageStack.size();
    }
};

int main() {
    
    return 0;
}
