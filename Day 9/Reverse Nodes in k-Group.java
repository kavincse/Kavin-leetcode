class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(-1);
        begin = dummy;
        dummy.next = head;
        int i = 0;
        while(head != null){
            i++;
            if(i%k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else head = head.next;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode begin, ListNode end){
        ListNode first = begin.next;
        ListNode prev = begin;
        ListNode curr = prev.next;
        ListNode next;
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first.next = curr;
        begin.next = prev;
        return first;
    }
}
