public class RemoveNthNodeFromEndOfList {
        private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        int pos = len - n;
        if(pos == 0) {
            dummyHead.next = head.next;
        }
        else {
            len = 0;
            curr = head;
            while(curr != null && len != pos - 1) {
                curr = curr.next;
                len++;
            }

            curr.next = curr.next.next;
        }
        return dummyHead.next;
    }
}
