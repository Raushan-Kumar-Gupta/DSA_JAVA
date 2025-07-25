package Strings;

import java.util.*;

class Solution {
    int dp[][];
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j)==1){
                    count++;
                }
            }
        }
        return count;
    }
    public int isPalindrome(String s, int i , int j){
        if(i>=j) return dp[i][j]=1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=isPalindrome(s, i+1, j-1);
        }
        return dp[i][j]=0;
    }
}

