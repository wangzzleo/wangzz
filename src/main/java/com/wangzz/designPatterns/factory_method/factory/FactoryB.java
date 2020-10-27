package com.wangzz.designPatterns.factory_method.factory;

import com.wangzz.designPatterns.factory_method.Product;
import com.wangzz.designPatterns.factory_method.ProductFactory;
import com.wangzz.designPatterns.factory_method.prod.ProductB;

public class FactoryB implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
