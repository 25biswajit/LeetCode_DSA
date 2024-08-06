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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists){
            if(node!=null) pq.add(node);
        }
        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            if(top!=null && top.next!=null){
                pq.add(top.next);
            }
            temp.next = top;
            temp = top;
        }
        return head.next;
    }
}