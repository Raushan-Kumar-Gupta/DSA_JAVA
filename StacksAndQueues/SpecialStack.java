package StacksAndQueues;
import java.util.*;

/*Complete the function(s) below*/
class Solution {
    public void push(int a, Stack<Integer> s) {
        // add code here.
        s.add(a);
    }

    public int pop(Stack<Integer> s) {
        // add code here.
        return s.pop();
    }

    public int min(Stack<Integer> s) {
        // add code here.
        int minVal = Integer.MAX_VALUE;
        while(!s.isEmpty()){
            minVal = Math.min(minVal, s.pop());
        }
        return minVal;
        
    }

    public boolean isFull(Stack<Integer> s, int n) {
        // add code here.
        return s.size()==n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        // add code here.
        return s.isEmpty();
    }
}