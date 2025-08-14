package SearchingAndSorting;
import java.util.*;
class Solution {
    public int countRevPairs(int[] arr) {
        // code here
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
    public int mergeSort(int[] arr, int left, int right){
        if(left>=right) return 0;
        int mid = left+(right-left)/2;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid+1, right);
        int j = mid+1;
        for(int i=left; i<=mid; i++){
            while(j<=right && (long)arr[i]>2L*arr[j]) j++;
            count+=j-mid-1;
        }
        merge(arr, left, mid, right);
        return count;
        
    }
    public void merge(int[] arr, int left, int mid, int right){
        int i = left, j = mid+1, k=0;
        int[] temp =new int [right-left+1];
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]) temp[k++]=arr[i++];
            else temp[k++]=arr[j++];
        }
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=right) temp[k++]=arr[j++];
        for(i=left, k=0; i<=right; i++, k++){
            arr[i]=temp[k];
        }
    }
}
