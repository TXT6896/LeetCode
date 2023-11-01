package tao.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子集
 */
public class Solution23 {

    public static void main(String[] args) {

        List<List<Integer>> subsets = new Solution23().subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

    /**
     * 我的回溯超时
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTrace(res, new ArrayList<>(), nums, i);
        }
        return res;
    }

    public void backTrace(List<List<Integer>> res, List<Integer> list, int[] nums, int len) {
        if (list.size() == len) {
            ArrayList<Integer> select = new ArrayList<>(list);
            Collections.sort(select);
            if (!res.contains(select)) res.add(select);
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backTrace(res, list, nums, len);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 别人的优秀解法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
