package Backtracking;

import java.util.*;
class Solution {
    static int max;
    public static int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd,
                                  int yd) {
        // code here
        max = -1;
        helper(mat, xs, ys, xd, yd, 0);
        return max;
    }
    public static void helper(int[][] mat, int xs, int ys, int xd, int yd, int sum){
        if(!isValid(mat, xs, ys)) return;
        if(mat[xs][ys]==0) return;
        if(xs==xd && ys==yd){
            max = Math.max(max, sum);
            return;
        }
        
        mat[xs][ys]=0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for(int i=0; i<4; i++){
            int nxs = xs+dr[i];
            int nys = ys+dc[i];
            helper(mat, nxs , nys, xd, yd, sum+1);
        }
        mat[xs][ys]=1;
        
    }
    public static boolean isValid(int[][] mat, int row, int col){
        if(row<0 || row>=mat.length || col<0 || col>=mat[0].length) return false;
        return true;
    }
}

