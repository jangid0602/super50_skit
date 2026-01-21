#include<bits/stdc++.h>
using namespace std;

int floorIsLava(vector<int> &heights, int k){


    int i=0;
    int j=1;
    int maxi=0;
    int ans=1;
    while(j<heights.size()){
        
        if(heights[j]-heights[j-1] <=k){
            j++;
            ans++;
            maxi=max(maxi,ans);
        }else{
            i=j;
            j++;
            ans=0;
        }
    }

    return maxi;
}
vector<string> missingPages(vector<int> &inputArray, int size){
    if(size==0){
        return {0};
    }
    
    sort(inputArray.begin(), inputArray.end());

    vector<int> pages(size+1, -1);
    for(int i=0;i<inputArray.size();i++){
        int index=inputArray[i];
        pages[index]=1;
    }

    
    vector<string> result;

    int j=0;
    while(j<pages.size()){
        string tempAns="";
        
        if(pages[j]!=-1){
            j++;
            continue;
        }

        while(pages[j]==-1){
            tempAns.push_back(j++);
        }

        if(tempAns.size()>1){
           result.push_back(tempAns[0]+"-"+tempAns[tempAns.length()-1]);
        }
        else{
            result.push_back(tempAns);
        }

    }

    return result;
}

bool isCapital(char inputCh){
     if(inputCh>='A' && inputCh<='Z' ){
        return true;
    }
    return false;
}

bool isSmall(char inputCh){
    if(inputCh>='a' && inputCh<='z' ){
        return true;
    }
    return false;
}

char toCapital(char &inputCh){

    if(inputCh>='a' && inputCh<='z' ){
        inputCh=inputCh-'a'+'A'; 
    }
    return inputCh;
    
   
}

char toSmall(char &inputCh){
    if(inputCh>='A' && inputCh<='Z' ){
        inputCh=inputCh-'A'+'a';
       
    }

    return inputCh;
    
   
}

string oxygenTankScrubber(string input){
    string output="";

    if(input.empty()){
        return output;
    }


    stack<char> scrubber;


    for(int index=0;index<input.length();index++){
        char inputCh=input[index];

        if(scrubber.empty()){
            scrubber.push(inputCh);
            continue;
        }

        char topElement=scrubber.top();

       
        if((isCapital(topElement) && isCapital(inputCh)) ||
        (isSmall(topElement) && isSmall(inputCh))){
            scrubber.push(inputCh);
        }
        else{

            if(topElement==toCapital(inputCh) || topElement==toSmall(inputCh)){
                scrubber.pop();
            }
            
        }

    }

    
    while(!scrubber.empty()){
        output+=scrubber.top();
        scrubber.pop();
    }

    reverse(output.begin(), output.end());

    return output;
    


}
int main(){
    
    int size=0;
    cout<<"enter input array size N"<<endl;
    cin>>size;
    vector<int> inputArray(size,0);
   
    
    int foundPage=0;
    cout<<"enter no of found pages"<<endl;
    cin>>foundPage;

    for(int i=0;i<foundPage;i++){
        cin>>inputArray[i];
    }

    vector<string> ans=missingPages(inputArray,size);

    for(int i=0;i<ans.size();i++){
        cout<<ans[i];
    }


    vector<int> heights={1,2,5,8};
    cout<<floorIsLava(heights,3);


     string input="";
    cout<<"Enter input string"<<endl;
    cin>>input;
    
    string result=oxygenTankScrubber(input);
    cout<<result;

    return 0;
}
