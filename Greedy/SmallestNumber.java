package Greedy;


class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        StringBuilder str = new StringBuilder();
        
        for(int dig = d; dig>1; dig--){
            if(s>9){
                str.insert(0, 9);
                s=s-9;
            }
            else if(dig==d || s>1){
                str.insert(0, --s);
                s=1;
            }
            else{
                str.insert(0, 0);
            }
        }
        str.insert(0, s);
        return str.length()==d?str.toString():"-1";
    }
}

