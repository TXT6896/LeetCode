package tao.medium;

import java.util.Arrays;

/**
 * 颜色分类
 */
public class Solution22 {

    public static void main(String[] args) {
        int[] nums = {0,0,1};
        new Solution22().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int p1 = 0;
        for (int i = 1; i < nums.length && p1 < i; i++) {
            if (nums[p1] != 0 && nums[i] == 0) {
                exchange(nums, i, p1);
                p1++;
                continue;
            }
            if (nums[p1] == 0 ) {
                p1++;
            }
        }
        for (int i = p1 + 1; i < nums.length && p1 < i; i++) {
            if (nums[p1] != 1 && nums[i] == 1) {
                exchange(nums, i, p1);
                p1++;
                continue;
            }
            if (nums[p1] == 1 ) {
                p1++;
            }
        }
        for (int i = p1 + 1; i < nums.length && p1 < i; i++) {
            if (nums[p1] != 2 && nums[i] == 2) {
                exchange(nums, i, p1);
                p1++;
                continue;
            }
            if (nums[p1] == 2 ) {
                p1++;
            }
        }
    }


    public void exchange(int[] nums, int i, int j) {
        int target = nums[i];
        nums[i] = nums[j];
        nums[j] = target;
    }
}
