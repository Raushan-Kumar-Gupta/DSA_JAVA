package BinarySearchTrees;


class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}

class Solution1 {
    public boolean isDeadEnd(searchInBST root) {
        return isBST(root, 1, Integer.MAX_VALUE);
    }
    public boolean isBST(searchInBST root, int min, int max){
        if(root==null) return false;
        if(min==max){
             return true;
        }
        return isBST(root.left, min, root.data-1) || isBST(root.right, root.data+1, max);
        
    }
}

class Solution2 {
    boolean flag;
    public boolean isDeadEnd(searchInBST root) {
        // Code here.
        flag = false;
        isBST(root, 1, Integer.MAX_VALUE);
        return flag;
    }
    public void isBST(searchInBST root, int min, int max){
        if(root==null) return;
        if(min==max){
             flag = true;
             return;
        }
        isBST(root.left, min, root.data-1);
        isBST(root.right, root.data+1, max);
    }
}