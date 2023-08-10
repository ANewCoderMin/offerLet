package offer.deleteMiddle75;

public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode slow = head;
        int count = 0;
        do {
            current = current.next;
            count++;
            if ((count & 1) == 0){
                pre = slow;
                slow = slow.next;
            }
        }while (current != null);

        if (pre != null){
            pre.next = slow.next;
        }else {
            return null;
        }
        return head;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
