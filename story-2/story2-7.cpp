#include <iostream>
#include <sstream>
#include <string>
using namespace std;

string compressLogWithRunLengthEncoding(const string &logData) {
    istringstream inputStream(logData);
    string previousLog, currentLog;

    if (!(inputStream >> previousLog)) return "";

    int logCount = 1;
    ostringstream compressedOutput;

    while (inputStream >> currentLog) {
        if (currentLog == previousLog) {
            ++logCount;
        } else {
            compressedOutput << previousLog << " " << logCount << " ";
            previousLog = currentLog;
            logCount = 1;
        }
    }

    compressedOutput << previousLog << " " << logCount;
    return compressedOutput.str();
}

int main() {
    string logData;
    cout << "Enter the log string (space-separated):\n";
    getline(cin, logData);

    string compactedLog = compressLogWithRunLengthEncoding(logData);

    cout << "\nCompacted log:\n" << compactedLog << endl;
    return 0;
}
