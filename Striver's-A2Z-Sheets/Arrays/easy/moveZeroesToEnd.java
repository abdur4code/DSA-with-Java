
// 283. Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 

// Follow up: Could you minimize the total number of operations done?

class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums.length <= 1){
            return;
        }

        int j=0;
        int n= nums.length-1;
        for (int i=0; i<=n; i++){
          if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while (j <= n){
            nums[j] = 0;
            j++;
        }
        
        return;
    }
}

// 283. Move Zeroes
// ==========================================
// CORE INSIGHT: Place all non-zero elements in order,
//               then fill remaining positions with 0
//
// NAIVE APPROACH: O(n) time, O(n) space
//   - Create new array
//   - Copy non-zero elements first
//   - Fill remaining with 0
//
// OPTIMAL APPROACH: Two Pointer — O(n) time, O(1) space
//   - j = placement pointer (where next non-zero should go)
//   - i = scanner pointer (scans whole array)
//   - If nums[i] != 0 → place at j, move j forward
//   - After loop → fill j to n with 0
//
// WHY IT WORKS:
//   Input:  [0, 1, 0, 3, 12]
//   i=0: 0  → skip
//   i=1: 1  → nums[0]=1, j=1
//   i=2: 0  → skip
//   i=3: 3  → nums[1]=3, j=2
//   i=4: 12 → nums[2]=12, j=3
//   fill:   → nums[3]=0, nums[4]=0
//   Output: [1, 3, 12, 0, 0] ✅
//
// EDGE CASES:
//   all zeros → j never moves, fill whole array with 0
//   no zeros  → j and i move together, nothing changes
//   one element → loop runs once, works fine
//
// KEY LESSON: Instead of swapping, just OVERWRITE forward
//             then fill zeroes at the end — fewer operations