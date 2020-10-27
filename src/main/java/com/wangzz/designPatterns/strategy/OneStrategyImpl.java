package com.wangzz.designPatterns.strategy;

public class OneStrategyImpl implements Strategy {
    @Override
    public void execute(String param) {
        System.out.println(param + "executing one strategy");
    }
}
