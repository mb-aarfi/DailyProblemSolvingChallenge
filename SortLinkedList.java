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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s = head;
        ListNode f = head;
        ListNode p = null;

        while (f != null && f.next != null) {
            p = s;
            s = s.next;
            f = f.next.next;
        }

        p.next = null;

        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(s);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode ansHead = new ListNode(-1);
        ListNode ansTail = ansHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                ansTail.next = head1;
                head1 = head1.next;
            } else {
                ansTail.next = head2;
                head2 = head2.next;
            }
            ansTail = ansTail.next;
        }

        if (head1 != null) {
            ansTail.next = head1;
        } else {
            ansTail.next = head2;
        }

        return ansHead.next;
    }
}
