package LinkedList;

class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

//method 1

/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        Node temp1 = head1; 
        int cnt1 = 0; 
        Node temp2 = head2;
        int cnt2 = 0;
        while(temp1!=null){
            cnt1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            cnt2++;
            temp2=temp2.next;
        }
        if(cnt1>cnt2){
            for(int i=0; i<cnt1-cnt2; i++){
                head1 = head1.next;
            }
        }
        else{
           for(int i=0; i<cnt2-cnt1; i++){
               head2=head2.next;
           } 
           
        }
        while(head1!=head2){
                head1=head1.next;
                head2=head2.next;
        }
        return head1;
    }
}

// method 2 


class Intersect2 {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        Node temp1 = head1; 
        Node temp2 = head2;
        while(temp1!=temp2){
            if(temp1.next==null){
                temp1=head2;
            }
            if(temp2.next==null){
                temp2=head1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;
    }
}
