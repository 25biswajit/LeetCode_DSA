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
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        while(l1!= null || l2 !=null || carry > 0){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = carry + n1 + n2;
            int dig = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(dig);
            res.next = node;
            res = node;

            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }
        ans = reverse(ans.next);
        return ans;
    }

    private ListNode reverse(ListNode node){
        ListNode rHead = null, nextNd = null;
        while(node!=null){
            nextNd = node.next;
            node.next = rHead;
            rHead = node;
            node = nextNd;
        }
        return rHead;
    }
}