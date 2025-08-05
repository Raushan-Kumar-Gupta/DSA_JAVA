package Greedy;
import java.util.*;
// method 1


class Solution {
    
    static int maxLevel(int []boxes, int n)
    {

        Arrays.sort(boxes);
    
        int ans = 1; 
    
        
        int prev_width = boxes[0];
        int prev_count = 1;
    
        
        int curr_count = 0;
        int curr_width = 0;
        for (int i = 1; i < n; i++)
        {
            
            curr_width += boxes[i];
            curr_count += 1;
            if (curr_width > prev_width &&
                curr_count > prev_count)
            {
                
               
                prev_width = curr_width;
                prev_count = curr_count;
    
               
                curr_count = 0;
                curr_width = 0;
    
                
                ans++;
            }
        }
    
        return ans;
    }

}


// method 2

public static int getMaxHeight(int[] objects, int n) {
        int s = 0, e = n;
        int ans = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            // 1 2 3 4 5 ... mid this will be the pyramid and
            // then it takes 1+2+3+4+5+...+mid elements atleast
            int reqElements = (mid * (mid + 1)) / 2;
            if (reqElements <= n) {
                ans = mid;
                s = mid + 1;
            } else
                e = mid - 1;
        }
        return ans;
    }