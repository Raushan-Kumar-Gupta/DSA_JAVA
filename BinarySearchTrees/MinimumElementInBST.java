package BinarySearchTrees;
class Node{
    int data;
    Node left; 
    Node right;
    Node(int x) { data = x; }
}
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        if(root==null) return 0;
        while(root.left!=null) root = root.left;
        return root.data;
    }
}