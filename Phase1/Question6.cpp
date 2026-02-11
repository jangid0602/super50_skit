#include <iostream>
using namespace std;

class Node{
    public:
    int val;
    Node *next;
    Node()
    {
        val=0;
        next=NULL;
    }
    Node(int value)
    {
        val=value;
        next=NULL;
    }
};
class Solution{
    public:
    
    Node* root;
    Solution()
    {
        root=NULL;
    }

    void insert(int val)
    {
        Node* temp=new Node(val);
        if(root==NULL)
        {
            root=temp;
        }
        else {
            Node* curr=root;
            while(curr->next!=NULL)
            {
                curr=curr->next;
            }
            curr->next=temp;
        }
    }
    void nodeSwapbyValue(int val){
        if(root==NULL || root->next==NULL)
        {
            return ;
        }
        Node* temp=root;
        Node* prev1=NULL;
        while(temp!=NULL)
        {
            if(temp->val==val)
            break;
            prev1=temp;
            temp=temp->next;
        }
        if(temp==NULL)
        {
            cout<<"Value not found\n";
            return ;
        }
        else if(temp->next==NULL)
        {
            cout<<"No successor to swap with node\n";
            return ;
        }
        Node*temp2=temp->next;
        prev1->next=temp2;
        temp->next=temp2->next;
        temp2->next=temp;
        
    }
    void display(){
        Node*temp=root;
        while(temp!=NULL)
        {
            cout<<temp->val<<"  ";
            temp=temp->next;
        }
        cout<<endl;
    }
};

    int main(){
        Solution *solution = new Solution();
        int number_node;
        cout<<("Enter number of nodes to insert:");
        
        cin>>number_node;
        cout<<"Enter the values of nodes:";
        for(int i=0;i<number_node;i++)
        {
            int value;
            cin>>value;
            solution->insert(value);
        }
        cout<<"The list is:";
        solution->display();
        int value_to_swap;
        cout<<"Enter the value of node to swap with next node:";
        cin>>value_to_swap;
        solution->nodeSwapbyValue(value_to_swap);
        cout<<"The list after swapping is:";
        solution->display();
        return 0;
    }
