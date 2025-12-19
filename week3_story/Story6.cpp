/**
 * @filename   : Story6.cpp
 * @description: Implement a Leaky Bucket queue with fixed capacity.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <queue>
using namespace std;

class LeakyBucket {
private:
    int capacity;
    queue<string> buffer;

public:
    LeakyBucket(int capacity) {
        this->capacity=capacity;
        
    }

    void enqueue(string item) {
        if(buffer.size()==capacity){
            buffer.pop();
            
        }
        buffer.push(item);
        
    }

    vector<string> process(int k) {
        vector<string>processedRequests;
        while(!buffer.empty() && k>0){
            string request=buffer.front();
            processedRequests.push_back(request) ;
            buffer.pop();
            k-=1;
        }

        return processedRequests;
    }
};

int main() {
    
    return 0;
}
