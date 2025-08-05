package Greedy;
import java.util.Arrays;
class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k) return -1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isScheme(arr, k, mid)){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isScheme(int[] arr, int k, int maxLimit){
        int student=1;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum>maxLimit){
                student++;
                sum=arr[i];
            }
            if(student>k) return false;
        }
        return true;
    }
}
