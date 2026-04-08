
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

class Solution {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        int n = nums.length;

        if (n == 1){
            result = nums[0];
        }

        for (int i = 0; i < n; i++){
            int startIndex = i + 1;
            if(i == nums.length-1){
                startIndex = 0;
            }
            boolean unique = true;
            for (int j = 0; j < n-1; j++){
                int currentIndex = (startIndex + j) % n;
                if (nums[i] == nums[currentIndex]){
                    unique = false;
                    break;
                }
            }
            if(unique){
                result = nums[i];
                break;
            }
        }
        return result;
    }
}