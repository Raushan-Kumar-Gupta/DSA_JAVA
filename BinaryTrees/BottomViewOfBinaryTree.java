package BinaryTrees;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
class Pair{
    Node n;
    int vl;
    Pair(Node n, int vl){
        this.n = n;
        this.vl = vl;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair remNode = q.remove();
            Node currNode = remNode.n;
            int currVl = remNode.vl;
            map.put(currVl, currNode.data);
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
