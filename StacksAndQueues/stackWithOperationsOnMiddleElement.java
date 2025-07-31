package StacksAndQueues;
import java.util.*;


import java.util.*;

class Solution {

    // Node Structure
    static class Node {
        
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Stack strcutre
    static class myStack {
        
        Node head;
        Node mid;
        int size;
        
        myStack() {
            size = 0;
            head = null;
            mid = null;
        }
        
        void push(int data) {
            
            Node temp = new Node(data);
            if (size == 0) {
                head = temp;
                mid = temp;
                size++;
                return;
            }
            
            head.next = temp;
            temp.prev = head;
            
            // update the pointers
            head = head.next;
            if (size % 2 == 1) {
                mid = mid.next;
            }
            size++;
        }
        
        int pop() {
            
            int data = -1;
            if (size != 0) {
                Node toPop = head;
                data = toPop.data;
                if (size == 1) {
                    head = null;
                    mid = null;
                }
                else {
                    head = head.prev;
                    head.next = null;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    }
                }
                size--;
            }
            return data;
        }
        
        int findMiddle() {
            
            if (size == 0) {
                return -1;
            }
            return mid.data;
        }
        
        void deleteMiddle() {
            
            if (size != 0) {
                Node toDelete = mid;
                if (size == 1) {
                    head = null;
                    mid = null;
                }
                else if (size == 2) {
                    head = head.prev;
                    mid = mid.prev;
                    head.next = null;
                }
                else {
                    toDelete.next.prev = toDelete.prev;
                    toDelete.prev.next = toDelete.next;
                    if (size % 2 == 0) {
                        mid = mid.prev;
                    }
                    else {
                        mid = mid.next;
                    }
                }
                size--;
            }
        }
    }
    
    public static void main(String[] args) {
        myStack st = new myStack();
        st.push(1);
        st.push(2);
        System.out.print(st.findMiddle() + " ");
        st.deleteMiddle();
        System.out.print(st.pop());
    }
}