package tao;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Demo {

    public static void main(String[] args) throws ParseException {

        long timestamp = 1690819199000L; // 你的时间戳

        // 使用时间戳创建Instant对象
        Instant instant = Instant.ofEpochMilli(timestamp);

        // 将Instant对象转换为LocalDateTime对象
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        System.out.println("LocalDateTime: " + localDateTime);

    }
/*    public static void test(long i) {

        // 将时间戳转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.

        System.out.println("时间戳: " + i);
        System.out.println("转换后的LocalDateTime: " + localDateTime);
    }*/

}
