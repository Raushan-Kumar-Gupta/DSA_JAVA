class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[right]>=nums[mid]){
                ans = Math.min(ans, nums[mid]);
                right = mid-1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                left = mid+1;
            }
        }
        return ans;
    }
}