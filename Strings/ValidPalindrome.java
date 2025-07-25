package Strings;

/*
  ✅ Checks if a given string is a valid palindrome
  - Uses Character.isLetterOrDigit() to filter only letters and digits
  - Uses Character.toLowerCase() to make the comparison case-insensitive
  - StringBuilder is used to build the cleaned string efficiently
  - Two-pointer approach is applied on the cleaned string to check for palindrome
  - Returns true if characters match from both ends (s.charAt(i) == s.charAt(j))
 */


 class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.toLowerCase(ch));
            }
        }
        return isPalindromeH(str.toString());
    }
    public boolean isPalindromeH(String s){
        int i=0; int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}

