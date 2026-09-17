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
    public ListNode removeNodes(ListNode head) {

        /*
        ------ >> Simple approach hai reverse Enigineerning type ki phele last node tak jao because last Node ko toh hmesha Include karenge
        ----- >> phir jab recursion Unwind up hoga tb check krte rahaenge ki 
        ------- >> Ki Jo Link node se bada ayega usko Link ke age jod denge 
        ----- >> if smaller hoga toh skip krdenge just
        */

        if(head==null || head.next==null){
            return head;
        }
        ListNode Link=removeNodes(head.next);
        if(head.val<Link.val){
            return Link;
        }
        head.next=Link;
        return head;
    }
}