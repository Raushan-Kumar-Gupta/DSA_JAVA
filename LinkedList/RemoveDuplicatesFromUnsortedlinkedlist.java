package LinkedList;
import java.util.HashSet;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        Node temp = head;
        HashSet<Integer> set = new HashSet<>();
        Node dummy = new Node(-1);
        Node head1 = dummy;
        while(temp!=null){
            if(!set.contains(temp.data)){
                Node newNode = new Node(temp.data);
                dummy.next = newNode;
                dummy = newNode;
            }
            set.add(temp.data);
            temp=temp.next;
        }
        return head1.next;
    }
}
