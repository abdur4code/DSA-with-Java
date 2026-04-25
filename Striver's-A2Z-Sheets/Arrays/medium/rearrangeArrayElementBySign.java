// 2149. Rearrange Array Elements by Sign
/*
LC 2149 — Rearrange Array Elements by Sign
Brute Force
Collect all positives in one list, all negatives in another, then interleave them into result array.
TC: O(n) | SC: O(n) — two extra lists + result
When to use: never really, just conceptual stepping stone
Optimal — Two Pointer on Result Array
Start posIdx = 0, negIdx = 1. Single pass through input — if positive, place at posIdx and jump by 2. If negative, place at negIdx and jump by 2. Guaranteed equal counts means both pointers stay in bounds.
TC: O(n) | SC: O(n) — only result array, no extra lists
When to use: anytime you need strict alternating placement with order preserved
Key Insight
Even indices belong to positives, odd indices belong to negatives — hardcode that from the start and you never need to think about interleaving separately.
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int posIdx = 0;
    int negIdx = 1;

    for (int i = 0; i < n; i++) {
        if (nums[i] > 0) {
            result[posIdx] = nums[i];
            posIdx += 2;
        } else {
            result[negIdx] = nums[i];
            negIdx += 2;
        }
    }

    return result;
}
}