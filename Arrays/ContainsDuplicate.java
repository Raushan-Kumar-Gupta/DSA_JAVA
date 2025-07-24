import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        if(set.size()<nums.length) return true;
        return false;
    }
}