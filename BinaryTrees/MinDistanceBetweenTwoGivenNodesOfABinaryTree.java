package BinaryTrees;

class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} 

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = findLca(root, a, b);
        int d1 = distance(lca, a, 0);
        int d2 = distance(lca, b, 0);
        return d1+d2;
    }
    int distance(Node root, int a, int level){
        if(root==null) return -1;
        if(root.data==a) return level;
        int left = distance(root.left, a, level+1);
        if(left!=-1) return left;
        return distance(root.right, a, level+1);
    }
    Node findLca(Node root, int a, int b){
        if(root==null) return null;
        if(root.data==a || root.data==b) return root;
        Node left = findLca(root.left, a, b);
        Node right = findLca(root.right, a, b);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
}
