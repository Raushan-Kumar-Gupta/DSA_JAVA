package Matrix_2D_Arrays;
import java.util.*;
import java.util.ArrayList;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();

        // Top-left to bottom-right diagonals
        for (int row = 0; row < n; row++) {
            int i = row, j = 0;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (i >= 0 && j < m) {
                diagonal.add(mat[i][j]);
                i--;
                j++;
            }
            diagonals.add(diagonal);
        }

        for (int col = 1; col < m; col++) {
            int i = n - 1, j = col;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (i >= 0 && j < m) {
                diagonal.add(mat[i][j]);
                i--;
                j++;
            }
            diagonals.add(diagonal);
        }

        ArrayList<Integer> result = new ArrayList<>();
        boolean reverse = true;
        for (ArrayList<Integer> diag : diagonals) {
            if (reverse) {
                Collections.reverse(diag);
            }
            result.addAll(diag);
            reverse = !reverse;
        }

        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
