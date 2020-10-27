package com.wangzz.struct.queue;

import java.util.*;

public class QueueByStack<E> implements Queue<E> {

    int capacity = 16;

    Stack<E> stackIn = new Stack<>();
    Stack<E> stackOut = new Stack<>();

    public QueueByStack(int capacity) {
        this.capacity = capacity;
    }

    public QueueByStack() {
    }

    public static void main(String[] args) {
        Queue<String> testQueue = new QueueByStack<>(2);
        System.out.println(testQueue.offer("wangzz"));
        System.out.println(testQueue.offer("kangl"));
        try {
            System.out.println(testQueue.add("kangl"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(testQueue.peek());
        System.out.println(testQueue.element());
        System.out.println(testQueue.poll());
        System.out.println(testQueue.remove());
        try {
            System.out.println(testQueue.remove());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(testQueue.peek());
        try {
            System.out.println(testQueue.element());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /**
     * 增加一个元素，如果队列满则抛出异常
     */
    @Override
    public boolean add(E e) {
        if (size() + 1 > capacity) {
            throw new IllegalStateException();
        }
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
        stackIn.push(e);
        return true;
    }


    /**
     * 增加一个元素，队列满则返回false
     */
    @Override
    public boolean offer(E e) {
        if (size() + 1 > capacity) {
            return false;
        }
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
        stackIn.push(e);
        return true;
    }

    /**
     * 移除一个元素并返回，队列为空则抛出异常
     */
    @Override
    public E remove() {
        if (size() <= 0) {
            throw new NoSuchElementException();
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }

    /**
     * 移除一个元素并返回，队列为空则返回null
     */
    @Override
    public E poll() {
        if (size() <= 0) {
            return null;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }

    /**
     * 返回头部元素，空则抛出异常
     */
    @Override
    public E element() {
        if (size() <= 0) {
            throw new NoSuchElementException();
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.peek();
    }

    /**
     * 返回头部元素，空则返回null
     */
    @Override
    public E peek() {
        if (size() <= 0) {
            return null;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.peek();
    }


    /** Collection`s methods**/
    @Override
    public int size() {
        return stackOut.size() > 0 ? stackOut.size() : stackIn.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
