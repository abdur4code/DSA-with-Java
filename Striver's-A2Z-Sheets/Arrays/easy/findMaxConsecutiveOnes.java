
// 485. Max Consecutive Ones

/*Given a binary array nums, return the maximum number of consecutive 1's in the array. 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        // current streak
        int count = 0;
        // best streak so far
        int max = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
                // update max as streak grows
                max = Math.max(max, count);
            }
            else {
                // 0 found, reset streak
                count = 0;
            } 
        }

        return max;
    }
}

// LC 485 — Max Consecutive Ones

/*Problem: Given a binary array, return the length of the longest streak of 1s.
Brute Force: For every index, run an inner loop to count the streak starting there. O(n²) — wasteful because you're re-counting things you already saw.
Optimal Approach — Single Pass O(n) / O(1)
Two variables: count (current streak) and max (best streak). Walk the array once — if you see a 1, grow the streak and update max. If you see a 0, reset count to 0. Max never goes back down, so by the end it holds the answer.
Key insight: Update max inside the if (nums[i] == 1) block only — no point running Math.max when count just got reset to 0, it can never improve max at that point.
Complexity: Time O(n) — one pass. Space O(1) — just two variables.*/