//54. Spiral Matrix
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while (top <= bottom && left <= right) {
            
            //collecting top row 
            for(int j = left; j <= right; j++) {
                 result.add(matrix[top][j]);
            }
            top++;
            //collecting right column
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            
            // Add bottom row only if top and bottom haven't crossed
            // i.e., this row is still distinct and not yet fully visited
            if(top <= bottom){
                //collecting bottom row reverse
                for(int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
           
            //Only add if this col hasn't already been consumed by the right
            if(left <= right) {
                //collecting left column reverse
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}

/*
LC 54 — Spiral Matrix
Problem: Matrix ke elements ko spiral order mein nikaalna hai (right → down → left → up, repeat, boundaries shrink karte rehna).

Approach 1: Brute Force — Direction Simulation
Idea: Ek pointer chalao matrix pe, current direction mein move karo. Jab boundary hit ho jaaye ya already-visited cell aa jaaye, clockwise turn kar lo (right→down→left→up→right...). Track karne ke liye visited[m][n] matrix chahiye.

TC: O(m×n) — har cell ek baar visit hota hai
SC: O(m×n) — extra visited matrix ki wajah se
Kab use karna: Jab traversal shape irregular ho (spiral kisi corner se start na ho, ya custom shape ho) — wahan fixed boundaries kaam nahi karte, but direction+visited approach phir bhi chalta hai.
Downside: Extra space lagta hai, interview mein optimal nahi maana jaata agar boundary approach possible hai.


Approach 2: Optimal — Boundary Layer Peeling ✅ (ye use kiya)
Idea: 4 boundaries rakho — top, bottom, left, right. Har iteration mein ek "ring" peel karo:

Top row left→right, top++
Right column top→bottom, right--
Agar top <= bottom: Bottom row right→left, bottom--
Agar left <= right: Left column bottom→top, left++

Loop chalta hai jab tak top <= bottom && left <= right.

TC: O(m×n)
SC: O(1) auxiliary (result array output space hai, extra nahi)
Kab use karna: Koi bhi geometric matrix traversal problem (spiral, boundary traversal, diagonal-ish patterns) — boundary shrinking hi go-to technique hai.


🔑 Sabse Important Gotcha (yaad rakhna!)
Guard condition mein <= use karna hai, < nahi!
Kyun: Jab top == bottom (ya left == right), iska matlab woh row/column abhi tak fully consumed nahi hua — sirf corner cell touch hua hai pehle wale sweep se. Agar < use karoge, ye guard wrongly skip ho jayega — elements miss nahi honge (next iteration mein pick ho jaayenge) but order galat aa jayega. Specifically 2-row ya 2-column matrix pe pakda jaata hai bug — odd-sized matrix (3x3 type) pe chhup jaata hai!
Lesson: Boundary-shrinking problems mein off-by-one (!= vs < vs <=) hi sabse zyada bug deta hai. Test karte time hamesha:

Odd dimensions (3x3)
Even dimensions (2x3, 4x4)
Single row / single column
1x1

sab try karna, sirf ek case se confidence mat lena.
*/
