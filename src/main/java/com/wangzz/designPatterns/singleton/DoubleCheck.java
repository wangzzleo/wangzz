package com.wangzz.designPatterns.singleton;

public class DoubleCheck {

    private static volatile DoubleCheck SINGLETON;

    private DoubleCheck() {}

    public static DoubleCheck getInstance() {
        if (SINGLETON == null) {
            synchronized (DoubleCheck.class) {
                if (SINGLETON == null) {
                    SINGLETON = new DoubleCheck();
                }
            }
        }
        return SINGLETON;
    }

}
