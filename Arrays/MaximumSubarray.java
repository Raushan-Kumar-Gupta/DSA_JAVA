//method 1
class Solution1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum =0;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            ans = Math.max(ans, sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}

// method 2 

class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }
    public int helper(int[] nums, int left, int right){
        if(left==right) return nums[left];
        int mid = left+(right-left)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);
        int crossSum = findCrossSum(nums, left, mid, right);
        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }
    public int findCrossSum(int[] nums, int left, int mid, int right){
        int leftMax = Integer.MIN_VALUE;
        int sum =0;
        for(int i = mid; i>=left; i--){
            sum+=nums[i];
            leftMax = Math.max(leftMax, sum);
        }   
        int rightMax = Integer.MIN_VALUE;
        sum =0;
        for(int i = mid+1; i<=right; i++){
            sum+=nums[i];
            rightMax=Math.max(rightMax, sum);
        }
        return leftMax+rightMax;
    }
}