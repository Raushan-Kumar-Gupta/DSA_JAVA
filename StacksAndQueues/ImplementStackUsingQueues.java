package StacksAndQueues;
import java.util.*;
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        if(q.size()<1) return -1;
        for(int i=1; i<q.size(); i++){
            q.add(q.remove());
        }
        return q.remove();
    }
    
    public int top() {
        if(q.size()<1) return -1;
        for(int i=1; i<q.size(); i++){
            q.add(q.remove());
        }
        int x = q.remove();
        q.add(x);
        return x;
    }
    
    public boolean empty() {
        if(q.size()<1) return true;
        return false;
    }
}