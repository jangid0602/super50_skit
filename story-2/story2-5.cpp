#include<bits/stdc++.h>
using namespace std;
int main(){
	int n;
	cout<<"Enter size of array :";
	cin>>n;
	vector<int>arr(n);
	cout<<"Enter elements of array (either 1 2 or 0):";
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
	unordered_map<int,int>first;
	first[0]=-1;
	int sum=0;
	int maxlen=0;
	for(int i=0;i<n;i++){
		if(arr[i]==1){
			sum+=1;
		}
		else if(arr[i]==2){
			sum-=1;
		}
		if(first.find(sum)!=first.end()){
			maxlen=max(maxlen,i-first[sum]);
		}
		else{
			first[sum]=i;
		}
	}
	cout<<"length of the longest contiguous subarray is:"<<maxlen<<endl;
	return 0;
}