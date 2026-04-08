
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


// =============Notes of all approaches=============

/*
============================================================
LC 136 — Single Number
============================================================

PROBLEM
-------
Array where every element appears twice except one.
Find the single one.
Constraint: O(n) time, O(1) space.

EXAMPLES
--------
[2, 2, 1]       → 1
[4, 1, 2, 1, 2] → 4
[1]             → 1

------------------------------------------------------------
APPROACH 1 — Brute Force (my first attempt)
------------------------------------------------------------
Idea    : For each element, scan the rest of the array
          Used circular traversal to avoid self-comparison
TC      : O(n²)
SC      : O(1)
Verdict : Correct logic, too slow

------------------------------------------------------------
APPROACH 2 — Sort + Compare Pairs
------------------------------------------------------------
Idea    : Sort array → duplicates sit next to each other
          Walk two steps at a time, compare nums[i] != nums[i+1]
          If loop ends without finding → single is at last index
TC      : O(n log n)
SC      : O(1)
Verdict : Better, but sorting cost doesn't meet constraint

Lesson  : Don't use magic numbers as sentinels (used 40000, risky)
          Better to initialize result = nums[n-1] upfront

------------------------------------------------------------
APPROACH 3 — XOR (optimal)
------------------------------------------------------------
Core insight:
  a ^ a = 0    → duplicates cancel each other
  a ^ 0 = a    → unique number survives

Algorithm:
  xor = 0
  for every num in array:
      xor = xor ^ num
  return xor

Dry run [4, 1, 2, 1, 2]:
  0 ^ 4 = 4
  4 ^ 1 = 5
  5 ^ 2 = 7
  7 ^ 1 = 6   (1 cancels)
  6 ^ 2 = 4   (2 cancels) ✓

TC      : O(n)
SC      : O(1)
Verdict : Optimal ✓ — beats 99.98%

------------------------------------------------------------
KEY LESSONS
------------------------------------------------------------
1. Sorted array → think pairs/two-pointer patterns
2. XOR is the go-to when duplicates need to cancel
3. Magic number sentinels are dangerous — avoid them
4. Same number XOR itself always = 0 (bit level cancellation)
============================================================
*/