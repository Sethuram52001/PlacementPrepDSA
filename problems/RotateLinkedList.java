public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        ListNode curr = head;
        int n = 1;

        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        System.out.println(n);
        curr.next = head;

        k = k % n;
        int steps = n - k;
        while (steps-- > 0) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}
