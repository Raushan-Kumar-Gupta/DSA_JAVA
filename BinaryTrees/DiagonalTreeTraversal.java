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
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            while(curr!=null){
                if(curr.left!=null){
                    q.add(curr.left);
                }
                ans.add(curr.data);
                curr=curr.right;
            }
        }
        return ans;
    }
}
