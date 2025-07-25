package Strings;
/*
Longest substring without repeating chars using sliding window + HashSet
- Expand window if char is unique; update max with Math.max()
- Shrink window from left if duplicate found (remove from set)
- Return max length found
*/


import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set =new HashSet<>();
        int i=0, j=0;
        int ans =0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
