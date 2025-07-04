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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp1 = head;
        ListNode temp2 = head.next;

        while (temp1 != null && temp2 != null) {
            int temp = temp1.val;
            temp1.val = temp2.val;
            temp2.val = temp;

            // Move both pointers by two nodes
            temp1 = temp1.next != null ? temp1.next.next : null;
            temp2 = temp2.next != null ? temp2.next.next : null;
        }

        return head;
    }
}
