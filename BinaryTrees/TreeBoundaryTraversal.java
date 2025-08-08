package BinaryTrees;
import java.util.*;
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeafNode(node)){
            ans.add(node.data);
        }
        addLeftBoundary(node.left, ans);
        addLeafNode(node , ans);
        addRightBoundary(node.right, ans);
        return ans;
    }
    void addLeftBoundary(Node root, ArrayList<Integer> ans){
        Node temp = root;
            while(temp!=null){
                if(!isLeafNode(temp)){
                    ans.add(temp.data);
                }
                if(temp.left!=null){
                    temp = temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
    }
    void addLeafNode(Node root, ArrayList<Integer> ans){
        if(root==null) return;
        addLeafNode(root.left, ans);
        if(isLeafNode(root)){
            ans.add(root.data);
        }
        addLeafNode(root.right, ans);
    }
    void addRightBoundary(Node root, ArrayList<Integer> ans){
        Node temp = root;
        Stack<Integer> st = new Stack<>();
        while(temp!=null){
            if(!isLeafNode(temp)) {
                st.push(temp.data);
            }
                
            if(temp.right!=null){
                temp=temp.right;
            }
            else{
                temp=temp.left;
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }
    boolean isLeafNode(Node root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
}
