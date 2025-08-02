package Greedy;
import java.util.Arrays;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int events[][] = new int[n][2];
        for(int i=0; i<n; i++){
            events[i][0]=start[i];
            events[i][1]=finish[i];
        }
        Arrays.sort(events, (a, b)->a[1]-b[1]);
        int maxAct = 0;
        int endTime = -1;
        for(int[] event: events){
            if(event[0]>endTime){
                maxAct++;
                endTime=event[1];
            }
        }
        return maxAct;
    }
}

