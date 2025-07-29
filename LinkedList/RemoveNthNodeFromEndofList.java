package LinkedList;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null) {
            count++;
            temp=temp.next;
        }
        temp = head;
        for(int i=1; i<count-n; i++){
            temp = temp.next;
        } 
        if(count-n!=0){
        temp.next = temp.next.next;
        }
        else{
            head = head.next;
        }
        return head;
    }
}
