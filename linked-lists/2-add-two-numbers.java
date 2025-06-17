/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //dummy to not deal with inserting
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int carry = 0;
        //while either l1 or l2 has a digit
        // || carry != 0 to deal with case where we have a carry of 1 with no new nodes
        while (l1 != null || l2 != null || carry != 0) {
            //one could be null so get the digit
            //if one of them is null set it to zero else the value it represents
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            //have a carry to maintain calculate new value
            int val = v1 + v2 + carry;
            //might have new carry
            carry = val / 10;
            //value could be > 10 so mod
            val = val % 10;
            //next node has val of new calculated value
            cur.next = new ListNode(val);

            cur = cur.next;
            //update pointers if they are non null else leave them as null
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }
}


