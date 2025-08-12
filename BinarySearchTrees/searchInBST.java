package BinarySearchTrees;
 class searchInBST {
     int data;
      Node left;
      Node right;
      searchInBST(int x) { data = x; }
  }
class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        // Your code here
        while(root!=null){
            if(root.data==x) return true;
            else if(root.data>x) root = root.left;
            else root = root.right; 
        }
        return false;
    }
}
