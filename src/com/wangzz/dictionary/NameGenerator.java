package com.wangzz.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author user
 */
public class NameGenerator implements Runnable {

    private String inputFilePath;
    private ArrayBlockingQueue<Name> queue;

    public NameGenerator(String inputFilePath, ArrayBlockingQueue<Name> queue) {
        this.inputFilePath = inputFilePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        //"C:\\Users\\user\\Desktop\\现代汉语词典.txt"
        File file = new File(inputFilePath);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            List<String> dictionary = new ArrayList<>();
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                if (s != null && s.length() > 1) {
                    dictionary.add(s);
                }
            }
            Random random = new Random();
            int i = 0;
            while (true) {
                StringBuilder nameString = new StringBuilder();

                random.ints(2, 0, dictionary.size()).
                        forEach((j) -> {
                            String partName = dictionary.get(j);
                            nameString.append(partName.charAt(1));
                        });
                System.out.printf("生成名称：%s,怎么样？（可以的话输入1）", nameString);
                Scanner sc = new Scanner(System.in);
                if (sc.hasNext() && Integer.valueOf(sc.next()) == 1) {
                    Name name = new Name();
                    name.setId(i++);
                    name.setGoodName(true);
                    name.setName(nameString.toString());
                    queue.put(name);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
