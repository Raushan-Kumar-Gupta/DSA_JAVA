package Backtracking;

import java.util.*;

class Solution {
    static Boolean dp[][];
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int sum =0;
        for(int x: arr){
            sum+=x;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        dp = new Boolean[n][target+1];
        return solve(arr, n-1, target);
    }
    public static boolean solve(int arr[], int indx, int target){
        if(target<0 || indx<0){
            return false;
        }
        if(dp[indx][target]!=null) return dp[indx][target];
        if(target==0) return dp[indx][target]=true;
        boolean include = solve(arr, indx-1, target-arr[indx]);
        boolean exclude = solve(arr, indx-1, target);
        return dp[indx][target]= include || exclude;
    }
}
