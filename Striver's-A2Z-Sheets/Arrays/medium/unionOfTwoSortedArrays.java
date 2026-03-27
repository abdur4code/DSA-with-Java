
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
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0; 
        int j = 0;
        
        int ce = 0;
        
        while (i < a.length && j < b.length){
            if (a[i] < b[j]){
                ce = a[i];
                if (res.size() == 0 || res.get(res.size()-1) != ce){
                    res.add(ce);
                }
                i++;
            }
            else if(a[i] > b[j]){
                ce = b[j];
                if (res.size() == 0 || res.get(res.size()-1) != ce){
                    res.add(ce);
                }
                j++;
            }
            else{
                ce = b[j];
                if (res.size() == 0 || res.get(res.size()-1) != ce){
                    res.add(ce);
                }
                j++;
                i++;
            }
        }
        
        while (i < a.length){
            if (res.size() == 0 || res.get(res.size()-1) != a[i]){
                res.add(a[i]);
            }
            i++;
        }
        
        while (j < b.length){
            if (res.size() == 0 || res.get(res.size()-1) != b[j]){
                res.add(b[j]);
            }
            j++;
        }
        
        return res;
    }
}


/*
 * Union of Two Sorted Arrays
 *
 * both arrays are sorted so I can use two pointers
 * walk both arrays together, always pick the smaller one
 * this way result stays sorted automatically
 *
 * 3 cases:
 * a[i] < b[j]  → add a[i], move i
 * a[i] > b[j]  → add b[j], move j
 * a[i] == b[j] → add once, move both
 *
 * to skip duplicates → compare with last element in res
 * no need to scan whole list like contains()
 *
 * after main loop one array might still have elements
 * so drain both arrays with two separate while loops
 * always move pointer outside the duplicate check
 * otherwise infinite loop if duplicate found
 *
 * TC → O(n + m)  each element touched once
 * SC → O(n + m)  res stores at most n+m elements
 */