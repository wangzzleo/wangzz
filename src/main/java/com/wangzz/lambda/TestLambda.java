package com.wangzz.lambda;

public class TestLambda {
    public static void main(String[] args){
        TestLambda tester = new TestLambda();


        //1. 使用lambda之前
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return 0;
            }
        };
        mathOperation.operation(1,2);

        //使用lambda之后

        //  类型声明
        MathOperation addition = Integer::sum;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) ->  a * b;

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        //System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));


        //2. 使用lambda之前
        GreetingService greetingService = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("Hello " + message);
            }
        };
        greetingService.sayMessage("wangzz");

        // 使用labmda之后

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        final int num = 1;
        Converter<Integer, String> s = (int param) -> System.out.println(param+num);
        s.convert(2);



    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
