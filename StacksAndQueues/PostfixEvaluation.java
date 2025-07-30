package StacksAndQueues;
import java.util.Stack;
class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(String x : arr){
            if(x.equals("+")|| x.equals("-")|| x.equals("*") || x.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                int res =0;
                switch(x){
                    case "+":
                        res = num1+num2;
                        break;
                    case "-":
                        res = num1-num2; 
                        break;
                    case "*":
                        res = num1*num2;
                        break;
                    case "/":
                        res = num1/num2;
                        break;
                }
                st.push(res);
            }
            else{
                int val = Integer.parseInt(x);
                st.push(val);
            }
        }
        return st.peek();
    }
}
