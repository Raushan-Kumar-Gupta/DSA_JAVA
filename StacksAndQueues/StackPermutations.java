package StacksAndQueues;
import java.util.*;

class Solution {
    public boolean checkPerm(int[] a, int[] b) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n1 = a.length;
        int n2 = b.length;
        int i=0, j=0;
        while(i<n1 && j<n2){
            if(st.isEmpty() || st.peek()!=b[j]){
                st.push(a[i++]);
            }
            while(!st.isEmpty() && st.peek()==b[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}
