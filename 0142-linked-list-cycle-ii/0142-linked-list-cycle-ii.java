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

        if(head == null || head.next == null) return null;

        boolean isCycleExist = false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycleExist = true;
                break;
            }
        }

        if(isCycleExist){
            while(head != slow){
                head = head.next;
                slow = slow.next;
            }   
        }

        if(slow == head){
           return head;
        }
        
        return null;
    }
}