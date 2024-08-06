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
    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rHead = reverse(slow);
        ListNode temp = head;
        ListNode headNext = null;
        ListNode rHeadNext = null;

        while(head!=null && rHead!=null){
            if(head.next == rHead) {
                break;
            }
            headNext = head.next;
            rHeadNext = rHead.next;

            head.next = rHead;
            rHead.next = headNext;

            head = headNext;
            rHead = rHeadNext;
        }
    }

    ListNode reverse(ListNode temp){
        ListNode rHead = null;
        while(temp!=null){
            ListNode tempNext = temp.next;
            temp.next = rHead;
            rHead = temp;
            temp = tempNext;
        }
        return rHead;
    }
}