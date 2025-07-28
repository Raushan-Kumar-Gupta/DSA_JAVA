package SearchingAndSorting;
import java.util.*;
class Solution {
    int dp[];
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return sticklerThief(arr, n-1);
    }
    public int sticklerThief(int arr[], int indx){
        if(indx<0) return 0;
        if(dp[indx]!=-1) return dp[indx];
        if(indx==0) return arr[0];
        int pick = arr[indx]+sticklerThief(arr, indx-2);
        int notpick = sticklerThief(arr, indx-1);
        
        return dp[indx]=Math.max(pick, notpick);
    }
}