package tao.algorithm.easy;

import java.text.ParseException;
import java.util.HashMap;

/**
 * 买卖股票的最佳时机
 */
public class Solution11 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws ParseException {
/*        String str = "11654";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }*/
       /* String s = "2023-03-20 13:46";
        LocalDateTime parse = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(parse);
        System.out.println(LocalDate.now().minusDays(1).toString());
        System.out.println(Instant.ofEpochMilli(Long.parseLong("1677600000000")).atZone(ZoneOffset.ofHours(8)).toLocalDate());
        System.out.println(LocalDate.parse("2000-01-01").atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());*//*
        String s = ",\\\"zh_CN\\\":\\\"测试账号发起的加佳集团财务付款申请单\\\"}";
        int cn = s.indexOf("CN");
        int i = s.lastIndexOf("}");
        System.out.println(s.substring(cn + 7, i - 2));
        System.out.println(LocalDate.now().toString());
        System.out.println(Instant.ofEpochMilli(Long.parseLong("946656000000")).atZone(ZoneOffset.ofHours(8)).toLocalDate());

        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        System.out.println(map.get(null));*/
        String s = "";
        String s1 = "";
        System.out.println(s.contains(s1));
    }

    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(prices[i] - min, res);
        }
        return res;
    }

}
