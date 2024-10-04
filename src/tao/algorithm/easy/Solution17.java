package tao.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：多数元素
 * @author： tao
 * @create： 2024/1/22 10:53
 */
public class Solution17 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5};
        System.out.println(majorityElement2(arr));
    }

    /**
     * word解法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * 糕手解法
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int res = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != res) {
                cnt--;
                if (cnt < 0) {
                    res = nums[i];
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }
        return res;
    }

}
