
// LC 1. Two Sum

/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order. 

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/


// ============Approach 1 — Brute Force============
import java.util.HashMap;

class BFSolution {
    public int[] twoSum(int[] nums, int target) {

        // brute force — check every pair
        // TC: O(n^2), SC: O(1)

        int[] result = new int[2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // j starts at i+1, not 1 — learned this the hard way
            // starting at 1 caused same-index reuse bug
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}

// ============Approach 2 Optimized — HashMap============

class OptimizedSolution {
    public int[] twoSum(int[] nums, int target) {

        // optimal — single pass HashMap
        // key insight: for each element, check if its complement (target - nums[i])
        // was already seen. if yes, we have our pair.
        // TC: O(n), SC: O(n)

        HashMap<Integer, Integer> seen = new HashMap<>(); // value -> index
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            // check complement first, then store current element
            // if we store first, we risk matching an element with itself
            // e.g. nums=[4], target=8 would wrongly return [0,0]
            if (seen.containsKey(target - nums[i])) {
                result[0] = seen.get(target - nums[i]); // index of complement
                result[1] = i;
                break;
            }

            seen.put(nums[i], i);
        }

        return result;
    }
}


// ==============📓 Notes==============
/*
LC 1 — Two Sum
Problem: Given an array and a target, return indices of two numbers that add up to the target.

-------->Approach 1 — Brute Force<-----------
The naive idea is to check every possible pair. Use two nested loops where i goes from 0 to n-1 and j starts from i+1 (not 1 — that was my bug initially, j=1 caused same-element reuse). For each pair, check if they sum to target.
The reason j = i+1 matters is that it guarantees we never pick the same index twice, and we don't recheck pairs we already saw.

TC: O(n²) — nested loops
SC: O(1) — no extra space


--------->Approach 2 — HashMap (Single Pass)<-----------
The bottleneck in brute force is the inner scan. For every element, we're asking "does its complement exist?" — and scanning the whole array to answer that. HashMap answers that in O(1).
The insight: for every nums[i], the complement we need is target - nums[i]. If that complement was seen before, we have our answer. If not, store the current element and move on.
Key decision — why seen.put() goes AFTER the if-check:
If we add the element first, then check, we might match an element with itself. Example: nums = [4], target = 8. We'd find 4 in the map and return [0,0] — wrong. Adding after the check prevents self-matching.

TC: O(n) — single pass
SC: O(n) — HashMap stores up to n elements
*/
