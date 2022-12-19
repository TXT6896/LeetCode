package tao.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 */
public class Solution12 {

    public static int count = 0;

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.threeSum(new int[]{0, 0, 0}));
        // System.out.println(count);
    }

    /**
     * 优秀的双指针解法(官方)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        //长度小于3，那还判断个啥，撤
        if (nums.length < 3) return result;
        //让数组有序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //如果开头大于0，那么和不可能为0
            if (nums[i] > 0) break;
            //避免重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //三数之第一个数
            int first = nums[i];
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {

                int second = nums[j];
                int third = -(first + second);
                //找到所有的数了
                if (set.contains(third)){
                    result.add(new ArrayList<>(Arrays.asList(first,second,third)));
                    //同样避免重复
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                }
                set.add(second);
            }
        }
        return result;
    }


    /**
     * 暴力三重for循坏，超时了。。
     *
     * @param nums
     * @return
     */
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag;
       *//* backtrack(res, list, nums);
        return res;*//*
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length; i1++) {
                for (int i2 = 0; i2 < nums.length; i2++) {
                    if (i == i1 || i1 == i2 || i == i2) continue;
                    if (nums[i] + nums[i1] + nums[i2] == 0) {
                        list.add(nums[i]);
                        list.add(nums[i1]);
                        list.add(nums[i2]);

                        if (res.size() == 0) {
                            res.add(new ArrayList<>(list));
                        }

                        if (nums[i] == 0 && nums[i1] == 1 && nums[i2] == -1) {
                            System.out.println(123);
                        }
                        flag = true;
                        for (int i3 = 0; i3 < res.size(); i3++) {
                            if (list.containsAll(res.get(i3)) && res.get(i3).containsAll(list)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            res.add(new ArrayList<>(list));
                        }
                        list.clear();
                    }
                }
            }
        }
        return res;
    }*/

}
