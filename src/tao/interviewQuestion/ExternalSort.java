package tao.interviewQuestion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1G数字文件，100M内存排序
 */
public class ExternalSort {

    public static void sortLargeFile(String filePath) throws IOException {
        List<File> tempFiles = new ArrayList<>();
        int chunkSize = 90 * 1024 * 1024; // 90MB
        int numSize = Integer.BYTES; // 假设每个数字为4字节
        
        // 1. 分块读取并排序
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int chunkIndex = 0;

            while ((bytesRead = bis.read(buffer)) != -1) {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < bytesRead; i += numSize) {
                    int number = ((buffer[i] & 0xFF) << 24) |
                            ((buffer[i + 1] & 0xFF) << 16) |
                            ((buffer[i + 2] & 0xFF) << 8) |
                            (buffer[i + 3] & 0xFF);
                    numbers.add(number);
                }

                Collections.sort(numbers);
                File tempFile = new File("temp_" + chunkIndex + ".txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                    for (int number : numbers) {
                        writer.write(number + "\n");
                    }
                }
                tempFiles.add(tempFile);
                chunkIndex++;
            }
        }

        // 2. 归并排序
        try (BufferedWriter outputWriter = new BufferedWriter(new FileWriter("sorted_output.txt"))) {
            PriorityQueue<NumberWithSource> minHeap = new PriorityQueue<>();

            // 初始化优先队列
            List<BufferedReader> readers = new ArrayList<>();
            for (File tempFile : tempFiles) {
                BufferedReader reader = new BufferedReader(new FileReader(tempFile));
                readers.add(reader);
                String line = reader.readLine();
                if (line != null) {
                    minHeap.offer(new NumberWithSource(Integer.parseInt(line), readers.size() - 1));
                }
            }

            while (!minHeap.isEmpty()) {
                NumberWithSource smallest = minHeap.poll();
                outputWriter.write(smallest.number + "\n");

                // 读取下一个数字
                BufferedReader reader = readers.get(smallest.sourceIndex);
                String nextLine = reader.readLine();
                if (nextLine != null) {
                    minHeap.offer(new NumberWithSource(Integer.parseInt(nextLine), smallest.sourceIndex));
                }
            }

            // 关闭所有读取器
            for (BufferedReader reader : readers) {
                reader.close();
            }
        }

        // 3. 删除临时文件
        for (File tempFile : tempFiles) {
            tempFile.delete();
        }
    }

    private static class NumberWithSource implements Comparable<NumberWithSource> {
        int number;
        int sourceIndex;

        public NumberWithSource(int number, int sourceIndex) {
            this.number = number;
            this.sourceIndex = sourceIndex;
        }

        @Override
        public int compareTo(NumberWithSource other) {
            return Integer.compare(this.number, other.number);
        }
    }

    public static void main(String[] args) {
        try {
            sortLargeFile("large_numbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
