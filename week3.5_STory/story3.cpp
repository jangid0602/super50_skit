/**
 * @filename - Story3.cpp
 * @description -  THE FACTORY FLOOR SYSTEM
 * @author - Fatimi Bee
 */

 #include<iostream>
 #include<vector>
 #include<algorithm>

 using namespace std;
string assignLabel(int weight){
    if(weight % 15 == 0) return "Hazardous";
    else if(weight % 3 == 0) return "Heavy";
    else if(weight % 5 == 0) return "Fragile";
    
    return to_string(weight);

}
 int main(){
    cout<<"Enter total number of items : ";
    int items;
    cin>>items;

    vector<int>itemweights(items,0);
    for(int i=0;i<items;i++){
        cout<<"Enter weight of item "<<i+1<<": ";
        cin>>itemweights[i];
    }
    
    vector<string>itemLabels;
    for(int i=0;i<items;i++){
        itemLabels.push_back(assignLabel(itemweights[i]));
    }


    cout<<"\n Factory Floor Item Label \n";
    for(int i=0;i<items;i++){
        cout<<"Item " <<i+1<<" : "<<itemLabels[i]<<endl;
    }

 }