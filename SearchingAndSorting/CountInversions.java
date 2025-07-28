package SearchingAndSorting;
import java.util.*;
class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
        
    }
    static int mergeSort(int arr[], int low, int high){
        int count=0;
        if(low<high){
            int mid = low+(high-low)/2;
            count+=mergeSort(arr, low, mid);
            count+=mergeSort(arr, mid+1, high);
            count+=merge(arr, low, mid, high);
        }
        return count;
    }
    static int merge(int arr[], int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int a[] = new int[n1];
        int b[] = new int[n2];
        int count =0;
        for(int i=0; i<n1; i++){
            a[i]=arr[low+i];
        }
        for(int j=0; j<n2; j++){
            b[j]=arr[mid+1+j];
        }
        int i=0, j=0, k=low;
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                arr[k]=a[i];
                i++; k++;
            }
            else{
                arr[k]=b[j];
                count+=(n1-i);
                j++; k++;
            }
        }
        while(i<n1){
            arr[k++]=a[i++];
        }
         while(j<n2){
            arr[k++]=b[j++];
        }
        return count;
    }
}

