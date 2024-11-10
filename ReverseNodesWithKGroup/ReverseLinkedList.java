package ReverseNodesWithKGroup;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode next = head;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static ListNode[] reverseLinkedList(ListNode node, int k){

        ListNode previous = null;
        ListNode current = node;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            // temporarily store the next node
            next = current.next;
            // reverse the current node
            current.next = previous;
            // before we move to the next node, point previous to the
            // current node
            previous = current;
            // move to the next node
            current = next;
        }


        return new ListNode[]{previous, current};
    }

    static void printListWithForwardArrow(ListNode head)
    {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }
}