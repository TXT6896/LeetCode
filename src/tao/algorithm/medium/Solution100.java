package tao.algorithm.medium;

import java.util.HashSet;
import java.util.TreeMap;

/**
 * @description：128. 最长连续序列
 * @author： tao
 * @create： 2025/2/6 16:24
 */
public class Solution100 {


    /**
     * 自己做的，跟下面主要区别在于使用了TreeMap排序，没必要
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int num : nums) {
            map.put(num, 0);
        }
        int maxCount = 1, tempCount = 1, prev = Integer.MAX_VALUE;

        for (Integer key : map.keySet()) {
            if (key == prev + 1) {
                tempCount++;
            } else {
                maxCount = Math.max(maxCount, tempCount);
                tempCount = 1;
            }
            prev = key;
        }
        return Math.max(tempCount,maxCount);
    }

    /**
     * 优秀解法
     * @param nums
     * @return
     */
    public static int longestConsecutive2(int[] nums) {
        //将元素放到哈希表，查询时间复杂度为O(1)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        for (Integer x : set) {
            //如果包含元素x-1，那序列起始值不为 x
            if (set.contains(x-1)) continue;
            //x 为起点，y为下一个连续值
            int y = x+1;
            //包含下一个连续值则继续寻找
            while (set.contains(y)){
                y++;
            }
            // y-x 为 当前序列连续数
            maxCount = Math.max(y-x,maxCount);
        }
     return maxCount;
    }
}
