package com.wangzz.spring;

public class SingletonClass {

    private PrototypeClass prototypeClass;

    public PrototypeClass getPrototypeClass() {
        return prototypeClass;
    }

    public void setPrototypeClass(PrototypeClass prototypeClass) {
        this.prototypeClass = prototypeClass;
    }

}
