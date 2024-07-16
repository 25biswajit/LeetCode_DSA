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

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // even length
        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode temp){
        ListNode rH = null;
        ListNode nH = null;

        while(temp != null){
            nH = temp.next;
            temp.next = rH;
            rH = temp;
            temp = nH;
        }
        return rH;
    }
}