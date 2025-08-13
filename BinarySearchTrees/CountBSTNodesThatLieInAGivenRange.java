package BinarySearchTrees;

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
    int count;
    int getCount(Node root, int l, int h) {
        // Your code here
        count = 0;
        inOrder(root, l, h);
        return count;
    }
    void inOrder(Node root, int l, int h){
        if(root==null) return;
        inOrder(root.left, l, h);
        if(root.data>=l && root.data<=h){
            count++;
        }
        inOrder(root.right, l, h);
    }
}