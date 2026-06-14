/*
Problem: Longest Consecutive Sequence (LC 128)
Difficulty: Medium

------------------------------------------------------------
APPROACH 1 — Sorting
------------------------------------------------------------
Idea     : Sort array, scan for consecutive elements,
           skip duplicates with continue
TC       : O(n log n)
SC       : O(1)
Use when : No O(n) constraint

------------------------------------------------------------
APPROACH 2 — HashSet (Optimal)
------------------------------------------------------------
Idea     : Add all numbers to HashSet
           Iterate over SET (not array) to avoid
           duplicate processing
           Only count from sequence starts —
           a number is a start if (num-1) not in set
           Walk forward with while loop until chain breaks
TC       : O(n) — each element processed exactly once
SC       : O(n)
Use when : O(n) required, unsorted array

Key insight 1 : Iterate over set not array —
                duplicates in array cause same sequence
                start to trigger while loop multiple times
Key insight 2 : continue guard ensures while loop runs
                at most n times TOTAL across all iterations
------------------------------------------------------------
*/

// ====================Better Approach================
import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        int count = 1;
        int max = 1;

        if(n <= 1){
            return n;
        }

        Arrays.sort(nums);
        
        for(int i = 0; i < n-1; i++){
            if((nums[i]+1 == nums[i+1])){
                count++;
                max = Math.max(max, count);
            }
            else if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                count = 1;
            }
        }

        return max;
    }
}


// =====================Optimal Approach================
class Solution1 {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int i: nums) set.add(i);

        for(int num : set){
            if(set.contains(num-1)) continue;
            int start = num;

            int count = 1;
            while(set.contains(start+1)){
                start++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}