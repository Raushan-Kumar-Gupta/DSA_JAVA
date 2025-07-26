package Matrix_2D_Arrays;
/*
Set Matrix Zeroes:

- If any cell in the matrix is 0, set its entire row and column to 0.
- First pass: Mark rows and columns that need to be zeroed using two arrays (row[] and col[]).
- Second pass: Update the matrix based on marked rows and columns.

Time Complexity: O(n * m)
Space Complexity: O(n + m) for row and col arrays
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        for(int i = 0 ; i<n; i++){
            for(int j =0; j<m; j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}