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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while(l1!=null || l2!=null || rem != 0){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = rem + n1 + n2;
            rem = sum / 10;
            ListNode ans = new ListNode( sum % 10);
            temp.next = ans;
            temp = ans;
            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }
        
        return head.next;
    }
}