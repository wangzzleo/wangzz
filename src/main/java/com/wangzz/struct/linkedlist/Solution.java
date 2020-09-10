package com.wangzz.struct.linkedlist;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr1 = head;
        for (int i = 2; i <= 5; i++) {
            curr1.next = new ListNode(i);
            curr1 = curr1.next;
        }
        curr1.next = null;
        show(head);
        ListNode curr2 = reverseList1(head);
        System.out.println();
        show(curr2);
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 1 2 3 4 5
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = reverseList2(head.next);//5 -> 4
        head.next.next = head;//4 -> 3
        head.next = null;//3 -> null
        return cur;//5 -> 4 -> 3
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
