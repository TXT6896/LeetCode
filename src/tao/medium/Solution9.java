package tao.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * 回溯
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class Solution9 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.permute(arr));
    }


    /**
     * 别人写的
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int num : nums) {
            if(!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
/**
 * 我写的
 */
/*    public List<List<Integer>> permute(int[] nums) {

        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Integer remove = collect.remove(0);
        return permute(remove,collect);


    }

    public List<List<Integer>> permute(int num, List<Integer> list) {
        if (list.size() <= 0) {
            ArrayList<List<Integer>> arrayList = new ArrayList<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(num);
            arrayList.add(list1);
            return arrayList;
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Integer remove = list.remove(0);
        List<List<Integer>> permute = permute(remove, list);
        for (int i = 0; i < permute.size(); i++) {
            for (int i1 = 0; i1 <= permute.get(i).size(); i1++) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.addAll(permute.get(i));
                integers.add(i1,num);
                lists.add(integers);
            }
        }

        return lists;
    }*/
}
