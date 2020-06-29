package MergeTwoLinkedLists;


public class MergeTwoLinkedLists {
        public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
            if(l1==null){return l2;}
            else if(l2==null){return l1;}
            else{
                if(l1.val<l2.val){
                    l1.next = mergeTwoListsRecursive(l1.next,l2);
                    return l1;
                }
                else{
                    l2.next = mergeTwoListsRecursive(l1,l2.next);
                    return l2;
                }
            }
        }

    public static ListNode mergeTwoListsIterative(ListNode firstListNode, ListNode secondListNode) {
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

    static void printList(ListNode list) {
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode list2 = new ListNode();

        // creating first list
        list = new ListNode(2);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        System.out.print("First List is ");
        printList(list);

        // creating seconnd list
        list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        System.out.print("Second List is ");
        printList(list2);

        // add the two lists and see the result
        ListNode rs = mergeTwoListsIterative(list, list2);
        System.out.print("Resultant List is ");
        printList(rs);
    }

}
