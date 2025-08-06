package Strings;

import java.util.*;

/*
Groups anagrams from input array using HashMap
- Sort each string (using toCharArray() + Arrays.sort()) to form a key
- Map stores sorted string as key and list of anagrams as value
- Add string to corresponding list; create new list if key not present
- Finally, collect all anagram groups from the map
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String st : strs){
            char[] st1 = st.toCharArray();
            Arrays.sort(st1);
            String sortedStr = new String(st1);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(st);
            }
            else{
                map.get(sortedStr).add(st);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
