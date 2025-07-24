class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums, int st, int end){
        while(st<=end){
            swap(nums, st, end);
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int swap_indx = -1;
        for(int i = n-1; i>=0; i--){
            if(i>0 && nums[i-1]<nums[i]){
                swap_indx = i-1;
                break;
            }
        }
        int goal_indx = -1;
        if(swap_indx!=-1){
            for(int i=n-1; i>swap_indx; i--){
                if(nums[i]>nums[swap_indx]){
                    if(goal_indx==-1){
                        goal_indx=i;
                    }
                    else if(nums[i]<nums[goal_indx]){
                        goal_indx = i;
                    }
                }
            }
            swap(nums, swap_indx, goal_indx);
            reverse(nums, swap_indx+1, n-1);
        }
        else{
            reverse(nums, 0, n-1);
        }
    }
}