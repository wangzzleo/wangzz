package com.wangzz.designPatterns.factory_method.prod;

import com.wangzz.designPatterns.factory_method.Product;

public class ProductB implements Product {
    @Override
    public void doSomething() {
        System.out.println("ProductB");
    }
}
