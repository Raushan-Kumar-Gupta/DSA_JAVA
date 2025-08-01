package SearchingAndSorting;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    //lomuto partition scheme
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low-1);   // Index/window of smaller element
        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 5, 3, 5, 2, 6};
        int n = arr.length; 
        quickSort(arr, 0, n-1);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}
