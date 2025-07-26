package Matrix_2D_Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int sr = 0, er = n-1; 
        int sc = 0, ec = m-1;
        while(sr<=er && sc<=ec){
            for(int j = sc; j<=ec; j++){
                ans.add(matrix[sr][j]);
            }
            sr++;
            for(int i =sr; i<=er; i++){
                ans.add(matrix[i][ec]);
            }
            ec--;
            if(sr>er || sc>ec) break;
            for(int j=ec; j>=sc; j--){
                ans.add(matrix[er][j]);
            }
            er--;
            for(int i=er; i>=sr; i--){
                ans.add(matrix[i][sc]);
            }
            sc++;
        }
        return ans;
    }
}