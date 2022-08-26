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
    public ListNode reverseList(ListNode head) {
        //Iterate until the 2nd to last node
        if(head == null || head.next == null) {
           return head;
       }
        ListNode newHead = reverseList(head.next);
        
        //Literally just reversing the connection, so changing head.next the next node
        //to be the current "head"
        head.next.next = head;
        //Setting the next to be null so when we iterate back to the head, it will be
        //pointing to null
        head.next = null;
    
        return newHead;
    }
    
}

