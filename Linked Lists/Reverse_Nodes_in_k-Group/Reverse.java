Question : https://leetcode.com/problems/reverse-nodes-in-k-group/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int x = 1;
        ListNode temp = head;
        while (temp != null && x < k) {
            temp = temp.next;
            x++;
        }
        if (temp == null) {
            return head;
        }
        ListNode nex = temp.next;
        temp.next = null;
        ListNode rev = reverse(head);
        ListNode revHead = rev;
        while (rev.next != null) {
            rev = rev.next;
        }
        rev.next = reverseKGroup(nex, k);
        return revHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}