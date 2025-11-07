/**
 * @filename - story9.cpp
 * @description - Message Redaction
 * @author - Fatimi Bee 
 */


#include <iostream>
#include <vector>
#include <string>
using namespace std;

string redactMessage(string message, vector<string> bannedWords) {
    // Iterate through all banned words
    for (string banned : bannedWords) {
        int pos = 0;
        while ((pos = message.find(banned, pos)) != string::npos) {
            // Create a string of '*' with same length as banned word
            string stars(banned.size(), '*');
            // Replace banned word with stars
            message.replace(pos, banned.size(), stars);
            pos += stars.size();
        }
    }
    return message;
}

int main() {
    string message ;
    vector<string> banned1 ;

    cout<<"Enter the message :";
    getline(cin,message);
    int size;
    cout<<"Enter number of banneed words :";
    cin>>size;
    cout<<"Enter banned words: ";
    for(int i=0;i<size;i++){
        string word;
        cin>>word;
        banned1.push_back(word);

    }
    cout<<"Reducted Message : "<<redactMessage(message,banned1);
}
