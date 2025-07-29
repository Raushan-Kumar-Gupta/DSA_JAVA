package Backtracking;

import java.util.*;

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u1 = edge[0];
            int v1 = edge[1];
            adj.get(u1).add(v1);
            adj.get(v1).add(u1);
        }
        
        int color[] = new int[v];
        
        return dfs(adj, v, 0,color, m);
    }
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int v , int curr, int[] color, int m){
        if(curr==v) return true;
        
        for(int i=1; i<=m ; i++){
            if(isSafe(adj, v , curr, i, color, m)){
                color[curr]=i;
                if(dfs(adj, v, curr+1, color, m)){
                    return true;
                }
                color[curr]=0;
            }
        }
        return false;
    }
    boolean isSafe(ArrayList<ArrayList<Integer>> adj, int v, int curr, int currClr, int[] color, int m){
        for(int x : adj.get(curr)){
            if(color[x]==currClr) return false;
        }
        return true;
    }
}
