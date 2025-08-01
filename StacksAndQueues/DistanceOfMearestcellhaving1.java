package StacksAndQueues;
import java.util.*;

class Solution {
    public boolean isValid(int[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length) return false;
        return true;
    }
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length; 
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i, j});
                    vis[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] remNode = q.remove();
            int cr = remNode[0];
            int cc = remNode[1];
            
            int[] dr = {0, 1, 0, -1};
            int[] dc ={1, 0, -1, 0};
            
            for(int i=0; i<4 ; i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                
                if(isValid(grid, nr, nc) && !vis[nr][nc]){
                    ans[nr][nc]=ans[cr][cc]+1;
                    q.add(new int[]{nr, nc});
                    vis[nr][nc]=true;
                }
            }
        }
        return ans;
    }
}
