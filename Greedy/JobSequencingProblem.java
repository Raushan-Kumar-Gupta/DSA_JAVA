package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int[][] events = new int[n][2];
        
        for(int i=0; i<n; i++){
            events[i][0]=profit[i];
            events[i][1]=deadline[i];
        }
        Arrays.sort(events, (a, b)->b[0]-a[0]);
        int max = Arrays.stream(deadline).max().getAsInt();
        int[] vis = new int[max+1];
        int maxProfit = 0;
        for(int[] event: events){
            int profit1 = event[0];
            int deadline1 = event[1];
            while(deadline1>=1){
                if(vis[deadline1]==0){
                    vis[deadline1]=1;
                    maxProfit+=profit1;
                    break;
                }
                deadline1--;
            }
        }
        int sum = Arrays.stream(vis).sum();
        ArrayList<Integer>ans =new ArrayList<>();
        ans.add(sum);
        ans.add(maxProfit); 
        return ans;
    }
}
