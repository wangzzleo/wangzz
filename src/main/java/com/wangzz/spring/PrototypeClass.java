package com.wangzz.spring;

public class PrototypeClass {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        PrototypeClass prototypeClass = new PrototypeClass();
        prototypeClass.setId(this.id);
        prototypeClass.setName(this.name);
        return getClass().getName() + "@" + Integer.toHexString(prototypeClass.hashCode());
    }
}
