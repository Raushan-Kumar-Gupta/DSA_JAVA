package StacksAndQueues;

import java.util.*;

//brute force approach

class Solution {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int n = gas.length;
        for(int i=0; i<n; i++){
            if(gas[i]<cost[i]) continue;
            int j = (i+1) % n;
            int totalgas = gas[i]-cost[i]+gas[j];
            while(i!=j){
                if(cost[j]>totalgas) break;
                totalgas += -cost[j];
                j = (j+1) % n;
                totalgas+=gas[j];
            }
            if(i==j) return i;
        }
        return -1;
    }
}


class Solution2 {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        int totalgas = Arrays.stream(gas).sum();
        int totalcost = Arrays.stream(cost).sum();
        
        if(totalgas<totalcost) return -1;
        
        int res = 0;
        int total = 0;
        int n = gas.length;
        for(int i=0; i<n ;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                res = i+1;
            }
        }
        return res;
    }
}