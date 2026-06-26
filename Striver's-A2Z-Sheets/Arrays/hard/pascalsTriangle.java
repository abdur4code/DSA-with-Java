//118. Pascal's Triangle
/* 
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/

import java.util.ArrayList;
import java.util.List;
public class pascalsTriangle {
     public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> matrix = new ArrayList<>();
        int i = 0;

        while(i < numRows) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) row.add(1);
                else {
                    int nextElem = (matrix.get(i-1).get(j-1) + matrix.get(i-1).get(j));
                   row.add(nextElem);
                }

            }
            matrix.add(row);
            i++;
        }

        return matrix;
    }
}

/*
📊 Code Quality Rating: 9/10
Breakdown:

Correctness: ✅ Perfect — handles all cases including numRows=1 edge case naturally (loop just runs once, row=[1])
Time Complexity: ✅ Optimal — O(n²), can't do better since output itself has n² elements
Space Complexity: ✅ Optimal — O(1) auxiliary, O(n²) output (unavoidable)
Naming: 🟡 Minor nit — nextElem is fine but slightly misleading (it's not "next", it's the current computed element). Maybe currVal or currentElem reads cleaner. matrix is fine but triangle is more domain-accurate.
Readability: ✅ Clean, no nested ternaries or cleverness-for-cleverness-sake. Easy to read top to bottom.
Edge cases: ✅ Boundary check j==0 || j==i correctly handles every row including row 0.

Why not 10? Just the naming nit — that's genuinely it. Code is interview-ready.

📓 Notebook Notes — LC 118: Pascal's Triangle
Problem: Generate first numRows of Pascal's triangle.
Core Intuition: Each element (except edges) = sum of two elements diagonally above in previous row. row[i][j] = prevRow[j-1] + prevRow[j]. Edges (j==0 or j==i) are always 1 — no "above-left" or "above-right" exists for them.
Approach — Build row-by-row using previous row (Optimal)

Core idea: Maintain running list of rows. For each new row, first/last elem = 1, middle elems = sum of two adjacent elems from previous row.
TC: O(n²) — total elements across all rows ≈ n²/2
SC: O(1) auxiliary, O(n²) output (matrix itself is output space, not auxiliary)
When to use: Anytime current state depends only on immediately previous row — classic DP-on-rows pattern.

Why not Brute Force (Direct Combinatorics formula)

Core idea: row[i][j] = C(i, j) = i! / (j! * (i-j)!) — could compute each cell directly via factorial/combinatorics.
TC: O(n²) too (still n² cells) but each cell computation involves factorial — worse constant factor, and factorials overflow fast for larger i.
SC: O(1) auxiliary if computed iteratively without storing factorials, but practically messier and overflow-prone.
When to use: Only if you need a single specific cell (i,j) without building the whole triangle — not useful here since we need the full structure.

Key takeaway: This is the first "use previous result to build next result" pattern — foundational DP intuition (state[i] depends on state[i-1]). Remember this feeling — you'll see this recurrence shape constantly (Fibonacci, climbing stairs, etc.)
*/