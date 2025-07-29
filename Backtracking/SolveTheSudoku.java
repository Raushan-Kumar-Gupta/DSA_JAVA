package Backtracking;

import java.util.*;

// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat, 0, 0);
    }
    public static boolean isSafe(int[][] mat, int row, int col, int dig){
        for(int j=0; j<9; j++){
            if(mat[row][j]==dig) return false;
        }
        for(int i=0; i<9; i++){
            if(mat[i][col]==dig) return false;
        }
        int nrow = row/3*3;
        int ncol = col/3*3;
        for(int i=nrow; i<=nrow+2; i++){
            for(int j=ncol; j<=ncol+2; j++){
                if(mat[i][j]==dig) return false;
            }
        }
        return true;
    }
    public static boolean solve(int[][] mat, int row, int col){
        if(row>=9){
            return true;
        }
        int nrow =row;
        int ncol =col+1;
        if(ncol>=9){
            nrow=row+1;
            ncol=0;
        }
        if(mat[row][col]!=0){
            return solve(mat, nrow, ncol);
        }
        
        for(int dig = 1; dig<=9; dig++){
            if(isSafe(mat, row, col, dig)){
                mat[row][col]=dig;
                if(solve(mat, nrow, ncol))return true;
            }
            mat[row][col]=0;
        }
        return false;
    }
}
