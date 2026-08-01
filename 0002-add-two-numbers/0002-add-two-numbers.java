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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1); // Tkki messy na ho easy ho aur hmesha new ListNode mey work krna ho toh best practice
        ListNode temp=dummy; // yehpoint krne ka kam karegi 
        int sum=0, carry=0;
        while(l1!=null || l2!=null || carry!=0){
            sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode newNode=new ListNode(sum%10);
            carry=sum/10;
            temp.next=newNode; // link kara 
            temp=temp.next; // isko current newNode ki postion pe move krdiya takki next ko link kr paye
        }
        return dummy.next; // -1 se jahn se ans start hora ab whn se point krdiya
    }
}