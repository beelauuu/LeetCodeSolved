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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //For sending in the fully merged LinkedList
        ListNode dummyHead = new ListNode(0);
        ListNode remover = dummyHead;
        
        
        //Looping through both lists at first, checking to see which value from which\
        //list to retrieve
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                ListNode toAdd = new ListNode(list2.val);
                dummyHead.next = toAdd;
                list2 = list2.next;
                dummyHead = dummyHead.next;
            }
            else if(list1.val < list2.val) {
                ListNode toAdd = new ListNode(list1.val);
                dummyHead.next = toAdd;
                list1 = list1.next;
                dummyHead = dummyHead.next;
            }
            else {
                ListNode toAddOne = new ListNode(list1.val);
                ListNode toAddTwo = new ListNode(list2.val);
                list1 = list1.next;
                list2 = list2.next;
                dummyHead.next = toAddOne;
                dummyHead = dummyHead.next;
                dummyHead.next = toAddTwo;
                dummyHead = dummyHead.next;
            }
        }
        
        //If list1 is longer, add in everything else from list1
        while(list1 != null) {
            ListNode toAddOne = new ListNode(list1.val);
            dummyHead.next = toAddOne;
            list1 = list1.next;
            dummyHead = dummyHead.next;
        }
        
        //If list2 is longer, add in everything from list2
        while(list2 != null) {
           ListNode toAddOne = new ListNode(list2.val);
            dummyHead.next = toAddOne;
            list2 = list2.next;
            dummyHead = dummyHead.next;
        }
        
        //Return dummyhead.next
        return remover.next;
    }
}