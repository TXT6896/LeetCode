package tao.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class Solution16 {

    public static void main(String[] args) {
        Solution16 so = new Solution16();
        int[] ints = new int[]{2, 3, 5};
        List<List<Integer>> lists = so.combinationSum(ints, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, candidates, target, 0);
        return res;
    }


    /**
     * 改进后
     *
     * @param res
     * @param list
     * @param nums
     * @param target
     * @param index
     */
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, list, nums,target - nums[i], index);
            list.remove(list.size()-1);
        }
    }

    /**
     * 我写的
     *
     * @param res
     * @param list
     * @param nums
     * @param count
     * @param target
     */
   /* public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int count, int target) {
        if (count == target) {
            List<Integer> select = new ArrayList<>(list);
            Collections.sort(select);
            if (res.contains(select)) return;
            res.add(select);
            return;
        }
        if (count > target) return;
        for (int num : nums) {
            list.add(num);
            backtrack(res, list, nums, count + num, target);
            list.remove(list.size() - 1);
        }
    }*/
}
