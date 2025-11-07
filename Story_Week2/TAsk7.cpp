// @filename-Task7.cpp
// @Description: Compresses a space-separated log string using run-length encoding.
// @Author: Ayushi Shukla

#include <iostream>
#include <sstream>
#include <string>
using namespace std;

class LogCompressor
{
public:
    string compressLog(const string &logData)
    {
        istringstream inputStream(logData);
        string previousLog, currentLog;

        // Handle empty input
        if (!(inputStream >> previousLog))
            return "";

        int logCount = 1;
        ostringstream compressedOutput;

        while (inputStream >> currentLog)
        {
            if (currentLog == previousLog)
            {
                ++logCount;
            }
            else
            {
                compressedOutput << previousLog << "(" << logCount << ") ";
                previousLog = currentLog;
                logCount = 1;
            }
        }

        // Append the last log
        compressedOutput << previousLog << "(" << logCount << ")";

        return compressedOutput.str();
    }
};

int main()
{
    string logData;
    cout << "Enter the log string (space-separated):\n";
    getline(cin, logData);

    LogCompressor compressor;
    string compactedLog = compressor.compressLog(logData);

    cout << "\nCompacted log:\n"
         << compactedLog << endl;

    return 0;
}
