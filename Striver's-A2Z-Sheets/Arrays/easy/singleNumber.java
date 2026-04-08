
// 136. Single Number

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

 
Example 1:
Input: nums = [2,2,1]
Output: 1


Example 2:
Input: nums = [4,1,2,1,2]
Output: 4


Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.*/



// --- my journey on this problem ---

// first try: nested loop, circular traversal to avoid self-comparison — worked but O(n²)
// second try: sort first, compare pairs (i, i+1) — cleaner, O(n log n) but still not enough
// final insight: XOR! same number XOR same number = 0, so all pairs cancel out
// whatever survives the XOR chain is the single number

// why XOR works:
// a ^ a = 0       (duplicates kill each other)
// a ^ 0 = a       (unique number survives)
// order doesn't matter — XOR is commutative

// dry run on [4, 1, 2, 1, 2]:
// xor = 0
// xor ^ 4 = 4
// xor ^ 1 = 5
// xor ^ 2 = 7
// xor ^ 1 = 6   <-- 1 cancels its pair
// xor ^ 2 = 4   <-- 2 cancels its pair, only 4 survives

class Solution {
    public int singleNumber(int[] nums) {

        int xor = 0; // starting from 0 because a ^ 0 = a, safe neutral start

        for (int num : nums) {
            xor ^= num; // each duplicate pair will cancel to 0
        }

        return xor; // only the single number remains
    }
}