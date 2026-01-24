/**
 * @filename: Task3.cpp
 * @description: Minimum Time to Complete All Tasks
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class TaskScheduler
{
public:
    int minimumCompletionTime(
        int totalTasks,
        vector<int> &taskTime,
        vector<vector<int>> &dependencies)
    {
        // Step 1: Create graph and indegree array
        vector<vector<int>> adjacencyList(totalTasks);
        vector<int> indegree(totalTasks, 0);

        for (int i = 0; i < dependencies.size(); i++)
        {
            int prerequisite = dependencies[i][0];
            int dependentTask = dependencies[i][1];

            adjacencyList[prerequisite].push_back(dependentTask);
            indegree[dependentTask]++;
        }

        // Step 2: Queue for tasks with no dependencies
        queue<int> taskQueue;
        vector<int> completionTime(totalTasks, 0);

        for (int i = 0; i < totalTasks; i++)
        {
            if (indegree[i] == 0)
            {
                taskQueue.push(i);
                completionTime[i] = taskTime[i];
            }
        }

        // Step 3: Topological traversal
        while (!taskQueue.empty())
        {
            int currentTask = taskQueue.front();
            taskQueue.pop();

            for (int nextTask : adjacencyList[currentTask])
            {
                completionTime[nextTask] =
                    max(completionTime[nextTask],
                        completionTime[currentTask] + taskTime[nextTask]);

                indegree[nextTask]--;

                if (indegree[nextTask] == 0)
                    taskQueue.push(nextTask);
            }
        }

        // Step 4: Maximum completion time
        int totalTime = 0;
        for (int i = 0; i < totalTasks; i++)
            totalTime = max(totalTime, completionTime[i]);

        return totalTime;
    }
};

int main()
{
    int totalTasks;
    cout << "Enter number of tasks: ";
    cin >> totalTasks;

    vector<int> taskTime(totalTasks);
    cout << "Enter time for each task:\n";
    for (int i = 0; i < totalTasks; i++)
        cin >> taskTime[i];

    int totalDependencies;
    cout << "Enter number of dependencies: ";
    cin >> totalDependencies;

    vector<vector<int>> dependencies(totalDependencies, vector<int>(2));
    cout << "Enter dependencies (task prerequisite):\n";
    for (int i = 0; i < totalDependencies; i++)
        cin >> dependencies[i][0] >> dependencies[i][1];

    TaskScheduler scheduler;
    cout << "Minimum Time Required: "
         << scheduler.minimumCompletionTime(
                totalTasks, taskTime, dependencies);

    return 0;
}