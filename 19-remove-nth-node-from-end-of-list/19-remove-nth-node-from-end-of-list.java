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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //If head is null or there's only one element to remove we can just remove it
        if(head == null) {
            return null;
        }
        
        if(head.next == null && n == 1) {
            return null;
        }
        
        
        ListNode toReturn = head;
        ListNode traverse = head;
        int size = 0;
        
        //Traverse the list to get the size
        while (traverse != null) {
            size++;
            traverse = traverse.next;
        }
        
        //Edge case with the head, if the size == n, then just return the next element.
        if(size == n) {
            toReturn = head.next;
            return toReturn;
        }
        
        
        int position = size-n;
        ListNode previous = null;
        ListNode header = head;
        
        for(int i = 0; i < position; i++) {
            previous = header;
            header = header.next;
        }
        
        previous.next = header.next;
        return toReturn;
    }
}