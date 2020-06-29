package ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkedList {

        public static ListNode reverseList(ListNode head) {
            ListNode next=head;
            ListNode current=head;
            ListNode prev=null;
            while(current!=null){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            return prev;
        }

    static void printList(ListNode list) {
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println("");
    }
        public static void main(String[] args)
        {
            ListNode list = new ListNode();
            ListNode list2 = new ListNode();

            // creating first list
            list = new ListNode(2);
            list.next = new ListNode(4);
            list.next.next = new ListNode(3);
            System.out.print("First List is ");
            printList(list);

            list2 = reverseList(list);
            printList(list2);
        }

}
