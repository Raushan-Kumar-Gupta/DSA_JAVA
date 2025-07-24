// method 1

import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefixMax=new int[n];
        int[] suffixMax=new int[n];

        prefixMax[0]=height[0];
        for(int i=1; i<n; i++){
            prefixMax[i]=Math.max(prefixMax[i-1], height[i]);
        }
        suffixMax[n-1]=height[n-1];
        for(int i=n-2; i>=0; i--){
            suffixMax[i]=Math.max(suffixMax[i+1], height[i]);
        }

        int ans=0;
        for(int i=1; i<n; i++){
            ans+=Math.min(prefixMax[i], suffixMax[i])-height[i];
        }
        return ans;

    }
}


// method 2


class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        int ngl[] = new int[n];
        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        ngl[0]=0;
        st.push(height[0]);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && st.peek()<height[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ngl[i]=st.peek();
            }else{
                ngl[i]=0;
            }
            if(st.isEmpty() || height[i]>st.peek()){
                st.push(height[i]);
            }
        }
        while(!st.isEmpty()) st.pop();

        ngr[n-1]=0;
        st.push(height[n-1]);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && st.peek()<height[i]) st.pop();
            if(!st.isEmpty()){
                ngr[i]=st.peek();
            }
            else{
                ngr[i]=0;
            }
            if(st.isEmpty() || height[i]>st.peek()){
                st.push(height[i]);
            }
        }
        int traprain = 0;
        for(int i=0; i<n; i++){
            if(ngl[i]!=0 && ngr[i]!=0){
                int contri = Math.min(ngl[i], ngr[i])-height[i];
                traprain+=contri;
            }
        }
        return traprain;
    }
}