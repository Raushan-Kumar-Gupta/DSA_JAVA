package Greedy;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int coins[] ={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n = coins.length;
        int i=n-1;
        while(N>0){
            if(coins[i]<=N){
                ans.add(coins[i]);
                N-=coins[i];
            }
            else{
                i--;
            }
        }
        return ans;
        
    }
}