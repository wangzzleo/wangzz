package com.wangzz.dictionary;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NameGeneratorStater {

    private static ArrayBlockingQueue<Name> goodNameQueue = new ArrayBlockingQueue<>(10);;

    public static void main(String[] args) throws Exception {
        Runnable nameExporter = new NameExporter("C:\\\\Users\\\\user\\\\Desktop\\\\goodName.txt", goodNameQueue);
        Runnable nameGenerator = new NameGenerator("C:\\\\Users\\\\user\\\\Desktop\\\\现代汉语词典.txt", goodNameQueue);

        Thread generator = new Thread(nameGenerator);
        Thread exporter = new Thread(nameExporter);
        generator.start();
        exporter.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

        }));
    }

}
