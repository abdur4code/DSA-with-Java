
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

import java.util.Arrays;

class Solution {
    int missingNum(int arr[]) {

        int count = 1;
        int result = 1;

        Arrays.sort(arr); // O(n log n) — this is the bottleneck

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != count) {
                result = count; // sequence broke here — count is the missing number
                break;
            }
            count++;
            result = count; // keep updating in case missing number is at the end
        }

        return result;
    }
}

// idea: if i sort the array, the missing number will break the sequence
// so i just walk through and compare each element with what i expect (count)
// the moment they don't match — that's my missing number

// edge case: if missing number is the last one (n itself),
// the loop ends without breaking — result holds the final incremented count which is correct


// TC: O(n log n) — sorting dominates
// SC: O(1) — no extra space used