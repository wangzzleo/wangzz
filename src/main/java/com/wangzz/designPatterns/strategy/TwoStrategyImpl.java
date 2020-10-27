package com.wangzz.designPatterns.strategy;

public class TwoStrategyImpl implements Strategy {
    @Override
    public void execute(String param) {
        System.out.println(param + " executing two strategy");
    }
}
