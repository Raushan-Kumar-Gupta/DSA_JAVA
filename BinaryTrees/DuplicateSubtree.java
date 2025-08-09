package BinaryTrees;
import java.util.HashMap;
import java.util.ArrayList;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Solution {
    int res;

    int dupSub(Node root) {
        res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        serialize(root, map);
        return res;
    }

    private String serialize(Node root, HashMap<String, Integer> map) {
        if (root == null) return "#";

        // serialize current subtree
        String s = root.data + "," + serialize(root.left, map) + "," + serialize(root.right, map);

        // update count
        map.put(s, map.getOrDefault(s, 0) + 1);

        // mark duplicate only if this subtree has size >= 2 (i.e., not a leaf)
        if (map.get(s) == 2 && !(root.left == null && root.right == null)) {
            res = 1;
        }

        return s;
    }
}

