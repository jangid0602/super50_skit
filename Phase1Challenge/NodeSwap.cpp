#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node *next;
    node(){
}
   node(int x){
    data=x;
    next=nullptr;
   } 
};

int main(){
    node *a1=new node(1);
    a1->next=new node(2);
    a1->next->next=new node(3);
    a1->next->next->next=new node(4);
    
    int X=2;

    node *t1=a1;
    node *prev=nullptr;

    while(t1->next!=nullptr){
        if(t1->data==X){
            prev->next->next=prev->next;
            prev->next=t1->next;
        }
        prev=t1;
        t1=t1->next;
    }

    
 while(a1!=nullptr){
    cout<<a1->data<<" ";
    a1=a1->next;
} 

}