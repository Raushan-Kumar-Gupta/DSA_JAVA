package StacksAndQueues;
import java.util.*;
class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()>=arr.get(i)){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek();
            }
            else{
                ans[i]=-1;
            }
            st.push(arr.get(i));
        }
        for(int x : ans){
            res.add(x);
        }
        return res;
    }
}