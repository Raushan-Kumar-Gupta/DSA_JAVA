package LinkedList;


class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    Node zigZag(Node head) {
        // add code here.
        Node curr = head;
        int indx = 0;
        while(curr.next!=null){
            if(indx%2==0){
                if(curr.data>curr.next.data){
                swap(curr);
                }
                indx++;
            }
            else{
                if(curr.data<curr.next.data){
                    swap(curr);
                }
                indx++;
            }
            curr=curr.next;
        }
        return head;
    }
    void swap(Node curr){
        int temp = curr.data;
        curr.data=curr.next.data;
        curr.next.data=temp;
    }
}
