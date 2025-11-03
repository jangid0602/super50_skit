#include<bits/stdc++.h>
using namespace std;

class CustomMemory{
        static int total_memory;
        int size=0;
public:
      CustomMemory(int size)  {
       
                total_memory += size;
                this->size = size;
        }

        void freeMemory(){
                total_memory -= size;
                size = 0;
        }
        void allocateMemory(int size){
                total_memory += size;
                this->size += size;
        }
        void show(){
                cout<<"Total memory allocated: "<<total_memory<<endl;
        }
};

int main(){

    CustomMemory mem1(10);
    CustomMemory mem2(20);
    mem1.freeMemory();
    mem2.show();

return 0;
}