// 73. Set Matrix Zeroes
/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

//Brute Force
//Time Complexity: O(m*n*(m+n)) Space Complexity: O(1)

import java.util.*;
public class setMatrixZeroes {
     public void setZeroes(int[][] matrix) {
        //Brute Force

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

         for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void markRow(int[][] matrix, int i) {
        int n = matrix[0].length;
        for(int j = 0; j < n; j++) {
            if(matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }
     private static void markCol(int[][] matrix, int j) {
        int m = matrix.length;
        for(int i = 0; i < m; i++) {
            if(matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }
}

 //Better Solution
//Time Complexity: O(m*n) Space Complexity: O(m+n)
class setMatrixZeroes2 {
    public void setZeroes(int[][] matrix) {
        //Better Solution
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMark = new int[m];
        Arrays.fill(rowMark, 0);
        int[] colMark = new int[n];
        Arrays.fill(colMark, 0);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rowMark[i] = 1;
                    colMark[j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rowMark[i] == 1 || colMark[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}