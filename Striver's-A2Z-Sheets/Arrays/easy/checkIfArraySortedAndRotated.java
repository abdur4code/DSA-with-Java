

//1752. Check if Array Is Sorted and Rotated
//
//Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero).
//Otherwise, return false.
//There may be duplicates in the original array.
//
//Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.
//
//
//
//Example 1:
//
//Input: nums = [3,4,5,1,2]
//Output: true
//Explanation: [1,2,3,4,5] is the original sorted array.
//You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
//Example 2:
//
//Input: nums = [2,1,3,4]
//Output: false
//Explanation: There is no sorted array once rotated that can make nums.
//        Example 3:
//
//Input: nums = [1,2,3]
//Output: true
//Explanation: [1,2,3] is the original sorted array.
//You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;
        int count = 0;

        if(n == 1){
            return true;
        }

        for (int i = 0; i < n - 1; i++){
            if (nums[i] > nums[i+1]){
                count += 1;
            }
        }
        if(nums[n-1] > nums[0]){
            count += 1;
        }
        return count <= 1;
    }
}
//
//=====Leetcode 1752 · Easy=======
//===Check if array is sorted and rotated===
//===Count the "breaks" a sorted array can only be cut once===

//--------->Core insight<--------
//===A valid rotation has at most 1 break, a point where nums[i] > nums[i+1].
//        0 breaks = already sorted  |  1 break = rotated once  |  2+ breaks = invalid

//------>Algorithm<------
// 1:- Loop i = 0 to n-2. If nums[i] > nums[i+1], increment break count.
// 2:- Check the wrap-around pair: if nums[n-1] > nums[0], increment break count.
// 3:- Return count <= 1.

//----->Why at most 1 break?<-------
//A sorted array is one smooth sequence, means zero breaks.
//Rotating = making one cut and swapping the two halves.
//One cut creates exactly one break. You can't get 2 breaks from 1 cut.
//        2+ breaks means the original was never sorted to begin with.

//------>Complexity<------
// Time O(n)
// Space O(1)