package ReverseNodesWithKGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 */
public class ReverseKGroups {

    public static ListNode reverseKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr != null) {
            // Keep track of the current position
            ListNode tracker = ptr;

            // Traverse k nodes to check if there are enough nodes to reverse
            for (int i = 0; i < k; i++) {
                if (tracker == null)
                    break;
                else
                    tracker = tracker.next;
            }
            if (tracker == null) {
                break;
            }
            ListNode[] updatedNodes = ReverseLinkedList.reverseLinkedList(ptr.next, k);
            ListNode previous = updatedNodes[0];
            ListNode current = updatedNodes[1];
            ListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;

        }
        return dummy.next;
    }

    // Driver code
    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(3, 4, 5, 6, 2, 8, 7, 7),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1)
        ));

        List<Integer> k = new ArrayList<>(Arrays.asList(3, 2, 1, 7, 1));

        for (int i = 0; i < inputList.size(); ++i) {
            LinkedList inputLinkedList = new LinkedList();
            inputLinkedList.createLinkedList(inputList.get(i));

            System.out.print((i + 1) + ".\tLinked list: ");
            ReverseLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println();

            System.out.print("\n\tReversed linked list: ");
            ListNode result = reverseKGroups(inputLinkedList.head, k.get(i));
            ReverseLinkedList.printListWithForwardArrow(result);
            System.out.println();


        }
    }
}