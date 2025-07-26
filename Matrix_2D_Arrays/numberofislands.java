package Matrix_2D_Arrays;
/*
Count Islands (DFS):

- Count connected land regions ('L') in a grid.
- Use DFS to visit all 8 directions (including diagonals).
- When an unvisited land cell is found, start DFS and mark it as visited by changing 'L' to 'W'.
- Each DFS call marks one island, so increase count.

Time Complexity: O(N * M) — each cell is visited once.
*/

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i =0; i<n; i++){
            for(int j=0; j<m ;j++){
                if(grid[i][j]=='L'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int row, int col){
        if(!isValid(grid, row, col)) return ;
        if(grid[row][col]!='L') return ;
        grid[row][col]='W';
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int i=0; i<8; i++){
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            dfs(grid, nrow, ncol);
        }
    }
    public boolean isValid(char[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) return false;
        return true;
    }
    
}