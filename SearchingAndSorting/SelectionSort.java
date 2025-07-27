package SearchingAndSorting;

public class SelectionSort {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,5,1,7, 7, 2, 9};
        selectionSort(arr);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
