package BinaryTrees;
import java.util.ArrayList;
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count;
    public int sumK(Node root, int k) {
        // code here
        count = 0;
        ArrayList<Integer> path = new ArrayList<>();
        sumSolve(root, k, path);
        return count;
    }
    private void sumSolve(Node root, int k, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        int sum = 0;
        for(int i=path.size()-1; i>=0; i--){
            sum+=path.get(i);
            if(sum==k) count++;
        }
        sumSolve(root.left, k, path);
        sumSolve(root.right, k, path);
        path.remove(path.size()-1);
        
    }
}
