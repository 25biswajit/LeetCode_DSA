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
    public ListNode reverseKGroup(ListNode node, int k){
        if(node == null) return null;
        ListNode reverseHead = null, nextNode = null, head = node;
        int k_ = k;
        if(!isValidLength(node, k)) return node; 
        while(node!=null && k > 0){
            nextNode = node.next;
            node.next = reverseHead;
            reverseHead = node;
            node = nextNode;
            k--;
        }
        ListNode tail = reverseKGroup(node, k_);
        head.next = tail;
        return reverseHead;
    }

    private boolean isValidLength(ListNode node, int k){
        ListNode temp = node;
        int size = 0;
        while(temp!=null && size <= k){
            temp = temp.next;
            size++;
        }
        return size >= k;
    }
}