package BinarySearchTrees;


class lowestCommonAncestor {
     int val;
      lowestCommonAncestor left;
      lowestCommonAncestor right;
      lowestCommonAncestor(int x) { val = x; }
  }

class Solution {
    public lowestCommonAncestor lowestCommonAncestor(lowestCommonAncestor root, lowestCommonAncestor p, lowestCommonAncestor q) {
        while(root!=null){
            if(root.val>p.val && root.val>q.val) root = root.left;
            else if(root.val<p.val && root.val<q.val) root= root.right;
            else break;
        }
        return root;
    }
}
