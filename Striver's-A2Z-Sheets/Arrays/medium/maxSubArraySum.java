
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
