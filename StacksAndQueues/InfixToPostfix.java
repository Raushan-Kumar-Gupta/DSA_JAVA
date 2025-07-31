package StacksAndQueues;
import java.util.*;

class Solution {
    public static int precedence(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch =='-') return 1;
        return 0;
    }
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='^' || s.charAt(i)=='*' || s.charAt(i)=='/' || s.charAt(i)=='+' || s.charAt(i)=='-'){
                   while(!st.isEmpty() && precedence(st.peek())>=precedence(s.charAt(i))){
                       res.append(st.pop());
                   }
                    st.add(s.charAt(i));
            }
            else if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.pop());
                }
                st.pop();
            }
            else{
                res.append(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.toString();
    }
}
