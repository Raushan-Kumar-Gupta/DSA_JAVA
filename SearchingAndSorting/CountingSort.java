package SearchingAndSorting;

public class CountingSort {
    public static void countingSort(int[] arr){
        int max = getMax(arr);
        int freq[] = new int[max+1];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        int k = 0;
        for(int i=0; i<freq.length; i++){
            for(int j=0; j<freq[i]; j++){
                arr[k++] = i;
            }
        }
    }
    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
            }
    }
}
