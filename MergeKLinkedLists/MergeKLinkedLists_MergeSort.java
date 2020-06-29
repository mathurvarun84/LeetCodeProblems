package MergeKLinkedLists;


// Java program to merge k sorted LinkedLists of size n each
public class MergeKLinkedLists_MergeSort {


    /* Takes two lists sorted in increasing order, and merge
    their nodes together to make one big sorted list.*/
    public static ListNode SortedMerge(ListNode firstListNode, ListNode secondListNode) {
        ListNode current = new ListNode(0);
        ListNode head = current;
        while (firstListNode != null && secondListNode != null) {
            if (firstListNode.val <= secondListNode.val) {
                current.next = firstListNode;
                firstListNode = firstListNode.next;
            } else {
                current.next = secondListNode;
                secondListNode = secondListNode.next;
            }
            current = current.next;
        }

        if (firstListNode == null)
            current.next = secondListNode;

        if (secondListNode == null)
            current.next = firstListNode;

        return head.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        //edge case []
        if (lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }

    public static ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        // start will always be less than or equal to end
        int mid = (start + end) / 2;
        ListNode l1 = partition(lists, start, mid);
        ListNode l2 = partition(lists, mid + 1, end);
        return SortedMerge(l1, l2);
    }

    /* Function to print nodes in a given linked list */
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println(" ");
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        printList(arr[0]);
        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);
        printList(arr[1]);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);
        printList(arr[2]);
        // Merge all lists
        ListNode head = mergeKLists(arr);
        printList(head);
    }
}



