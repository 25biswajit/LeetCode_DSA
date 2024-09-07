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

    ListNode reverseK(ListNode head, int k){
        int k_ = k;
        //base cond
        if(head == null || !isValid(head, k)) return head;

        ListNode temp = head, rHead = null, tmpNxt = null;
        while(temp!=null && k > 0){
            tmpNxt = temp.next;
            temp.next = rHead;
            rHead = temp;
            temp = tmpNxt;
            k--;
        }
        ListNode rHead_ = reverseK(temp, k_);
        head.next = rHead_;

        return rHead;
    }

    boolean isValid(ListNode head, int k){
        while(head!=null && k > 0){
            head = head.next;
            k--;
        }
        return k == 0;
    }
}