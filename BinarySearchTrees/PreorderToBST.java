package BinarySearchTrees;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    // Function that constructs BST from its preorder traversal.
    int indx;
    public Node Bst(int pre[], int size) {
        // code here
        indx = 0;
        return BuildBST(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }
    public Node BuildBST(int pre[], int min, int max, int size){
        if(indx>=size) return null;
        if(pre[indx]<min || pre[indx]>max) return null;
        Node root = new Node(pre[indx]);
        indx++;
        root.left = BuildBST(pre, min, root.data-1, size);
        root.right = BuildBST(pre, root.data+1, max, size);
        return root;
    }
}
