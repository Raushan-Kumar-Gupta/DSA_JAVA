package LinkedList;


class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    Node divide(Node head) {
        // code here
        Node odd = new Node(-1);
        Node even = new Node(-1);
        Node oddp1 = odd;
        Node evenp1 = even;
        Node curr = head;
        while(curr!=null){
            if(curr.data%2==0){
                even.next = curr;
                even = even.next;
            }
            else{
                odd.next = curr;
                odd = odd.next;
            }
            curr=curr.next;
        }
        even.next = oddp1.next;
        odd.next = null; 
        return evenp1.next;
    }
}
