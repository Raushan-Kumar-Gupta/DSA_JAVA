package Greedy;
import java.util.*;

class Solution {
    String minSum(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr){
            pq.add(x);
        }
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        while(!pq.isEmpty()){
            num1.append(pq.remove());
            if(!pq.isEmpty()){
                num2.append(pq.remove());
            }
        }
        String ans = addNum(num1.toString(), num2.toString());
        int i=0; 
        while(i<ans.length()-1 && ans.charAt(i)=='0'){
            i++;
        }
        ans = ans.substring(i);
        return ans;
    }
    private String addNum(String num1, String num2){
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int n1 = i>=0?num1.charAt(i--)-'0':0;
            int n2 = j>=0?num2.charAt(j--)-'0':0;
            int sum = n1+n2+carry;
            res.insert(0, sum%10);
            carry = sum/10;
        }
        return res.toString();
    }
}
