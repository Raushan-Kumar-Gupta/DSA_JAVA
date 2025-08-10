package BinaryTrees;
import java.util.*;
class Solution {
    public List<Node> printAllDups(Node root) {
        // code here
        List<Node> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        findDuplicate(root, map, ans);
        return ans;
    }
    String findDuplicate(Node root, HashMap<String, Integer> map, List<Node> ans){
        if(root==null) return "#";
        String str = "";
        str = root.data+","+findDuplicate(root.left, map, ans)+","+findDuplicate(root.right, map, ans);
        if(map.containsKey(str) && map.get(str)==1){
            ans.add(root);
        }
        map.put(str, map.getOrDefault(str, 0)+1);
        return str;
    }
    
}
