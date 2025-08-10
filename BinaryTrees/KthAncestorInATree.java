package BinaryTrees;
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}

class Solution {
    public int kthAncestor(Node root, int k, int node) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root, path, node, ans);
        int n = ans.size();
        int kth = -1;
        if(n-1-k>=0){
            kth = ans.get(n-1-k);
        }
        return kth;
    }
    void findPath(Node root, ArrayList<Integer> path, int node, ArrayList<Integer> ans){
        if(root==null) return ;
        path.add(root.data);
        if(root.data==node){
            ans.addAll(path);
            return;
        } 
        findPath(root.left, path, node, ans);
        findPath(root.right, path, node, ans);
        path.remove(path.size()-1);
    }
}