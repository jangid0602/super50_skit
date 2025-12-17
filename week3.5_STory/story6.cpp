/**
 * @filename - Story6.cpp
 * @description -  THE Weather Season Data Aggregator
 * @author - Fatimi Bee
 */

 #include<iostream>
 #include<vector>
 #include<stack>
 using namespace std;

 int main(){
    int days;
    cout<<"Enter number of days to record weather data: ";
    cin>>days;
    vector<string>weatherData(days);
    cin.ignore();
    for(int i=0;i<days;i++){
        cout<<"Enter temprature for day "<<i+1<<": ";
        getline(cin,weatherData[i]);
    }
    int newTemperatureRecords=0;
    stack<string>temperatureStack;
    for(const string & temperature : weatherData){
        if(temperatureStack.empty() || temperature > temperatureStack.top()){
            temperatureStack.push(temperature);
            newTemperatureRecords++;
        }
        }
        cout<<"Number of new temperature records: "<<newTemperatureRecords<<endl;
    }
 