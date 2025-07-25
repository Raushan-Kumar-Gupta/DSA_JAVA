package Strings;

import java.util.Stack;

/*
Checks if the given string of brackets is valid (balanced and properly nested)
- Uses Stack<Character> to track opening brackets
- stack.push(ch) adds opening brackets
- stack.peek() and stack.pop() used to match and remove valid pairs
- Returns false if mismatch or stack is empty when a closing bracket appears
- Final check: stack must be empty for the string to be valid
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch =='{' || ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                if(st.peek()=='(' && ch==')' || st.peek()=='{' && ch=='}' || st.peek()=='[' && ch==']'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
