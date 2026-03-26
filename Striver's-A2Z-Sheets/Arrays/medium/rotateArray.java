
// 189. Rotate Array

// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
 

// Follow up:

// Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
// Could you do it in-place with O(1) extra space?

class Solution {

    public void reverse(int[] nums, int start, int end ){
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        int n = nums.length-1;
        reverse(nums, 0, n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
        return;
    }
}

// 189. Rotate Array
// ==========================================
// CORE INSIGHT: Last k elements come to front
//
// NAIVE APPROACH: O(n) time, O(n) space
//   - Create new array
//   - Copy from (n-k) to n first
//   - Then copy from 0 to (n-k)
//
// OPTIMAL APPROACH: Reversal Algorithm — O(n) time, O(1) space
//   Step 1: k = k % n          → handles k > n edge case
//   Step 2: Reverse whole array
//   Step 3: Reverse first k elements (0 → k-1)
//   Step 4: Reverse remaining   (k → n-1)
//
// WHY IT WORKS:
//   Original:    [1, 2, 3, 4, 5, 6, 7]
//   Reverse all: [7, 6, 5, 4, 3, 2, 1]
//   Rev 0→k-1:   [5, 6, 7, 4, 3, 2, 1]
//   Rev k→n-1:   [5, 6, 7, 1, 2, 3, 4] ✅
//
// EDGE CASES:
//   k > n  → k % n handles it
//   k = n  → k % n = 0, no rotation
//   k = 0  → no rotation
//
// KEY LESSON: Repeat logic = extract a helper method