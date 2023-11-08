/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB) return headA;
        int len1=0, len2=0;
        ListNode c=headA;
        while(c!=null){
            len1++;
            c=c.next;
        }
        c=headB;
        while(c!=null){
            len2++;
            c=c.next;
        }
        if(len1>len2){
            int d=len1-len2;
            while(d>0){
                headA=headA.next;
                d--;
            }
        }
        else if(len2>len1){
            int d=len2-len1;
            while(d>0){
                headB=headB.next;
                d--;
            }

        }
        while(headA!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}