package Backtracking;

import java.util.HashMap;

public class CryptarithmeticPuzzle {
    public static void main(String[] args) {
            String s1 = "SEND";
            String s2 = "MORE";
            String s3 = "MONEY";
           HashMap<Character, Integer> charIntmap = new HashMap<>();
           String unique = "";
           for(int i=0; i<s1.length(); i++){
               char ch = s1.charAt(i);
               if(!charIntmap.containsKey(ch)){
                   charIntmap.put(ch, -1);
                   unique+=ch;
               }
           }
           for(int i=0; i<s2.length(); i++){
               char ch = s2.charAt(i);
               if(!charIntmap.containsKey(ch)){
                   charIntmap.put(ch, -1);
                   unique+=ch;
               }
           }
           for(int i=0; i<s3.length(); i++){
               char ch = s3.charAt(i);
               if(!charIntmap.containsKey(ch)){
                   charIntmap.put(ch, -1);
                   unique+=ch;
               }
           }
           boolean[] usedDigits = new boolean[10];
            solve(unique, 0, charIntmap, usedDigits, s1, s2, s3);
             
    public static void solve(String unique, int idx, HashMap<Character, Integer> charIntmap, boolean[] usedDigits, String s1, String s2, String s3){
        if(idx==unique.length()){
            int num1 = getNum(s1, charIntmap);
            int num2 = getNum(s2, charIntmap);
            int num3 = getNum(s3, charIntmap);
            if(num1+num2==num3){
                System.out.println(num1+" + "+num2+" = "+num3);
            }
            return;
        }
        char ch = unique.charAt(idx);
        for(int dig=0; dig<=9; dig++){
            if(!usedDigits[dig]){
                usedDigits[dig]=true;
                charIntmap.put(ch, dig);
                solve(unique, idx+1, charIntmap, usedDigits, s1, s2, s3);
                usedDigits[dig]=false;
                charIntmap.put(ch, -1);
            }
        }
    }
    public static int getNum(String s, HashMap<Character, Integer> charIntmap){
        String num = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            num+=charIntmap.get(ch);
        }
        return Integer.parseInt(num);
        
    }
}
