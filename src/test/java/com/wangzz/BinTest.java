package com.wangzz;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BinTest {

    @Test
    public void testBin() {
        System.out.println(Integer.toBinaryString(16384));
        System.out.println(Integer.toBinaryString(3089));

        System.out.println(16384&3089);
    }

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        printList(head);
        printList(reverseLinkedList(head));
    }

    public void printList(ListNode headNode) {
        while (headNode != null) {
            System.out.print(headNode.value + " ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverseLinkedList(ListNode headNode) {
        ListNode curr = headNode;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Test
    public void testSqrt() {
        System.out.println(mySqrt(2,3));
    }

    public double mySqrt(double number, int scale) {
        // 二分法
        double left = 0;
        double right = number;
        double middle = 0;
        double condition = Math.pow(10, -scale);
        while (right - left > condition) {
            middle = (right + left)/2;
            if (middle * middle == number) {
                return middle;
            } else if (middle * middle < number) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return new BigDecimal(middle).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
