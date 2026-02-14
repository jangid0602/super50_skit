/**
 * @filename - Task10.cpp
 * @description - The Project Builder's Blueprint
 * @author - Ayushi Shukla
 */

// Input: Task: Fix Bugs -> Sub: UI Bugs -> Sub: Button Color
// Output:
// Fix Bugs
// UI Bugs
// Button Color

#include <iostream>
#include <vector>
using namespace std;
struct TaskNode
{
    string taskName;
    vector<TaskNode *> subTasks;
    TaskNode(string name) : taskName(name) {}
};
void printTasks(TaskNode *root, int level = 0)
{
    if (!root)
        return;
    // Indent based on level
    for (int i = 0; i < level; i++)
        cout << "  ";
    cout << root->taskName << endl;
    for (TaskNode *subTask : root->subTasks)
    {
        printTasks(subTask, level + 1);
    }
}
int main()
{
    // Creating a sample task hierarchy
    TaskNode *root = new TaskNode("Fix Bugs");
    TaskNode *subTask1 = new TaskNode("UI Bugs");
    TaskNode *subTask2 = new TaskNode("Backend Bugs");
    TaskNode *subSubTask1 = new TaskNode("Button Color");
    TaskNode *subSubTask2 = new TaskNode("Layout Issues");

    root->subTasks.push_back(subTask1);
    root->subTasks.push_back(subTask2);
    subTask1->subTasks.push_back(subSubTask1);
    subTask1->subTasks.push_back(subSubTask2);

    cout << "Project Task Hierarchy:\n";
    printTasks(root);

    // Clean up memory (not shown for brevity)

    return 0;
}