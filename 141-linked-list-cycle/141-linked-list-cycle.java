/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Check for null at first
        if(head==null)
            return false;
        
        //Algorithm called tortoise & hare
        ListNode slow=head;
        ListNode fast=head;
        
        //If we touch null or the next value being null, we know there's no cycle
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            //Eventually slow and fast will meet if there is
            if(slow == fast) {
                return true;
            }
        }
        return false;
}
}