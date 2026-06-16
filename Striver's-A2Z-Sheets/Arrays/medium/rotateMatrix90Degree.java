public class rotateMatrix90Degree {
     public void rotate(int[][] matrix) {
        
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        
        for(int i = 0; i < n; i++) {
            int start = 0;
            int end = n-1;
            while( start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}


/* 
Problem: Rotate Image 90° Clockwise (LC 48)
Constraints: in-place, n x n matrix

─────────────────────────────────────────────
APPROACH 1 — Brute Force (Extra Space)
─────────────────────────────────────────────
Idea     : new_matrix[col][n-1-row] = matrix[row][col]
           copy result back into original
Time     : O(n²)
Space    : O(n²)
Use when : not restricted to in-place

─────────────────────────────────────────────
APPROACH 2 — Transpose + Reverse (Optimal)
─────────────────────────────────────────────
Idea     : Step 1 — transpose matrix (swap matrix[i][j] with matrix[j][i])
           Step 2 — reverse each row left to right
Why      : transpose turns rows into columns,
           reversing each row fixes the direction → clockwise
Time     : O(n²)
Space    : O(1) — truly in-place
Use when : in-place rotation required (most interviews)

Key insight : j starts from i in transpose loop
              to avoid double-swapping elements

─────────────────────────────────────────────
APPROACH 3 — 4-pointer Cycle (Alternative)
─────────────────────────────────────────────
Idea     : rotate 4 elements at a time in their cycle
           using 1 temp variable (like the "extra chair" trick)
Formula  : new_row = col, new_col = (n-1) - row
Time     : O(n²)
Space    : O(1)
Use when : interviewer asks you to avoid transpose trick

─────────────────────────────────────────────
Revision : Day 1 → Day 7 → Day 30 → Day 60
─────────────────────────────────────────────
*/