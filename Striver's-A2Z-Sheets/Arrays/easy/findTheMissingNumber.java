
// Find the Missing Number

// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.

// Examples:

// Input: arr[] = [1, 2, 3, 5]
// Output: 4
// Explanation: All the numbers from 1 to 5 are present except 4.
// Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
// Output: 6
// Explanation: All the numbers from 1 to 8 are present except 6.
// Input: arr[] = [1]
// Output: 2
// Explanation: Only 1 is present so the missing element is 2.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ arr.size() + 1

class Solution {
    int missingNum(int arr[]) {

        // idea: sum of 1 to n is a known formula — n*(n+1)/2
        // if i subtract the actual array sum from expected sum, i get the missing number
        // clean, no sorting needed

        // IMPORTANT: n can be up to 10^6, so n*(n+1) can hit ~10^12
        // int max is only ~2.1 billion — so i must use long to avoid overflow
        // lesson learned the hard way lol

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // accumulate actual sum
        }

        long n = arr.length + 1; // n is size+1 because one element is missing
        long exSum = (n * (n + 1)) / 2; // expected sum formula — n must be long here!
        // if n is int, n*(n+1) overflows BEFORE assignment to long — sneaky bug

        long result = exSum - sum; // missing number is the difference

        return (int) result;
    }
}

// TC: O(n) — single loop, everything else is O(1)
// SC: O(1) — no extra space