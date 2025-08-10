package BinaryTrees;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder str;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        str = new StringBuilder();
        treeToString(root, str);
        return str.toString();
    }
    public void treeToString(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("#_");
            return;
        }
        str.append(root.val+"_");
        treeToString(root.left, str);
        treeToString(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("_");
        return stringToTree(arr);
    }
    int i=0;
    public TreeNode stringToTree(String[] arr){
        if(arr[i].equals("#")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left = stringToTree(arr);
        root.right= stringToTree(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
