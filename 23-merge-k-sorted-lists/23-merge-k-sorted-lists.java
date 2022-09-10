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
        
        if(minHeap.isEmpty()) {
            return null;
        }
        
        ListNode traverse = new ListNode(minHeap.remove());
        ListNode toReturn = traverse;
        
        while(!minHeap.isEmpty()) {
            traverse.next = new ListNode(minHeap.remove());
            traverse = traverse.next;
        }
        
        return toReturn;
        
    }
}