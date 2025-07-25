package Strings;
import java.util.*;
/*
Counts total palindromic subsequences using recursion + memoization (DP)
- dp[i][j] stores count of palindromic subsequences in s[i...j]
- If characters match: add 1 + count from both sides
- If not: subtract overlapping count to avoid double-counting
- Base cases: i > j → 0, i == j → 1 (single char is a palindrome)
*/  


class Solution {
    int dp[][];
    int countPS(String s) {
        // Your code here
        int n = s.length();
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return countPSHelper(s, 0, n-1);
        
    }
    int countPSHelper(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=1+countPSHelper(s, i+1, j)+countPSHelper(s, i, j-1);
        }
        else{
            return dp[i][j]=countPSHelper(s, i+1, j)+countPSHelper(s, i, j-1)-countPSHelper(s, i+1, j-1);
        }
    }
}
