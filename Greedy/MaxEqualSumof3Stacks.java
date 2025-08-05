package Greedy;

class Solution {
    public static int maxEqualSum(int N1, int N2, int N3, int[] S1, int[] S2,
                                  int[] S3) {
        // code here
        int sum1=0, sum2=0, sum3 = 0; 
        for(int x : S1){
            sum1+=x;
        }
        for(int x : S2){
            sum2+=x;
        }
        for(int x : S3){
            sum3+=x;
        }
        int top1=0, top2=0, top3=0;
        while(top1<N1 && top2<N2 && top3<N3){
            if(sum1==sum2 && sum2==sum3) return sum1;
            if(sum1>=sum2 && sum1>=sum3){
                sum1-=S1[top1++];
            }
            else if(sum2>=sum1 && sum2>=sum3){
                sum2-=S2[top2++];
            }
            else{
                sum3-=S3[top3++];
            }
        }
        return 0;
    }
}
