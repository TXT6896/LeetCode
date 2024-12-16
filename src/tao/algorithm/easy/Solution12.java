package tao.algorithm.easy;

import java.util.HashMap;

/**
 * 爬楼梯
 */
public class Solution12 {

    private static HashMap<Integer, Integer> map = new HashMap<>(64);

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new Solution12().climbStairs(45));
        long l1 = System.currentTimeMillis();
        System.out.println((l1 - l) / 1000);

    }

    /**
     * 我的递归超时
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 别人的优秀写法
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] nums = new int[45];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }


    /**
     * 递归+缓存，效率优化
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int i = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, i);
        return i;
    }

    /**
     * 使用最小花费爬楼梯
     *
     * @param cost [10,15,20]
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        if (cost.length == 3) return cost[1];
        int[] climb = new int[cost.length + 1];
        climb[1] = cost[0];
        climb[2] = Math.min(cost[0], cost[1]);
        climb[3] = cost[1];
        for (int i = 4; i <= cost.length; i++) {
            climb[i] = Math.min((climb[i - 1] + cost[i - 1]), (climb[i - 2] + cost[i - 2]));
          //  climb[i] = Math.min((climb[i - 1]), (climb[i - 2]));
        }
        return climb[cost.length];
    }

    // [10,15,20,5,10]
    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];

        // 使用两个变量来存储前两个状态
        int first = cost[0];
        int second = cost[1];

        // 从第三个台阶开始计算
        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second; // 更新前一个状态
            second = current; // 更新当前状态
        }

        // 返回最后一个台阶的最小成本
        return Math.min(first, second);
    }
}
