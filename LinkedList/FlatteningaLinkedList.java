package LinkedList;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;
        Node mergeRoot = flatten(root.next);
        return merge(root, mergeRoot);
    }
    Node merge(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node res = dummy;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                dummy.bottom = list1;
                list1=list1.bottom;
                dummy = dummy.bottom;
            }
            else{
                dummy.bottom = list2;
                list2=list2.bottom;
                dummy=dummy.bottom;
            }
        }
        if(list1!=null){
            dummy.bottom=list1;
        }
        if(list2!=null){
            dummy.bottom=list2;
        }
        return res.bottom;
    }
}
