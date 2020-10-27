package com.wangzz.designPatterns.strategy;

public class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doExecute(String param) {
        if (strategy == null) {
            System.out.println("execute error!");
        }
        strategy.execute(param);
    }

}
