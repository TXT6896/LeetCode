package tao.algorithm.easy;

import java.util.HashMap;

/**
 * 爬楼梯
 */
public class Solution12 {

    private static HashMap<Integer,Integer> map = new HashMap<>(64);
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new Solution12().climbStairs(45));
        long l1 = System.currentTimeMillis();
        System.out.println((l1-l)/1000);

    }

    /**
     * 我的递归超时
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
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] nums = new int[45];
        nums[0] = 1;
        nums[1] = 2;
        for(int i =2; i < n; i++){
            nums[i]= nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }


    /**
     * 递归+缓存，效率优化
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int i = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n,i);
        return i;
    }
}
