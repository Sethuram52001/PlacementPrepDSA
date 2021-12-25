class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedList {
    public static void insert(ListNode ll, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = null;

        if (ll == null) {
            ll = newNode;
        } else {
            ListNode curr = ll;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    
    private static ListNode delete(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next == null) {
            return dummyHead.next;
        }
        curr.next = curr.next.next;
        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode ll = new ListNode(1);
        insert(ll, 2);
        insert(ll, 3);
        insert(ll, 4);
        insert(ll, 5);

        printList(ll);

        ll = delete(ll, 1);

        printList(ll);
    }
}