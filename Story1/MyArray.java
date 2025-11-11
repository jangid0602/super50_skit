/**
 * @filename Myarray.java
 * This file defines the Myarray class which implements various array-based algorithms 
 * used in Assignment 4 of the OpenUpVS Java package.
 * 
 * It provides solutions for a range of logical and mathematical problems including:
 *  - The Efficient Traveler: Calculates the farthest reachable city with given energy.
 *  - The Sum That Stands Out: Finds an index where left and right sums are equal.
 *  - Flip the Switch: Determines minimum flips required to make all elements equal.
 *  - The Odd One Out: Identifies the unique element differing from others.
 *  - Smart Pair Finder: Checks for pairs of elements whose sum equals a target value.
 *  - The Minimalist Painter: Computes minimal total time after skipping one wall.
 * @author Priyanshu Joshi
 * @class Myarray
 * @description The Myarray class encapsulates multiple array manipulation and analysis 
 *              algorithms, providing modular implementations for different logical problems. 
 *              It supports both single-parameter and dual-parameter constructors for 
 *              flexible input handling.
 */

package codeupstory1;

import java.util.ArrayList;

public class Myarray {
    private ArrayList<Integer> nums; // store numbers
    private int value; // for energy or target

    // Default constructor
    public Myarray() {
        this.nums = new ArrayList<>();
        this.value = 0;
    }

    // For only array question
    public Myarray(ArrayList<Integer> nums) {
        this.nums = nums;
        this.value = 0; // Sets the default value (0)
    }

    // Parameterized constructor
    public Myarray(ArrayList<Integer> nums, int value) {
        this.nums = nums;
        this.value = value;
    }

    //
    public int efficientTraveler() {
        int energy = this.value;
        for (int i = 0; i < this.nums.size(); i++) {
            energy = energy - this.nums.get(i);
            if (energy < 0)
                return i - 1;
        }
        return this.nums.size() - 1;
    }

    // first index where the prefix sum equals the suffix sum
    public int sumThatStandsOut() {
        int total = 0;
        for (int i = 0; i < this.nums.size(); i++) {
            total += this.nums.get(i);

        }
        int leftSum = 0; // this is the sum of the left side of the array
        for (int j = 0; j < this.nums.size(); j++) {
            int rightSum = total - leftSum - this.nums.get(j);
            if (leftSum == rightSum) {
                return j;

            }

            leftSum += this.nums.get(j);

        }
        return -1;

    }

    // minimum number of flips required to make all elements equal
    public int flipTheSwitch() {
        int countFor0 = 0, countFor1 = 0;
        for (int i = 0; i < this.nums.size(); i++) {
            // Get the element at the current index i
            int n = this.nums.get(i);
            if (n == 0) {
                countFor0++;
            } else {
                countFor1++;
            }
        }
        int result;
        if (countFor0 < countFor1) {
            result = countFor0;
        } else {

            result = countFor1;
        }
        return result;
    }

    // The Odd One out
    public int oddOneOut() {
        int frequency = 0;
        for (int i = 0; i < this.nums.size(); i++) {
            frequency = 0;
            for (int j = 0; j < this.nums.size(); j++) {
                if (this.nums.get(i) == this.nums.get(j)) {
                    frequency++;
                }
            }
            if (frequency < 2) {
                return this.nums.get(i);
            }
        }
        return 0;
    }

    // Methord to find if there exists a pair (i,j) such that nums[i] + nums[j] ==
    // k.
    public boolean pairFinder() {
        for (int i = 0; i < this.nums.size(); i++) {
            for (int j = i + 1; j < this.nums.size(); j++) {
                if (this.nums.get(i) + this.nums.get(j) == this.value) {
                    return true;
                }
            }
        }
        return false;

    }

    // the minimum total time after skipping one wall.
    public int minimalistPainter() {
        int resultCollector = 0;
        int largestElement = Integer.MIN_VALUE;
        for (int i = 0; i < this.nums.size(); i++) {
            int currentNumber = this.nums.get(i);
            resultCollector = resultCollector + currentNumber;
            if (currentNumber > largestElement) {
                largestElement = currentNumber;
            }
        }
        return resultCollector - largestElement;
    }
}