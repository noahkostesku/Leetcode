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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // Calculate the effective rotation
        k = k % length;

        if (k == 0) {
            // No rotation needed
            return head;
        }

        // Step 2: Identify the new head of the rotated linked list
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Step 3: Adjust pointers for rotation
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    
    

    }
}
