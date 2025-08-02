package Greedy;

import java.util.*;

class Solution {

    public static long minSum(int arr[], int n) {
        // Your code goes here
        if(n==0) return 0;
        if(n==1) return arr[0];
        Arrays.sort(arr);
        String st1 = "";
        String st2 = "";
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(flag){
                st1+=arr[i];
            }
            else{
                st2+=arr[i];
            }
            flag=!flag;
        }
        long num1 = Long.parseLong(st1);
        long num2 = Long.parseLong(st2);
        return num1 + num2;
        
    }
}
