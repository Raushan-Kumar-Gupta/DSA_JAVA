package Strings;
import java.util.HashMap;

/*
  ✅ Checks if two strings are anagrams
  - Uses HashMap<Character, Integer> to count char frequency in first string (s)
  - Uses getOrDefault() to handle missing keys while updating counts
  - Iterates over second string (t) and decreases the count if char exists and is non-zero
  - Returns false if any char in t is not found or overused
  - Returns true only if all chars in t match the frequency in s
 */


class Solution1 {

    public boolean isAnagram(String s, String t) {
        int sn=s.length(), tn=t.length();
        if(sn!=tn) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<sn; i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            map.put(schar, map.getOrDefault(schar, 0)+1);
            map.put(tchar, map.getOrDefault(tchar, 0)-1);
        }
        for(int i:map.values()){
            if(i!=0) return false;
        }
        return true;
    }
}


class Solution2 {
    public boolean isAnagram(String s, String t) {
        int sn=s.length(), tn=t.length();
        if(sn!=tn) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<sn; i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            map.put(schar, map.getOrDefault(schar, 0)+1);
            map.put(tchar, map.getOrDefault(tchar, 0)-1);
        }
        for(int i:map.values()){
            if(i!=0) return false;
        }
        return true;
    }
}