package com.funboy.其他;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: 王帆
 * @CreateTime: 2019-04-18 14:08
 * @Description:
 */
public class 多线程读取查找文件中的关键字 {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("input directory : ");
            String directory = scanner.nextLine();
            System.out.println("input keyword : ");
            String keyword = scanner.nextLine();
            Runnable enumerator = () -> {
                try {
                    enumeration(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();

            System.out.println(queue.toString());
            for (int i = 0; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    boolean done = false;
                    while (!done) {
                        try {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                new Thread(searcher).start();
            }


        }
    }

    public static void search(File file, String keywords) throws IOException {
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            int lineNum = 0;
            while (scanner.hasNext()) {
                lineNum++;
                String line = scanner.nextLine();
                if (line.contains(keywords)) {
                    System.out.printf("File name is %s , lineNumber is %d , the line is %s %n", file.getName(), lineNum, line);
                }
            }
        }
    }

    public static void enumeration(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumeration(file);
            } else {
                queue.put(file);
            }
        }
    }
}
