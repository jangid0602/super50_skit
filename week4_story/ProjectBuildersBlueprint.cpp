/**
 * @filename   : ProjectBuildersBlueprint.cpp
 * @description: Print a task hierarchy using recursion and indentation.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Task {
public:
    string name;
    vector<Task*> subTasks;

    Task(string taskName) : name(taskName) {}
};

void printTasks(Task* task, int level) {
    if (!task) return;

   
    for (int i = 0; i < level; i++)
        cout << "  ";

    cout << task->name << endl;

    
    for (Task* subTask : task->subTasks)
        printTasks(subTask, level + 1);
}

int main() {
   
    Task* mainTask = new Task("Fix Bugs");
    Task* uiBugs = new Task("UI Bugs");
    Task* buttonColor = new Task("Button Color");

    uiBugs->subTasks.push_back(buttonColor);
    mainTask->subTasks.push_back(uiBugs);

    
    printTasks(mainTask, 0);

    return 0;
}
