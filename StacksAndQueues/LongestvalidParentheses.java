package StacksAndQueues;

import java.util.*;
class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || ch=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                   st.push(i);
                   continue;
                }
                ans = Math.max(ans, i-st.peek());
            }
        }
        return ans;
    }
}