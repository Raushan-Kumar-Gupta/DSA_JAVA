package SearchingAndSorting;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j= i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,5,1,7, 7, 9, 3, 5, 7};
        insertionSort(arr);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
