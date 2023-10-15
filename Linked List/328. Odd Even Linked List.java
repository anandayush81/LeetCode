class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode oddh=head, oddt=head, evenh=head.next, event=head.next;
        while(event!=null && event.next!=null){
            oddt.next=oddt.next.next;
            event.next=event.next.next;
            oddt=oddt.next;
            event=event.next;
        }
        oddt.next=evenh;
        return oddh;
    }
}