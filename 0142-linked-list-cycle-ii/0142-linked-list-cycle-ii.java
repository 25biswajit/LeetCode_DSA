/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean isCycle = false;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) return null;
        
        slow = head;
        while(fast!=null && slow!=fast){
            slow = slow.next;
            fast = fast.next;

        }

        return slow;
    }
}