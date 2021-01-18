package com.wangzz.jvm;

public class StackDemo {

    public static void main(String[] args) {
        maxDepth();
    }

    static int depth = 0;

    public static void maxDepth() {
        depth++;
        maxDepth();
    }

}
