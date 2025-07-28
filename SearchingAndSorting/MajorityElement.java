package SearchingAndSorting;
import java.util.*;
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int n = arr.length;
        int candi1 = 0, candi2=0;
        int count1=0, count2=0;
        
        for(int i=0; i<n; i++){
            if(arr[i]==candi1){
                count1++;
            }
            else if(arr[i]==candi2){
                count2++;
            }
            else if(count1==0){
                candi1=arr[i];
                count1=1;
            }
            else if(count2<=0){
                candi2=arr[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for(int num : arr){
            if(num==candi1) count1++;
            else if(num==candi2) count2++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(count1>n/3) res.add(candi1);
        if(count2>n/3) res.add(candi2);
        Collections.sort(res);
        return res;
    }
}