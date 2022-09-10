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
        
        //Throw everything into a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode head: lists) {
            while(head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        
        //If the minHeap is empty we know that there wasn't anything to merge so return null
        if(minHeap.isEmpty()) {
            return null;
        }
        
        //Otherwise create your new list to return
        ListNode traverse = new ListNode(minHeap.remove());
        ListNode toReturn = traverse;
        
        while(!minHeap.isEmpty()) {
            traverse.next = new ListNode(minHeap.remove());
            traverse = traverse.next;
        }
        
        return toReturn;
        
    }
}