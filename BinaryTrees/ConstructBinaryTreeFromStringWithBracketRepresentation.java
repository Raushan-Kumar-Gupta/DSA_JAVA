package BinaryTrees;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    static int indx;
    public static Node treeFromString(String s) {
        // code here
        indx = 0;
        return solve(s);
    }
    public static Node solve(String s){
        if (indx < s.length() && s.charAt(indx) == ')') {
            indx++; // skip ')'
            return null;
        }
        StringBuilder str = new StringBuilder();
        while(indx<s.length() && Character.isDigit(s.charAt(indx))){
                str.append(s.charAt(indx++));
        }
        Node root = new Node(Integer.parseInt(str.toString()));
        if(indx<s.length() && s.charAt(indx)=='('){
            indx++;
            root.left = solve(s);
        }
        if(indx<s.length() && s.charAt(indx)=='('){
            indx++;
            root.right = solve(s);
        }
        if(indx<s.length() && s.charAt(indx)==')'){
            indx++;
        }
        return root;
    }
}

