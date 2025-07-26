package Matrix_2D_Arrays;

import java.util.* ; 
class Solution1
{
	public static ArrayList<ArrayList<Character>> constructMatrix(int n, int m) 
	{
		//    Write your code here.
		char[][] mat = new char[n][m];
		ArrayList<ArrayList<Character>> ans = new ArrayList<>();
		int sr = 0, sc = 0;
		int er = n-1, ec =m-1;
		boolean flag = true;
		while(sr<=er && sc<=ec){
			for(int j=sc; j<=ec; j++){
				mat[sr][j]=flag?'X':'0';
			}
			sr++;
			for(int i=sr; i<=er; i++){
				mat[i][ec]=flag?'X':'0';
			}
			ec--;
			if(sr>er || sc>ec) break;
			for(int j=ec; j>=sc; j--){
				mat[er][j]=flag?'X':'0';
			}
			er--;
			for(int i=er; i>=sr; i--){
				mat[i][sc]=flag?'X':'0';
			}
			sc++;
			flag=!flag;
		}
		for(int i=0; i<n; i++){
			ArrayList<Character> matRow = new ArrayList<>();
			for(int j=0; j<m ;j++){
				matRow.add(mat[i][j]);
			}
			ans.add(matRow);
		}
		return ans;
	}
}
