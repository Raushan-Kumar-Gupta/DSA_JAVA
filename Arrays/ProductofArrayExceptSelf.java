class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftProd[] = new int[n];
        int rightProd[] = new int[n];
        int ans[] = new int[n];
        leftProd[0] = nums[0];
        for(int i=1; i<n; i++){
            leftProd[i]=leftProd[i-1]*nums[i];
        } 
        rightProd[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            rightProd[i]=rightProd[i+1]*nums[i];
        } 
        for(int i=0; i<n; i++){
            int left = i-1<0?1:leftProd[i-1];
            int right = i+1>n-1?1:rightProd[i+1];
            ans[i]=left*right;
        }
    return ans;
    }

}