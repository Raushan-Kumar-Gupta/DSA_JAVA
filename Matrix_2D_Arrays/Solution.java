package Matrix_2D_Arrays;

public class Solution {
    public void reverse(int[] mat){
        int n = mat.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int temp= mat[left];
            mat[left]=mat[right];
            mat[right]=temp;
            left++; right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i =0; i<n ; i++){
            for(int j =0; j<m ;j++){
                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        for(int i=0; i<n; i++){
            reverse(matrix[i]);
        }
    }
} 
    

