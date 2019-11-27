package com.wangzz.thread;

import java.io.IOException;

/**
 * @author wangzz
 * @date
 */
public class HowToCreate {

    public static void main(String[] args) throws IOException {

        //基本：
        Thread t = new Thread(() -> System.out.println("创建线程-基本"), "子线程-1");
        t.start();

        //创建进程 获取Java Runtime
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("cmd /k start http://www.baidu.com");
        process.exitValue();

        try {
            threadJoinOneByOne();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //不鼓励
    private static class MyThread extends Thread {

        @Override
        public void run() {

            System.out.println("自定义扩展");
        }
    }


    private static void threadJoinOneByOne() throws InterruptedException {
        Thread t1 = new Thread(HowToCreate::action, "t1");
        Thread t2 = new Thread(HowToCreate::action, "t2");
        Thread t3 = new Thread(HowToCreate::action, "t3");
        Thread t4 = new Thread(HowToCreate::action, "T4");
        // start() 仅是通知线程启动
        t1.start();
        // join() 控制线程必须执行完成
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    private static void action() {
        System.out.printf("线程[%s] 正在执行...\n", Thread.currentThread().getName());  // 2
    }

}
