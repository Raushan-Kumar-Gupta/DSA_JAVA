package Greedy;
import java.util.Arrays;
class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;
        double[][] valPwt = new double[n][3];
        
        for(int i=0; i<n; i++){
            valPwt[i][0]=(double)values[i]/weights[i];
            valPwt[i][1]=values[i];
            valPwt[i][2]=weights[i];
        }
        Arrays.sort(valPwt, (a, b)->Double.compare(b[0], a[0]));
        double maxValue = 0;
        for(double [] valwt : valPwt){
            double val = valwt[1];
            double wt = valwt[2];
            if(W-wt>0){
                maxValue+=val;
                W-=wt;
            }
            else{
                maxValue+=(val/wt)*W;
                break;
            }
        }
        return maxValue;
    }
}
