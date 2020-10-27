package com.wangzz.designPatterns.factory_method;

import com.wangzz.designPatterns.factory_method.factory.FactoryA;
import com.wangzz.designPatterns.factory_method.factory.FactoryB;

public class Client {
    public static void main(String[] args) {
        ProductFactory a = new FactoryA();
        Product product = a.createProduct();
        product.doSomething();
        ProductFactory b = new FactoryB();
        Product productB = b.createProduct();
        productB.doSomething();
    }
}
