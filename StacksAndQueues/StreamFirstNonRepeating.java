package StacksAndQueues;
import java.util.*;

class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            q.add(ch);
            while(!q.isEmpty() && map.get(q.peek())>1){
                q.remove();
            }
            
            if(!q.isEmpty()){
                res.append(q.peek());
            }
            else{
                res.append("#");
            }
        }
        return res.toString();
    }
}
