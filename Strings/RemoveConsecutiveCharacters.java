package Strings;

/*
Removes consecutive duplicate characters from the input string
- Uses StringBuilder to build the result efficiently
- Always appends the first character
- Iterates from index 1 and appends only if current char ≠ last appended char
- str.charAt(str.length() - 1) used to compare with last character in result
- Returns the final string with no consecutive duplicates
*/


class Solution {
    public String removeConsecutiveCharacter(String s) {
        // code here
        int n = s.length();
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        
        for(int i=1; i<n; i++){
            if(s.charAt(i)!=str.charAt(str.length()-1)){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
        
    }
}
