package BinaryTrees;

//method 1 

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution1 {
    int ans = Integer.MIN_VALUE;
    int diameter(Node root) {
        // Your code here
        height(root);
        return ans;
    }
    int height(Node root){
        if(root==null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        ans = Math.max(ans, leftH+rightH);
        return 1+Math.max(leftH, rightH);
    }
}

//method 2

class Solution2 {
    int ans = Integer.MIN_VALUE;
    int diameter(Node root) {
        // Your code here
        height(root);
        return ans;
    }
    int height(Node root){
        if(root==null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        ans = Math.max(ans, leftH+rightH);
        return 1+Math.max(leftH, rightH);
    }
}