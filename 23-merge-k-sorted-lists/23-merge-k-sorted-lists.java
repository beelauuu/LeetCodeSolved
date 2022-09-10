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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode head: lists) {
            while(head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        
        ListNode toReturn = new ListNode(-1);
        ListNode traverse = toReturn;
        
        while(!minHeap.isEmpty()) {
            toReturn.next = new ListNode(minHeap.remove());
            toReturn = toReturn.next;
        }
        
        return traverse.next;
        
    }
}