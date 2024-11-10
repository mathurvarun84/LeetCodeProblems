package ReverseNodesWithKGroup;

import java.util.*;
// Template for the linked list
public class LinkedList {
    public ListNode head;
    // LinkedList() will be used to make a LinkedList type object.
    public LinkedList() {
        this.head = null;
    }
    // insert_node_at_head method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(ListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // create_linked_list method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(lst.get(i));
            insertNodeAtHead(newNode);
        }
    }
}