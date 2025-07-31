package StacksAndQueues;
import java.util.*;

class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==')'){
                int count = 0;
                while(st.peek()!='('){
                    st.pop();
                    count++;
                }
                if(st.peek()=='(') st.pop();
                if(count<=1) return 1; 
            }
            else{
                st.push(ch);
            }
        }
        return 0;
    }
}

