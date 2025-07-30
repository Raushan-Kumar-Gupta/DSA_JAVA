package StacksAndQueues;
import java.util.*;
class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // code here.
        Stack<Integer> st = new Stack<>();
        while(queue.size()>0){
            st.push(queue.remove());
        }
        while(!st.isEmpty()){
            queue.add(st.pop());
        }
        return queue;        
    }
}
