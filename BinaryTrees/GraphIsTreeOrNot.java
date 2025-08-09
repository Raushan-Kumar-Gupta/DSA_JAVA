package BinaryTrees;
import java.util.Arrays;
import java.util.ArrayList;

// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edgesInput) {
        // Tree must have exactly n - 1 edges
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            edges.add(new ArrayList<>());
        }
        for(ArrayList<Integer> arr : edgesInput){
            int u = arr.get(0);
            int v = arr.get(1);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        if (m != n - 1) return false;

        boolean[] vis = new boolean[n];
        
        // Start DFS from node 0
        if (hasCycle(edges, 0, vis, -1)) return false;
        
        // Check if all nodes are visited (graph is connected)
        for (boolean v : vis) {
            if (!v) return false;
        }
        
        return true;
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> edges, int node, boolean[] vis, int parent) {
        vis[node] = true;
        
        for (int neigh : edges.get(node)) {
            if (!vis[neigh]) {
                if (hasCycle(edges, neigh, vis, node)) return true;
            }
            // Found a back edge → cycle
            else if (neigh != parent) {
                return true;
            }
        }
        return false;
    }
}

