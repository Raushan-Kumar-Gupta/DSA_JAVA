package LinkedList;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr!=null){
            ListNode currp1 = curr.next;
            curr.next=prev;
            prev= curr;
            curr =currp1;
        }
        ListNode firstList = head;
        ListNode secondList = prev;

        while(secondList.next!=null){
            ListNode firstListp1 = firstList.next;
            ListNode secondListp1 = secondList.next;

            firstList.next = secondList;
            secondList.next = firstListp1;

            firstList=firstListp1;
            secondList=secondListp1;
        }
    }
}

    