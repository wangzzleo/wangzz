package com.wangzz.dictionary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;

public class NameExporter implements Runnable {

    private String exportFilePath;
    private ArrayBlockingQueue<Name> queue;

    public NameExporter(String exportFilePath, ArrayBlockingQueue<Name> queue) {
        this.exportFilePath = exportFilePath;
        this.queue = queue;
    }

    @Override
    public void run() {
        try(PrintWriter pw = new PrintWriter(new FileWriter(exportFilePath, true), true)) {
            pw.printf("\n");
            int times = 1;
            while (true) {
                Name name = queue.take();
                if (name.isGoodName()) {
                    //测试名字得分

                    //HttpClientUtil.sendPostSSLRequest("https://www.xingming.com/dafen/",)

                    pw.printf("%s,",name.getName());
                    if (times++ % 10 == 0) {
                        pw.printf(". \n");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
