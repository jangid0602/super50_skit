#include <bits/stdc++.h>
#include<limits>

using namespace std;

// 1
int theEfficientTraveler(int nums[], int size, int initialEnergy)
{
    if (size == 0)
    {
        return 0;
    }
    int cityIndex = 0;

    for (int index = 0; index < size; index++)
    {
        initialEnergy -= nums[index];
        if (initialEnergy < 0)
        {
            break;
        }

        cityIndex++;
    }

    return cityIndex;
}

// 2
int getTheSumThatStandsOut(int nums[], int size)
{
    if (size == 0)
        return -1;

    long long totalSum = 0;

    // calculate total sum of elements
    for (int index = 0; index < size; index++)
    {
        totalSum += nums[index];
    }

    long long prefixSum = 0;
    for (int index = 0; index < size; index++)
    {

        // calculate suffixSum excluding on index element
        long long suffixSum = totalSum - prefixSum - nums[index];

        if (suffixSum == prefixSum)
        {
            return index;
        }

        prefixSum += nums[index];
    }

    return -1;
}

// 3
int flipTheSwitch(int nums[], int size)
{

    if(size==0)
    {
        return 0;
    }
    
    int countZero = 0;
    int countOne = 0;

    for (int index = 0; index < size; index++)
    {
        if (nums[index] == 0)
        {
            countZero++;
        }
        else
        {
            countOne++;
        }
    }

    return min(countOne, countZero);
}

// 4
int theOddOneOut(int nums[], int size)
{
    if(size==1){
        return nums[0];
    }

    bool visited[size] = {false};

    for (int index = 0; index < size; index++)
    {

        for (int index2 = index + 1; index2 < size; index2++)
        {
            if (nums[index] == nums[index2])
            {
                visited[index] = true;
                visited[index2] = true;
            }
        }

        if(!visited[index]){
            return nums[index];
        }
    }
    
    return -1;
}

// 5
bool smartPairFinder(int nums[], int size, int target)
{
    if(size<2){
        return false;
    }

    for (int firstIndex = 0; firstIndex < size - 1; firstIndex++)
    {
        for (int secondIndex = firstIndex + 1; secondIndex < size; secondIndex++)
        {
            if (nums[firstIndex] + nums[secondIndex] == target)
            {
                return true;
            }
        }
    }

    return false;
}

// 6
int theMinimalistPainter(int time[], int size)
{

    // calculate total time along finding maximum element
    int totalTime = 0;
    int maxElement = time[0];

    for (int index = 0; index < size; index++)
    {
        totalTime += time[index];

        maxElement = max(maxElement, time[index]);
    }

    return totalTime - maxElement;
}

// helper function
int getValidatedInt() {
    int x;
    cin >> x;
    if (cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        throw invalid_argument("Invalid input! Please enter correct input");
    }
    return x;
}

int main() {
    while (true) {
        try {
            cout << "\nEnter your choice\n";
            cout << "0. To Exit Program\n"
                 << "1. Efficient Energy Calculation\n"
                 << "2. Suffix Prefix Index Finder\n"
                 << "3. Flip the Switch\n"
                 << "4. The Odd One Out\n"
                 << "5. Smart Pair Finder\n"
                 << "6. Minimalist Painter\n";
            cout << "Enter your choice: ";

            int choice = getValidatedInt();

            if (choice == 0) {
                cout << "Exiting Program!!" << endl;
                break;
            }

            switch (choice) {

                
                case 1: {
                    cout << "Enter number of cities: ";
                    int size = getValidatedInt();
                    int* energy = new int[size];

                    cout << "Enter energy values: ";
                    for (int i = 0; i < size; i++) {
                        energy[i] = getValidatedInt();
                    }

                    cout << "Enter initial energy: ";
                    int initialEnergy = getValidatedInt();

                    cout << "Maximum cities that can be visited: "
                         << theEfficientTraveler(energy, size, initialEnergy) << endl;

                    delete[] energy;
                    break;
                }

                
                case 2: {
                    cout << "Enter number of elements: ";
                    int size = getValidatedInt();
                    int* arr = new int[size];

                    cout << "Enter elements: ";
                    for (int i = 0; i < size; i++) {
                        arr[i] = getValidatedInt();
                    }

                    int index = getTheSumThatStandsOut(arr, size);

                    if (index != -1)
                        cout << "Index where prefix sum equals suffix sum: " << index << endl;
                    else
                        cout << "No such index found.\n";

                    delete[] arr;
                    break;
                }

                
                case 3: {
                    cout << "Enter number of binary values: ";
                    int size = getValidatedInt();
                    int* nums = new int[size];

                    cout << "Enter 0s and 1s: ";
                    for (int i = 0; i < size; i++) {
                        nums[i] = getValidatedInt();
                    }

                    cout << "Minimum flips required: " << flipTheSwitch(nums, size) << endl;

                    delete[] nums;
                    break;
                }

               
                case 4: {
                    cout << "Enter number of elements: ";
                    int size = getValidatedInt();
                    int* arr = new int[size];

                    cout << "Enter elements: ";
                    for (int i = 0; i < size; i++) {
                        arr[i] = getValidatedInt();
                    }
                    
                    int result=theOddOneOut(arr,size);

                    if(result==-1){
                        
                         cout << "No such element found!!"<<endl;
                    }
                    else{
                       cout << "The odd one out is: " << result << endl;
                    }

                    delete[] arr;
                    break;
                }

                
                case 5: {
                    cout << "Enter number of elements: ";
                    int size = getValidatedInt();
                    int* nums = new int[size];

                    cout << "Enter elements: ";
                    for (int i = 0; i < size; i++) {
                        nums[i] = getValidatedInt();
                    }

                    cout << "Enter target sum: ";
                    int target = getValidatedInt();

                    if (smartPairFinder(nums, size, target))
                        cout << "Pair found with the given target sum.\n";
                    else
                        cout << "No pair found.\n";

                    delete[] nums;
                    break;
                }

                
                case 6: {
                    cout << "Enter number of walls: ";
                    int size = getValidatedInt();
                    int* time = new int[size];

                    cout << "Enter painting times: ";
                    for (int i = 0; i < size; i++) {
                        time[i] = getValidatedInt();
                    }

                    cout << "Minimum time to paint all (skipping one): "
                         << theMinimalistPainter(time, size) << endl;

                    delete[] time;
                    break;
                }

                default:
                    cout << "Invalid choice! Try again.\n";
                    break;
            }

        } catch (const invalid_argument& e) {
            cout << e.what() << endl;
            cout << "Please try again.\n";
        }
    }

    return 0;
}
