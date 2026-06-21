// LC 560. Subarray Sum Equals K

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/


import java.util.HashMap;

public class longestSubArrayWithSumK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int curSum = 0;
        int maxCount = 0;

        HashMap<Integer, Integer> seen = new HashMap<>();

        seen.put(0, 1);

        for(int i = 0; i < n; i++) {
            curSum += nums[i];

            if(seen.containsKey(curSum - k)) {
                maxCount += seen.get(curSum-k);
            }

            seen.put(curSum, seen.getOrDefault(curSum, 0) + 1);
        }

        return maxCount;
    }
}
