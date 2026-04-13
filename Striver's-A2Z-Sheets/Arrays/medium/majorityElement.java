
// 169. Majority Element
/* 
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
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