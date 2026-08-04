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
    public ListNode rotateRight(ListNode head, int k) {
     if (head == null || head.next == null || k == 0) return head;
        int cnt=1;
        ListNode temp=head;
        while(temp.next!=null){
            cnt++;
            temp=temp.next;
        }
        //System.out.print(cnt);
        k=k%cnt;
        if(k==0)return head;
        int len=cnt-k;
        temp.next=head;
        while(len-->0){
          temp=temp.next;
        }
        head=temp.next;// head bna diya
        temp.next=null; // ab link tod ke null 
        return head;
    }
}