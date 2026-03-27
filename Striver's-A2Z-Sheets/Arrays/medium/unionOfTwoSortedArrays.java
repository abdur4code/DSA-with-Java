
// Union of 2 Sorted Arrays (GFG)

// Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.
// Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.

// Examples:

// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
// Output: [1, 2, 3, 4, 5, 6, 7]
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
// Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
// Output: [1, 2, 3, 4, 5]
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
// Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
// Output: [1, 2]
// Explanation: Distinct elements including both the arrays are: 1 2.
// Constraints:
// 1  ≤  a.size(), b.size()  ≤  105
// -109 ≤ a[i], b[i] ≤109
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i=0; i<a.length; i++){
            if (!res.contains(a[i])){
                res.add(a[i]);
            }
        }
        
        for (int j=0; j<b.length; j++){
            if (!res.contains(b[j])){
               res.add(b[j]); 
            }
        }
        Collections.sort(res);
        return res;
    }
}
