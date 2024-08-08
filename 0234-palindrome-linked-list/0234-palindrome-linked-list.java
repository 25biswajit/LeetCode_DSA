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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){ // even
            slow = slow.next;
        }
        ListNode rHead = reverse(slow);
        while(rHead != null){
            if(head.val == rHead.val){
                head = head.next;
                rHead = rHead.next;
            }else{
                return false;
            }
        }
        return true;
    }

    ListNode reverse(ListNode node){
        ListNode rHead = null, next = null;
        while(node != null){
            next = node.next;
            node.next = rHead;
            rHead = node;
            node = next;
        }
        return rHead;
    }
}