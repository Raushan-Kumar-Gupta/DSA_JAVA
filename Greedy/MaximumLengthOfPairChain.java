package Greedy;
import java.util.Arrays;

class Solution {
    int dp[][];
    int n;
    public int findLongestChain(int[][] pairs) {
        n= pairs.length;
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        Arrays.sort(pairs, (a, b)->a[0]-b[0]);
        return longestChain(pairs, 0, -1);
    }
    public int longestChain(int[][] pairs, int indx, int prevIndx){
        if(indx>=n) return 0;
        if(dp[indx][prevIndx+1]!=-1) return dp[indx][prevIndx+1];
        int include = 0;
        if(prevIndx==-1 || pairs[indx][0]>pairs[prevIndx][1]){
            include = 1+longestChain(pairs, indx+1, indx);
        }
        int exclude = longestChain(pairs, indx+1, prevIndx);
        return    dp[indx][prevIndx+1] = Math.max(include, exclude);
    }
}
