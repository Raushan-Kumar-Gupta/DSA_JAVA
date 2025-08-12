package BinarySearchTrees;
import java.util.ArrayList;
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    Node pred = null;
    Node succ = null;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        findPre(root, key);
        findSuc(root, key);
        ans.add(pred);
        ans.add(succ);
        return ans;
    }
    public void findPre(Node root, int key){
        while(root!=null){
            if(root.data<key){
                pred = root;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
    }
    public void findSuc(Node root, int key){
        while(root!=null){
            if(root.data>key){
            succ= root;
            root = root.left;
            }
            else{
                root = root.right;
            }
        }
    }
}
