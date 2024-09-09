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
        List<ListNode> ans = new ArrayList<>();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode n : lists){
            if(n!=null) pq.add(n);
        }
        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            ans.add(top);
            if(top.next!=null){
                pq.add(top.next);
            }
        }
        if(ans.isEmpty()) return null;
        ListNode res = ans.get(0), temp = ans.get(0);
        for(int i = 1; i < ans.size(); i++){
            temp.next = ans.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return res;
    }
}