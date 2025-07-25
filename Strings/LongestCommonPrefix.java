package Strings;
import java.util.Arrays;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        StringBuilder str = new StringBuilder();
        String s1 = strs[0];
        String s2 = strs[n-1];
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==s2.charAt(i)){
                str.append(s1.charAt(i));
            }
            else{
                break;
            }
        }
        return str.toString();
    }
}