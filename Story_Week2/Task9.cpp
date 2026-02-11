// @filename-Task9.cpp
// @Description: Moderates chat messages by replacing banned words with asterisks (*), case-insensitive
// @Author: Ayushi Shukla

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class ChatModerator
{
public:
    string censorMessage(const string &message, const vector<string> &bannedWords)
    {
        string censoredMessage = message;
        string lowerMessage = message;
        transform(lowerMessage.begin(), lowerMessage.end(), lowerMessage.begin(), ::tolower);

        for (const string &bannedWordOrig : bannedWords)
        {
            string bannedWord = bannedWordOrig;
            transform(bannedWord.begin(), bannedWord.end(), bannedWord.begin(), ::tolower);

            size_t pos = 0;
            while ((pos = lowerMessage.find(bannedWord, pos)) != string::npos)
            {
                for (size_t i = 0; i < bannedWord.size(); i++)
                {
                    censoredMessage[pos + i] = '*';
                }
                pos += bannedWord.size();
            }
        }

        return censoredMessage;
    }
};

int main()
{
    string inputMessage;
    cout << "Enter Message: ";
    getline(cin, inputMessage);

    int bannedWordCount;
    cout << "Enter number of banned words: ";
    cin >> bannedWordCount;
    cin.ignore();

    vector<string> bannedWords(bannedWordCount);
    cout << "Enter banned words:\n";
    for (int i = 0; i < bannedWordCount; i++)
    {
        getline(cin, bannedWords[i]);
    }

    ChatModerator moderator;
    string output = moderator.censorMessage(inputMessage, bannedWords);

    cout << "\nCensored Message: " << output << endl;

    return 0;
}
