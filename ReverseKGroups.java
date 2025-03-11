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

    public int len(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int N = len(head);
        int grp = N / k;
        ListNode prevhead = null;
        ListNode currhead = head;
        ListNode ansNode = null;

        for(int i = 0; i<grp; i++) {
            ListNode prev = null;
            ListNode curr = currhead;
            ListNode nextNode = null;

            for(int j=0; j<k; j++) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if(ansNode == null) {
                ansNode = prev;
            } else {
                prevhead.next = prev;
            }

            prevhead = currhead;
            currhead = curr;
        }

        if(prevhead != null){
            prevhead.next = currhead;
        }
    return ansNode;
    }
}
