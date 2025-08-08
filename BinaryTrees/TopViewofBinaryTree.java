package BinaryTrees;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair{
        Node n;
        int vl;
        Pair(Node n, int vl){
            this.n = n;
            this.vl = vl;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair remNode = q.remove();
            Node currNode = remNode.n;
            int currVl = remNode.vl;
            if(!map.containsKey(currVl)){
                map.put(currVl, currNode.data);
            }
            if(currNode.left!=null){
                q.add(new Pair(currNode.left, currVl-1));
            }
            if(currNode.right!=null){
                q.add(new Pair(currNode.right, currVl+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
