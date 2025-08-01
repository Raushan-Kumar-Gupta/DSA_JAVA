package LinkedList;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}
 
class Solution {
  
  	// Sort a linked list of 0s, 1s and 2s 
	// by changing pointers
    static Node sortList(Node head) {
        if (head == null || head.next == null) 
            return head; 

        // Create three dummy nodes to point to beginning of 
        // three linked lists. These dummy nodes are created to 
        // avoid null checks. 
        Node zeroD = new Node(0); 
        Node oneD = new Node(0); 
        Node twoD = new Node(0);

        // Initialize current pointers for three 
        // lists 
        Node zero = zeroD, one = oneD, two = twoD; 

        // Traverse list 
        Node curr = head; 
        while (curr != null) { 
            if (curr.data == 0) { 
              	
                // If the data of current node is 0, 
                // append it to pointer zero and update zero
                zero.next = curr; 
                zero = zero.next; 
            } 
            else if (curr.data == 1) { 
              	
                // If the data of current node is 1, 
                // append it to pointer one and update one
                one.next = curr; 
                one = one.next; 
            } 
            else { 
              	
                // If the data of current node is 2, 
                // append it to pointer two and update two
                two.next = curr; 
                two = two.next; 
            } 
            curr = curr.next; 
        } 

        // Combine the three lists
        zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next); 
        one.next = twoD.next; 
        two.next = null; 
          
        // Updated head 
        head = zeroD.next; 

        return head; 
    } 

    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }
  
  	public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 1 -> 1 -> 2 -> 1 -> 0 -> NULL 
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.print("Linked List before Sorting:");
        printList(head);

        head = sortList(head);

        System.out.print("Linked List after Sorting:");
        printList(head);
    }
}