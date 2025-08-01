package StacksAndQueues;
import java.util.*;
class Solution {
    public boolean isValid(int[][] mat, int row, int col){
        if(row<0 || row>=mat.length || col<0 || col>=mat[0].length) return false;
        return true;
    }
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                if(mat[i][j]==2){
                    q.add(new int[]{i, j, 0});
                    vis[i][j]=true;
                }
            }
        }
        int minTime = 0;
        while(!q.isEmpty()){
            int[] remNode = q.remove();
            int cr = remNode[0];
            int cc = remNode[1];
            int ct = remNode[2];
            minTime = ct;
            int dr[] = {0, 1, 0, -1};
            int dc[] = {1, 0, -1, 0};
            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(isValid(mat, nr, nc) && mat[nr][nc]==1  && !vis[nr][nc]){
                    mat[nr][nc]=2;
                    q.add(new int[]{nr, nc, ct+1});
                    vis[nr][nc]=true;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                if(mat[i][j]==1){
                    return -1;
                }
            }
        }
        return minTime;
    }
}
