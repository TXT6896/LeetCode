package tao;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    private static AtomicInteger inc = new AtomicInteger(0);

    public static void main(String[] args) {
    }

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }


    public Object convert(Object[] objects) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        for (Object object : objects) {
            for (Field field : object.getClass().getDeclaredFields()) {
                map.put(field.getName(),field.get(object));
            }
        }
        return map;
    }
}
