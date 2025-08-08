package BinaryTrees;
import java.util.*;
class Solution {
    static int[] inArr;
    static int n, idx;
    public static int minSwaps(int[] arr) {
        // code here
        n = arr.length;
        idx = 0;
        inArr = new int[n];
        inOrder(arr, 0);
        Pair[] ans = new Pair[n];
        for(int i=0; i<n; i++){
            ans[i] = new Pair(inArr[i], i);
        }
        Arrays.sort(ans, (a, b)->a.val-b.val);
        return findMinSwap(ans);
    }
    public static int findMinSwap(Pair[] ans){
        boolean[] vis = new boolean[n];
        int minSwap = 0;
        for(int i=0; i<n; i++){
            if(vis[i]==true || ans[i].ind==i) continue;
            int j=i;
            int cycleCnt = 0;
            while(vis[j]==false){
                vis[j]=true;
                cycleCnt++;
                j = ans[j].ind;
            }
            minSwap+=cycleCnt-1;
        }
        return minSwap;
    }
    
    public static void inOrder(int[] arr, int indx){
        if(indx>=n) return;
        inOrder(arr, 2*indx+1);
        inArr[idx++]=arr[indx];
        inOrder(arr, 2*indx+2);
    }
    static class Pair{
        int val;
        int ind;
        Pair(int val, int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    
}