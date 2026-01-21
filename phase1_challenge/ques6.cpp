#include<bits/stdc++.h>
using namespace std;

// Input: 1 -> 2 -> 3 -> 4, X = 2 → Output: 1 -> 3 -> 2 -> 4

class Node{
    public:
    int val;
    Node* next;

    Node(int val){
        this->val=val;
        // next=NULL;
    }

    

    
};


class Solution{
    public:

    void swapByValue(Node* head,int value){

        Node* temp=head;
        while(temp){
            if(temp->val==value && temp->next!=nullptr){

                swap(temp->val,temp->next->val);
                    // break;
                    temp=temp->next->next;
            }
            temp=temp->next;
        }
    }

    void display(Node* head){
        Node* temp=head;
        while(temp){
            cout<<temp->val;
            temp=temp->next;
        }
        cout<<endl;
    }
};

// 5 -> 6 -> 5 -> 7, X = 5
int main(){

    // vector<int>nums={1 ,2 , 3 , 4};
    vector<int>nums={5 ,6 , 5 , 7};
    Node* head=NULL;
    Node* temp=NULL;

    for(int i=0;i<nums.size();i++){
            if(!head){
                head= new Node(nums[i]);
                temp=head;
            }else{
                temp->next=new Node(nums[i]);
                temp=temp->next;
            }
    }

    Solution s1;
    s1.display(head);
    s1.swapByValue(head,4);
    s1.display(head);

    
}