package SearchingAndSorting;
import java.util.*;
class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long count=0;
        for(int i=0; i<n; i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                long total = arr[i]+arr[left]+arr[right];
                if(total<sum){
                    count=count+(right-left);
                    left++;
                }
                else if(total>=sum){
                    right--;
                }
                
            }
        }
        return count;
    }
}
