package tao.algorithm.easy;

/**
 * 使用最小花费爬楼梯
 */
public class Solution20 {

    /**
     * 我的原始人解法
     * @param cost
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

    /**
     * 极致优秀解法
     * @param cost
     * @return
     */
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
