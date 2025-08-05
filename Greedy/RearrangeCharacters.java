package Greedy;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Solution {
    public static String rearrangeString(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.f-a.f);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder str = new StringBuilder();
        Pair prev = new Pair('#', 0);
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            char ch = curr.c;
            int freq = curr.f;
            str.append(ch);
            freq--;
            if(prev.f>0){
                pq.add(prev);
            }
            prev = new Pair(ch, freq);
            
        }
        return str.length()==s.length()?str.toString():"";
        
    }
}
class Pair{
    char c;
    int f;
    Pair(char c, int f){
        this.c=c;
        this.f=f;
    }
}
