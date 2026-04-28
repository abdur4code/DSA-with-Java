
// GFG Array Leaders
/*
Problem: Array Leaders

Element is a leader if it's >= all elements to its right. Rightmost is always a leader.


Approach 1 — Brute Force

For each element, scan everything to its right
TC: O(n²) | SC: O(n)
When to use: Never in prod, only to build intuition


Approach 2 — Right to Left Running Max ✅

Traverse right to left, track running max
If arr[i] >= max → it's a leader, add to result
Update max after the check
Reverse result before returning
TC: O(n) | SC: O(n)
When to use: Always — this is the optimal approach


Core Insight:

Traversing right to left lets you carry the "max seen so far" for free — no nested loop needed.
*/

// =============Brute Force Approach=============
import java.util.*;
class Solution {
    public ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}

// ============Optimal Approach=============

class Solution2 {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        
        for(int i = n-1; i >= 0; i--){
            if(arr[i] >= max){
                result.add(arr[i]);
            }
            max = Math.max(max, arr[i]);
        }
        
        Collections.reverse(result);
        return result;
    }
}
