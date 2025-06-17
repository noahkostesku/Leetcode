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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // Dummy node to act as the starting point
        ListNode current = dummy; // Pointer to build the merged list

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1; // Link the smaller node
                list1 = list1.next; // Move to the next node in list1
            } else {
                current.next = list2; // Link the smaller node
                list2 = list2.next; // Move to the next node in list2
            }
            current = current.next; // Move the pointer forward
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next; // The head of the merged list is the next node of the dummy
    }
}

