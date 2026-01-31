#include<iostream>
#include<string>
using namespace std;

int main(){
    string s ;
    cout<<"Enter thr string:";
    cin>>s;
    
    string orig = s;
    cout<<"The string is:"<<s<<endl;
    
    for(int i = 0;i<s.size();i++){
        if(s[i] == 'a'){
            s[i] = 'e';
        }
        else if(s[i] == 'e'){
            s[i] = 'i';
        }else if(s[i] == 'i'){
            s[i] = 'o';
        }else if(s[i] == 'o'){
            s[i] = 'u';
        }else if(s[i] == 'u'){
            s[i] = 'a';
        }
    }
    
    int i = 0, j = s.size() - 1;
    while(i < j){
        if(s[i] != s[j]){
            cout << "false , not palindrome";
            return 0;
        }
        i++;
        j--;
    }

    cout << "True , it is palindrome";
   
    
    return 0;


}


