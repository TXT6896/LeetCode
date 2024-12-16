package tao.designMode.strategy;

import java.util.HashMap;
import java.util.Map;

public class StragegyFactory {

private static Map<String,WorkStrategy> map;
    public static WorkStrategy build(String code){

        if (map == null) init();
        return map.get(code);

    }

    private static void init(){
        map = new HashMap<>();
        map.put("1", new DoctorWork());
        map.put("2", new TeacherWork());
        //
    }
}
