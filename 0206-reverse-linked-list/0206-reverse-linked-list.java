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
    public ListNode reverseList(ListNode head) {
        ListNode rH = null;
        while(head != null){
            ListNode headNext = head.next;
            head.next = rH;
            rH = head;
            head = headNext;
        }
        return rH;
    }
}