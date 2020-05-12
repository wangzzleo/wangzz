package com.wangzz.cache;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyCache {

    public static void main(String[] args) {

//        if (args.length != 2) {
//            System.exit(1);
//        }

        String[] args1 = {"4","[4,3,2,1,4,3,5,4,3,2,1,5,4]"};
        String[] args2 = args1[1].replaceAll("\\[|\\]","").split(",");
        int size = Integer.valueOf(args1[0]);
        int count = 0;
        Queue<Integer> que = new LinkedBlockingQueue<>(size);
        for(String arg : args2) {
            if(!que.contains(Integer.valueOf(arg))) {
                count++;
            }
            if(!que.offer(Integer.valueOf(arg))) {
                que.poll();
                que.offer(Integer.valueOf(arg));
            }

        }
        System.out.println(count);

    }



}
