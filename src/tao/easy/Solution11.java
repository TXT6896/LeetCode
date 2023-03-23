package tao.easy;

import java.util.HashMap;

/**
 * 买卖股票的最佳时机
 */
public class Solution11 {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "11654";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }
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
