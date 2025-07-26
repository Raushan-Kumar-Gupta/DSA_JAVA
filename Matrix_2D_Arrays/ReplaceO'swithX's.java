package Matrix_2D_Arrays;

/*
Replace all surrounded 'O' regions with 'X' (Boundary DFS approach):

- Idea: 'O's connected to the border should NOT be flipped to 'X'.
- Step 1: Run DFS from all 'O's on the boundary and mark them as 'Y' (safe zone).
- Step 2: Traverse the whole matrix:
    - Convert remaining 'O's (surrounded) to 'X'.
    - Convert 'Y's back to 'O'.

- DFS explores 4 directions (up, right, down, left) to mark connected 'O's.

Time Complexity: O(N * M)
Space Complexity: O(1) extra (excluding recursion stack)
*/


class Solution {
    static char[][] fill(char mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        for(int j=0; j<m; j++){
            if(mat[0][j]=='O'){
                dfs(mat, 0, j);
            }
            if(mat[n-1][j]=='O'){
                dfs(mat, n-1, j);
            }
        }
        for(int i=0; i<n; i++){
            if(mat[i][0]=='O'){
                dfs(mat, i, 0);
            }
            if(mat[i][m-1]=='O'){
                dfs(mat, i, m-1);
            }
        }
        for(int i=0; i<n ;i++){
            for(int j=0; j<m ;j++){
                if(mat[i][j]=='Y'){
                    mat[i][j]='O';
                }
                else if(mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }
    public static void dfs(char mat[][], int row, int col){
        if(!isValid(mat, row, col)) return ;
        if(mat[row][col]!='O') return ;
        mat[row][col]='Y';
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for(int i=0; i<4 ;i++){
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            dfs(mat, nrow, ncol);
        }
    }
    public static boolean isValid(char mat[][], int row, int col){
        int n = mat.length;
        int m = mat[0].length;
        if(row<0 || row>=n || col<0 || col>=m ) return false;
        return true;
    }
}