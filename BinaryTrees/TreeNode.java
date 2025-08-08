package BinaryTrees;

 public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solveTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode solveTree(int[] preorder, int ps, int pe, int[] inorder, int ins, int ine){
        if(ps>pe || ins>ine){
            return null;
        }
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        int indx = -1;
        for(int i=ins; i<=ine ;i++){
            if(inorder[i]==rootVal){
                indx = i;
                break;
            }
        }
        int cnt = indx-ins;

        root.left = solveTree(preorder, ps+1, ps+cnt, inorder, ins, indx-1);
        root.right = solveTree(preorder, ps+cnt+1, pe, inorder, indx+1, ine);
        return root;
    }
}
