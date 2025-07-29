package Backtracking;
import java.util.*;

class Solution {
    int N ;
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        N = n;
        res = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0);
        return res;
    }
    public void save(int[][] board){
        ArrayList<Integer> rowAns = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N ;j++){
                if(board[i][j]==1){
                    rowAns.add(j+1);
                }
            }
        }
        res.add(rowAns);
    }
    public void solve(int[][] board, int row){
        if(row==N){
            save(board);
        }
        for(int col = 0; col<N; col++){
            if(isSafe(board, row, col)){
                board[row][col]=1;
                solve(board, row+1);
                board[row][col]=0;
            }
        }
    }
    public boolean isSafe(int[][] board, int row, int col){
        for(int i=row-1; i>=0; i--){
            if(board[i][col]==1) return false;
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row-1, j=col+1; i>=0 && j<N; i--, j++){
            if(board[i][j]==1) return false;
        }
        return true;
    }
}
