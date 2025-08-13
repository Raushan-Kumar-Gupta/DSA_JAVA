package BinarySearchTrees;

class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
class Solution {
    Node temp = null;
    public void populateNext(Node root) {
        temp = null; // reset before each call to avoid stale data
        helper(root);
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.right);
        root.next = temp; // will be null for the rightmost node
        temp = root;
        helper(root.left);
    }
}

