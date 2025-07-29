package Backtracking;

import java.util.*;

class Solution {
    // Function to find all combinations of elements
    // in array arr that sum to target.
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // add your code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combinationHelper(arr, n-1, target, list, ans);
        return ans;
    }
    public static void combinationHelper(int[] arr, int indx, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(indx<0 || target<0) return ;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[indx]);
        combinationHelper(arr, indx, target-arr[indx], list, ans);
        list.remove(list.size()-1);
        combinationHelper(arr, indx-1, target, list, ans);
    }
}
