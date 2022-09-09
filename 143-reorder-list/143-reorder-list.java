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
    public void reorderList(ListNode head) {
        
        //If the head is null or there is only one element, there's nothing to reorer.
        if(head == null || head.next == null) return;
        
        //General algorithm here is to split list in half
        //And then with the second half of the list, reverse it
        //And finally merge it all back together
        
        //Head of first half of list
        ListNode l1 = head;
        //Head of second half of list
        ListNode slow = head;
        

        ListNode fast = head;
        
        //Tail of first list (middle of list)
        ListNode prev = null;
        
        
        //Algorithm to find the middle of the list (aka the end of the first list)
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Separating the two lists
        prev.next = null;
        
        //Reversing said list
        ListNode l2 = reverse(slow);
        
        //Merging them all back into l1
        merge(l1,l2);
        
    }
    
    public ListNode reverse(ListNode head) {
        //Same algorithm as before, iterate to 2nd to last node
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        
        //Set the next of the next node to the current node
        head.next.next = head;
        //Set the head.next to null to account for the end (head) being set to null
        head.next = null;
        //Return this new head
        return newHead;
    }
    
    public void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            //Next values of l1 and l2
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            //Pointing the 1st l1 value to the 1st l2 value
            l1.next = l2;
            
            //If the next value is null we're done
            if(l1_next == null) {
                break;
            }
            
            //Set the next of the 1st l2 node to the l1_next node
            l2.next = l1_next;
            
            //Move to the next node
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}