
// Problem: Maximum Subarray (LC 53)
// Given an integer array, find the subarray with the largest sum and return its sum.

// ─────────────────────────────────────────
// APPROACH 1 — Brute Force
// try every possible subarray using nested loops, track max sum seen
// TC: O(n²) | SC: O(1)
// ─────────────────────────────────────────

class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i+1; j < n; j++){
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

// ─────────────────────────────────────────
// APPROACH 2 — Kadane's Algorithm (OPTIMAL) ✅
// walk left to right with a running sum
// core idea: a negative running sum only hurts future elements
//            so reset to 0 when sum goes negative (drop the bag)
// at every step update max
// TC: O(n) | SC: O(1)
// ─────────────────────────────────────────

class Solution {
    public int maxSubArray(int[] nums) {
        
        // start max at first element to handle all-negative arrays
        int max = nums[0];
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];                  // extend current subarray
            max = Math.max(max, sum);        // update best seen so far
            if (sum < 0) sum = 0;           // drop the bag if sum goes negative
        }
        return max;
    }
}