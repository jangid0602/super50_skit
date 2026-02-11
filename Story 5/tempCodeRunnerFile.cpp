#include<iostream>
using namespace std;
struct Node{
    int data;
    int left;
    int right;
    Node(int val){
       data=val;
       left=NULL;
       right=NULL;
    }
}
void insert(Node* root,char val,char direction){
if(direction=='L' || direction=='l'){
    if(!root->left){
        root->left=new Node(val);
    }
    else{
        insert(root->left,val,direction);
    }
   }

else if(direction=='R' || direction=='r'){
   if(!root->right){
        root->right=new Node(val);
    }
    else{
        insert(root->right,val,direction);
    }
   }
else{
    cout<<"Invalid Input";
}
}

int main(){
   int rootval;
   cout<<"Enter root value";
   cin>>rootval;
   Node* root=new Node(rootval);
   char value;
   cout<<"enter character to add in a tree";
   cin>>value;
   char direction;
   cout<<"Enter direction";
   cin>>direction;
   insert(root,value,direction);
   
}