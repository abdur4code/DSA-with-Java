
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

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int max = 0;
        int count = 0;
        
        if ((n == 1) && (arr[0] == k)){
            max = n;
        }
        
        for (int i = 0; i<n; i++){
            int sum = arr[i];
            for (int j = i+1; j<n; j++){
                sum += arr[j];
                if (sum == k){
                    count = (j+1) - i;
                }
                max = Math.max(max, count);
                count = 0;
            }
            if(arr[i] == k && max == 0){
                max = 1;
            }
        }
        
        return max;
    }
}