
// 169. Majority Element

// Problem: 169. Majority Element
// Link: https://leetcode.com/problems/majority-element/
// Difficulty: Easy

// Problem Statement:
// Given an array nums of size n, return the element that appears more than n/2 times.
// Majority element is guaranteed to exist.

// =====================================================================
// APPROACH 1: Brute Force
// =====================================================================
// Check every element, count its occurrences using nested loop.
// TC: O(n^2) | SC: O(1)

// =====================================================================
// APPROACH 2: HashMap
// =====================================================================
// Store frequency of each element in a map, track max frequency.
// TC: O(n) | SC: O(n)

// =====================================================================
// APPROACH 3: Boyer-Moore Voting Algorithm (OPTIMAL)
// =====================================================================
// Intuition: imagine a "room war" — every time two different elements
// meet, they cancel each other out and leave the room.
// The majority element appears more than n/2 times, so it CANNOT be
// fully cancelled. Whatever candidate survives at the end is the answer.
//
// candidate = current surviving element
// count = how many of them are left standing
//
// - same as candidate → count++
// - different → count--
// - count hits 0 → new candidate takes over
//
// TC: O(n) | SC: O(1)

import java.util.HashMap;
// =====================Approach 1: Brute Force=====================
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > n/2){
                return nums[i];
            }
        }
        return -1;
    }
}

// -----> Time Complexity: O(n^2)<-----> Space Complexity: O(1)<-----

// =====================Approach 2: HashMap=====================
class Solution2 {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int result = nums[0];
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
                if (map.get(nums[i]) > max) result = nums[i];
                max = Math.max(max, map.get(nums[i]));
            }
            else{
                map.put(nums[i], 1);
            }
        }

        return result;
    }
}

// ------> Time Complexity: O(n)<-----> Space Complexity: O(n)<-----

// ============Approach 3: Boyer-Moore Voting Algorithm=====================
class Solution3 {
    public int majorityElement(int[] nums) {
        
        int major = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == major) count++;
            else if (count != 0) count--;
            else{
                major = nums[i];
                count++;
            }
        }
        return major;
    }
}

// ------> Time Complexity: O(n)<-----> Space Complexity: O(1)<-----