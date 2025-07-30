package LinkedList;

class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
class Solution {
    Node compute(Node head) {
        // your code here
        Node temp = head;
        Node revNode = reverse(temp);
        int max = revNode.data;
        Node curr = revNode;
        while(curr.next!=null){
            if(curr.next.data<max){
                curr.next = curr.next.next;
            }
            else{
                max = curr.next.data;
                curr=curr.next;
            }
        }
        Node ans = reverse(revNode);
        return ans;
    }
    Node reverse(Node temp){
        Node prev = null;
        Node curr = temp;
        while(curr!=null){
            Node currp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr=currp1;
        }
        return prev;
    }
}
