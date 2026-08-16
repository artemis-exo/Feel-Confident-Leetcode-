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
    public ListNode partition(ListNode head, int x) {
        ListNode Small=new ListNode(-1);
        ListNode Large=new ListNode(-1);
        ListNode SmallTemp=Small;
        ListNode LargeTemp=Large;
        while(head!=null){
            if(head.val<x){
                SmallTemp.next=head;
                SmallTemp=SmallTemp.next;
            }
            else {
                LargeTemp.next=head;
                LargeTemp=LargeTemp.next;
            }
            head=head.next;
        }
        SmallTemp.next=Large.next;
        LargeTemp.next=null;
        return Small.next;
    }
}