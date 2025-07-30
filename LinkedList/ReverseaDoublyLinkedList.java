package LinkedList;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        DLLNode currm1 = null;
        DLLNode curr = head;
        while(curr!=null){
            DLLNode currp1= curr.next;
            curr.next = currm1;
            if(currm1!=null)
                currm1.prev = curr;
            currm1=curr;
            curr=currp1;
        }
        return currm1;
    }
}
