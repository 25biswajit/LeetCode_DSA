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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseK(head, k);
    }

    ListNode reverseK(ListNode head, int k) {
        if(head == null) return null;
        if(!isValid(head,k)) return head;
        int k_ = k;
        ListNode temp = head;
        ListNode rHead = null;
        while(temp!=null && k > 0){
            ListNode tempNext = temp.next;
            temp.next = rHead;
            rHead = temp;
            temp = tempNext;
            k--;
        }
        ListNode rHead_ = reverseK(temp, k_);
        head.next = rHead_;
        return rHead;
    }

    boolean isValid(ListNode node, int k){
        while(node!=null && k > 0){
            node = node.next;
            k--;
        }
        return k == 0;
    }
}