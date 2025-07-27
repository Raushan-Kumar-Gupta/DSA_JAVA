package SearchingAndSorting;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int a[] = new int[n1];
        int b[] = new int[n2];
        for(int i=0; i<n1; i++){
            a[i]=arr[low+i];
        }
        for(int j=0; j<n2; j++){
            b[j]=arr[mid+1+j];
        }
        int i=0, j=0, k=low; 
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                arr[k++]=a[i++];
            }
            else{
                arr[k++]=b[j++];
            }
        }
        while(i<n1){
            arr[k++]=a[i++];
        }
        while(j<n2){
            arr[k++]=b[j++];
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 5, 1, 7, 7, 2, 9};
        mergeSort(arr, 0, arr.length - 1);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
