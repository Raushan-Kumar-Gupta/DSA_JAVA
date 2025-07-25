package Strings;
import java.util.*;
/*
Finds longest palindromic substring using DP and memoization
- dp[i][j] stores if s[i...j] is a palindrome (1) or not (0)
- Check all substrings (i to j), update max length and start index if palindrome
- isPalindrome() uses recursion with memoization to avoid recomputation
- Returns substring from start to start + maxLen
*/

class Solution {
    int dp[][];
    public String longestPalindrome(String s) {
        int start =0, maxLen =0;
        int n =s.length();
        dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        for(int i=0;i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j)==1){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
    public int isPalindrome(String s, int i, int j){
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
           return dp[i][j]=isPalindrome(s, i+1, j-1);
        }
        return dp[i][j]=0;
    }
}
