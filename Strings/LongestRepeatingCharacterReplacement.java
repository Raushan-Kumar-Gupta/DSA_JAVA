package Strings;


import java.util.HashMap;

/*
Finds longest substring where at most k chars can be replaced to make all chars same
- Uses sliding window with HashMap to track char frequencies
- maxFreq stores highest freq char in window
- Shrink window if replacements needed > k
- Update max length (ans) after each step
*/


class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxFreq = 0; 
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i =0, j=0;
        while(j<n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));
            while((j-i+1)-maxFreq>k){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}