class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[left]<=nums[mid]){
                if(nums[left]<=target & target<=nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && nums[right]>=target){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        } 
        return -1;  
    }
}