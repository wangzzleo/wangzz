package com.wangzz.designPatterns.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new OneStrategyImpl());
        context.doExecute("zhangSan");

        context.setStrategy(new TwoStrategyImpl());
        context.doExecute("liSi");

    }

}
