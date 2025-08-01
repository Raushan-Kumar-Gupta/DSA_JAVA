package StacksAndQueues;
import java.util.*;
class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size()>1){
            int i = st.pop();
            int j = st.pop();
            if(mat[i][j]==1){
                st.push(j);
            }
            else{
                st.push(i);
            }
        }
        int celeb = st.pop();
        
        for(int i=0; i<n ;i++){
            if(celeb!=i){
                if(mat[celeb][i]==1 || mat[i][celeb]==0){
                    return -1;
                }
            }
        }
        return celeb;
        
    }
}
