
// Longest Subarray with Sum K

/*Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Subarrays with sum = -5 are [-5] and [-5, 8, -14, 2, 4]. The length of the longest subarray with a sum of -5 is 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].

Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109*/

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {

        // maps prefix sum → earliest index it appeared at
        HashMap<Integer, Integer> seen = new HashMap<>();

        // seed with 0 at index -1 so subarrays starting
        // from index 0 are handled correctly
        seen.put(0, -1);

        int prefSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];

            // if (prefSum - k) was seen before, a valid
            // subarray exists from that index+1 to i
            if (seen.containsKey(prefSum - k)) {
                int earliestIdx = seen.get(prefSum - k);
                maxLen = Math.max(maxLen, i - earliestIdx);
            }

            // only store first occurrence — earlier index
            // gives us longer subarrays
            if (!seen.containsKey(prefSum)) {
                seen.put(prefSum, i);
            }
        }

        return maxLen;
    }
}
/* 
=====================key insights to remember========================
Prefix sum turns a subarray sum problem into a difference of two running totals problem.
Always seed the HashMap with (0, -1) to handle subarrays starting from index 0.
For longest subarray → store first occurrence. For count of subarrays → store frequency.
Two nested loops multiply complexity. Two sequential independent blocks add complexity. Keep responsibilities separate.
When you see "subarray sum = k" on any array (including negatives), think prefix sum + HashMap first.
*/