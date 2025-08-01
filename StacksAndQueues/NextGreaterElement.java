package StacksAndQueues;
import java.util.*;


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i=n-1; i>=0; i--){
                while(!st.isEmpty() && st.peek()<=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    nge[i]=-1;
                    st.push(arr[i]);
                }
                else{
                    nge[i]=st.peek();
                    st.push(arr[i]);
                }
        }
        ArrayList<Integer> list = new ArrayList();
        for(int x: nge){
            list.add(x);
        }
        return list; 
    }
}
