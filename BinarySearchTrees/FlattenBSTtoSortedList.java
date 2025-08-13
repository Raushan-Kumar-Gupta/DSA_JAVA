package BinarySearchTrees;

class Solution {
    Node prev;
    public Node flattenBST(Node root) {
        // Code here
        Node dummy = new Node(-1);
        prev = dummy;
        inOrder(root);
        return dummy.right;
    }
    public void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        root.left=null;
        prev.right = root;
        prev = root;
        inOrder(root.right);
    }
}

