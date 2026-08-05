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
        if(head==null || head.next==null)return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }  // Middle nikal liya
        ListNode second=slow.next;
        slow.next=null; // middle se alag kar diya
        ListNode prev=null;
        while(second!=null){ // second half ko reverse
            ListNode nextNode=second.next;
            second.next=prev;
            prev=second;
            second=nextNode;
        }
        second=prev;
        ListNode first=head;
        while(second!=null){ // fir merge krdiya
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }
      
    }
}