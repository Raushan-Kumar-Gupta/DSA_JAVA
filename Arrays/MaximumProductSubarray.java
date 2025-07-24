class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prod1 = 1;
        int ans1 = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            prod1*=nums[i];
            ans1 = Math.max(ans1, prod1);
            if(prod1==0) prod1 = 1;
        }
        int prod2 = 1;
        int ans2 = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            prod2*=nums[i];
            ans2 = Math.max(ans2, prod2);
            if(prod2==0) prod2 = 1;
        }
        return Math.max(ans1, ans2);
    }
}