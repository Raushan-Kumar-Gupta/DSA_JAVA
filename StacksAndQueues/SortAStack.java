package StacksAndQueues;
import java.util.*;

/*Complete the function below*/
class Solution {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        sortStack(s); 
        return s;
    }
    public void sortStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.pop();
            sortStack(s);
            sortedInsert(s, x);
        }
    }
    public void sortedInsert(Stack<Integer> s, int x){
        if(s.isEmpty() || x>s.peek()){
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
}