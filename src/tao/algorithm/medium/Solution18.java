package tao.algorithm.medium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 字母异位词分组
 */
public class Solution18 {

    public static void main(String[] args) throws ParseException {
// 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date(); // 获取当前时间
        String format = sdf.format(time);// 格式化时间
        Date parse = sdf.parse("2023-01-01 00:00:00");
        System.out.println(parse.getTime());
        System.out.println(parse.getTime()+10368000000L);

        System.out.println(10368000000L / 24 / 60 / 60 / 1000);
        //new BigDecimal()

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(formatter.parse("2022-06-01 00:00:00 000").getTime());

        //System.out.printf("", new BigDecimal(""));



    }

    /**
     * 参考改进的
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 第一次写的
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagram(String[] strs) {
        List res = new ArrayList<>();
        HashMap<Integer, String> temp = new HashMap<>();
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strs));

        while (strList.size() > 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(strList.get(0));
            for (int j = 1; j < strList.size(); j++) {
                if (isSame(strList.get(0), strList.get(j))) {
                    list.add(strList.get(j));
                    strList.remove(j);
                    j = 0;
                }
            }
            res.add(list);
            strList.remove(0);
        }
        return res;
    }

    public boolean isSame(String s1, String s2) {
        if (null == s1 || null == s2) return false;
        if (s1.length() != s2.length()) return false;
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
