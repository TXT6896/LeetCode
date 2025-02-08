package tao.algorithm.easy;

/**
 * @description：283. 移动零
 * @author： tao
 * @create： 2025/2/5 17:00
 */
public class Solution21 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
