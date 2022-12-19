package tao.medium;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution14 {

    public static void main(String[] args) {

        Solution14 so = new Solution14();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(so.searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {

        int start;
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            start = (left + right) / 2;
            if (target < nums[start]) {
                right = start - 1;
            } else if (target > nums[start]) {
                left = start + 1;
            } else {
                res[0] = start;
                right = start - 1;
            }
        }

        int end;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            end = (left + right) / 2;
            if (target < nums[end]) {
                right = end - 1;
            } else if (target > nums[end]) {
                left = end + 1;
            } else {
                res[1] = end;
                left = end + 1;
            }
        }

        return res;
    }
}
