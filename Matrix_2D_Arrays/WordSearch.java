package Matrix_2D_Arrays;
/*
Word Search using Backtracking:

- Try to find the word starting from each cell.
- Use DFS to move in 4 directions (up, down, left, right).
- Mark visited cells with '*' to avoid reusing in the same path.
- If all letters are matched, return true.
- Backtrack by restoring the original character after the DFS call.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n ;i++){
            for(int j=0; j<m ;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board, i, j, word, 0)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, int row, int col, String word, int indx){
        if(indx==word.length()) return true;
        if(!isValid(board, row, col) || board[row][col]!=word.charAt(indx)) return false;
        char ch = board[row][col];
        board[row][col]='*';
        boolean right = search(board, row, col+1, word, indx+1);
        boolean down = search(board, row+1, col, word, indx+1);
        boolean left = search(board, row, col-1, word, indx+1);
        boolean up = search(board, row-1, col, word, indx+1);
        board[row][col]=ch;
        return right|| down || left|| up;
    }
    public boolean isValid(char[][] board, int row, int col){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length) return false;
        return true;
    }
}