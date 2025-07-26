package Matrix_2D_Arrays;
import java.util.*;

class Solution
{
    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
        // Write your code here.
        int n = mat.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            HashSet<Integer> rowSet = new HashSet<>(mat.get(i));
            for(int val : rowSet){
                map.put(val, map.getOrDefault(val, 0)+1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){ 
            if(map.get(key)==n){
                ans.add(key);
            }
        }
        return ans;
    }
}
