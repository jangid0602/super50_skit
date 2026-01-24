/**
 * @filename - story3.cpp
 * @description - minimum time to complete the task
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> calculateMinimumCompletionTime(
    int numberOfTasks,
    vector<vector<int>> &dependencyEdges,
    vector<int> &taskTime)
{
    vector<int> indegree(numberOfTasks, 0);
    vector<vector<int>> adjacencyList(numberOfTasks);

    for (auto &edge : dependencyEdges)
    {
        int prerequisiteTask = edge[0];
        int dependentTask = edge[1];

        adjacencyList[prerequisiteTask].push_back(dependentTask);
        indegree[dependentTask]++;
    }

    queue<int> taskQueue;
    vector<int> completionTime(numberOfTasks, 0);

    for (int task = 0; task < numberOfTasks; task++)
    {
        if (indegree[task] == 0)
        {
            taskQueue.push(task);
            completionTime[task] = taskTime[task];
        }
    }

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
            {
                taskQueue.push(nextTask);
            }
        }
    }

    return completionTime;
}

int main()
{
    int numberOfTasks;
    cout << "Enter number of tasks: ";
    cin >> numberOfTasks;

    int numberOfDependencies;
    cout << "Enter number of dependencies: ";
    cin >> numberOfDependencies;

    vector<vector<int>> dependencyEdges;
    for (int i = 0; i < numberOfDependencies; i++)
    {
        int prerequisiteTask, dependentTask;
        cout << "Enter dependency (prerequisiteTask dependentTask): ";
        cin >> prerequisiteTask >> dependentTask;
        dependencyEdges.push_back({prerequisiteTask, dependentTask});
    }

    vector<int> taskTime(numberOfTasks);
    cout << "Enter time required for each task: ";
    for (int i = 0; i < numberOfTasks; i++)
    {
        cin >> taskTime[i];
    }

    vector<int> completionTime =
        calculateMinimumCompletionTime(
            numberOfTasks,
            dependencyEdges,
            taskTime);

    int minimumTotalTime = 0;
    for (int time : completionTime)
    {
        minimumTotalTime = max(minimumTotalTime, time);
    }

    cout << "Minimum time to complete all tasks: "
         << minimumTotalTime;

    return 0;
}
