package LinkedListAddTwoNumbers;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class LinkedListAddTwoNumbers {


    /* Adds contents of two linked lists and return the head node of resultant list */
   static ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode result = null; // res is head node of the resultant list
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;

        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new ListNode(sum);

            // if this is the first node then set it as head of
            // the resultant list
            if (result == null) {
                result = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        // return head of the resultant list
        return result;
    }
    /* Utility function to print a linked list */

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
        ListNode rs = addTwoNumbers(list, list2);
        System.out.print("Resultant List is ");
        printList(rs);
    }
}
