package tao.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 删除有序数组中的重复项
 */
public class Solution6 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr.length);

    }

    /*public int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int max = nums[nums.length - 1];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                count++;
                nums[i] = max;
                continue;
            }
            pre = nums[i];
        }
        Arrays.sort(nums);

        return nums.length - count;
    }*/

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
