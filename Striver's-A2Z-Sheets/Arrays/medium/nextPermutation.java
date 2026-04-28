
// LC 31 Next Permutation

/* 
Problem: Next Permutation (LC 31) - Medium
Pattern: Array Manipulation

─────────────────────────────────────────
BRUTE FORCE
─────────────────────────────────────────
Idea    : generate all permutations, sort,
          find current, return next
TC      : O(n! * n)
SC      : O(n!)
Use when: never, only for understanding

─────────────────────────────────────────
OPTIMAL — 3 Step Algorithm
─────────────────────────────────────────
Idea    : find pivot, swap with next greater,
          reverse suffix
TC      : O(n)
SC      : O(1)
Use when: next lexicographic arrangement
          needed in-place

Step 1 → find pivot
  traverse right to left
  first index where nums[i] < nums[i+1]
  pivotIdx = i-1

Step 2 → find swap candidate
  traverse right to left from end
  first element greater than pivot
  swap with pivot

Step 3 → reverse suffix
  reverse everything right of pivotIdx
  descending → ascending, no sort needed

Edge case → pivotIdx == -1 (fully descending)
  reverse entire array

─────────────────────────────────────────
KEY INSIGHTS
─────────────────────────────────────────
→ right side of pivot is always descending
→ first element > pivot from right =
  smallest greater than pivot
→ reverse suffix instead of sort = O(n)
→ use pivotIdx = -1 as sentinel
→ extract reverse() as helper — DRY principle
  repeated logic = extract it
*/

class Solution {
    public void nextPermutation(int[] nums) {

        int pivotIdx = -1;
        int minIdx = 0;
        int n = nums.length;

        // Finding pivotIdx
        for(int i = n-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                pivotIdx = i-1;
                break;
            }
        }

        // Edge Case handle for not pivotIdx found
        if(pivotIdx == -1){
           reverse(nums, 0, n-1);
        }

        // After Pivot found operations
        else{
            // Finding next smallest element which is greater than pivot
            for(int j = n-1; j > pivotIdx; j--) {
                if(nums[j] > nums[pivotIdx]){
                    minIdx = j;
                    break;
                }
            }

            // Swapping pivot element with smallest element which is greater than pivot 
            int temp = nums[pivotIdx];
            nums[pivotIdx] = nums[minIdx];
            nums[minIdx] = temp;

            // Reversing descending suffix to ascending smallest element at 1st and largest at the end
            reverse(nums, pivotIdx+1, n-1);
        }

    }

      // Reverse helper method
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

