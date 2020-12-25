package com.wangzz.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class SeqStack<T> extends Stack<T> {

    public static void main(String[] args) {
        Stack<String> stack = new SeqStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static final long serialVersionUID = -5413303117698554397L;

    private Deque<T> deque = new LinkedList<>();

    private int size = 0;

    @Override
    public T push(T item) {
        deque.addLast(item);
        size++;
        return item;
    }

    @Override
    public T pop() {
        if (size <= 0) {
            return null;
        }
        size--;
        return deque.pollLast();
    }

    @Override
    public boolean empty() {
        return size <= 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T s:
             deque) {
            sb.append(" ").append(s.toString());
        }
        return sb.toString();
    }
}
