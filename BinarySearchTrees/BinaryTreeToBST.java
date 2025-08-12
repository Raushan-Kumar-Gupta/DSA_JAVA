package BinarySearchTrees;
import java.util.*;
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} 

class Solution1 {
    // return the Kth largest element in the given BST rooted at 'root'
    public List<Integer> list=new ArrayList<>();
    public void inorder(Node node)
    {
        if(node==null) return ;
        
        inorder(node.left);
        list.add(node.data);
        inorder(node.right);
        
    }
    public int kthLargest(Node root, int k) {
        inorder(root);
        if(k>list.size()) return 0;
        return list.get(list.size()-k);
        
    }
}

class Solution2 {
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    int indx;
    Node binaryTreeToBST(Node root) {
        // Your code here
        indx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        Collections.sort(list);
        buildTree(root, list);
        return root;
    }
    void buildTree(Node root, ArrayList<Integer> list){
        if(root==null) return;
        buildTree(root.left, list);
        root.data = list.get(indx++);
        buildTree(root.right, list);
    }
    void inOrder(Node root, ArrayList<Integer> list){
        if(root==null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}