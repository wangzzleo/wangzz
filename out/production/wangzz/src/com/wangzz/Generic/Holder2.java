package com.wangzz.Generic;

/**
 * Created by leomessi on 2018/5/23.
 */
public class Holder2 {
    private Object o;

    public Holder2(Object o) {
        this.o = o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public Object getO() {
        return o;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.getO();
        h2.setO("not is a Automobile");
        String s = (String) h2.getO();
        h2.setO(new Integer(4));
        Integer i = (Integer) h2.getO();

    }
}
