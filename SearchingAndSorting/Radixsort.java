package SearchingAndSorting;

public class Radixsort {
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void countingSort(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Assuming digits are 0-9
        for(int i=0; i<n; i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i=1;i<10; i++){
            count[i]+=count[i-1];
        }
        for(int i=n-1; i>=0; i--){
            int indx = (arr[i]/exp)%10;
            output[count[indx]-1]= arr[i];
            count[indx]--;
        }
        for(int i=0; i<n ; i++){
            arr[i]=output[i];
        }
    }
    public static void radixSort(int[] arr){
        int max = findMax(arr);
        for(int exp =1; max/exp>0; exp*=10){
            countingSort(arr, exp);
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
