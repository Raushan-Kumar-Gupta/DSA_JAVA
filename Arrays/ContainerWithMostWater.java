class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0; 
        int right = n-1;
        int ans = Integer.MIN_VALUE;
        while(left<right){
            int contri = Math.min(height[left], height[right])*(right-left);
            ans = Math.max(ans, contri);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return ans;
    }
}