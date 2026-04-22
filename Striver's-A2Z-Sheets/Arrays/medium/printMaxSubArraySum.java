
// Print subarray with maximum subarray sum (extended version of above problem)
/*
Problem: Print Subarray with Maximum Sum (Extended LC 53)
Difficulty: Medium | Topic: Arrays

─────────────────────────────────────────
APPROACH — Kadane's + Index Tracking ✅
Core idea: extend Kadane's by tracking start/end indices.
           tempStart roams freely, start only locks in
           when a new best sum is found.
TC: O(n) | SC: O(1)
When to use: when problem asks for actual subarray not just sum

Key variables:
  currentSum → running sum
  maxSum     → best sum seen so far
  tempStart  → where current subarray begins (roams freely)
  start      → locked start of best subarray
  end        → locked end of best subarray

Code pattern:
  if currentSum >= maxSum → update start=tempStart, end=i
  maxSum = Math.max(maxSum, currentSum)
  if currentSum < 0 → reset currentSum=0, tempStart=i+1

Gotcha 1: use >= not > when updating end
          handles all-negative arrays correctly
Gotcha 2: never move start directly — use tempStart
          start only updates when you find a new best
─────────────────────────────────────────
*/

class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            
            if (currentSum >= maxSum) { 
                end = i;
                start = tempStart; 
            }
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i+1;
            }
           
        }

        for(int i = start; i <= end; i++){
            System.out.println(nums[i]);
        }

        return maxSum;
    }
}