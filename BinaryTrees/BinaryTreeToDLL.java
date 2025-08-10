package BinaryTrees;
import java.util.ArrayList;
/*
class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
*/
class Solution {
    Node dummy = new Node(-1);
    Node prev = dummy;
    Node bToDLL(Node root) {
        // code here
        inSolve(root);
        Node head = null;
        if(dummy.right!=null){
            head = dummy.right;
            dummy.right=null;
            head.left =null;
        }
        return head;
    }
    void inSolve(Node root){
        if(root==null) return;
        inSolve(root.left);
        Node curr = new Node(root.data);
        curr.left = prev;
        prev.right = curr;
        prev = curr;
        inSolve(root.right);
    }
}