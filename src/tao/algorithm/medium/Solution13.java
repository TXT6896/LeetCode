package tao.algorithm.medium;

/**
 * 搜索旋转排序数组
 */
public class Solution13 {
    public static void main(String[] args) {
        int[] ints = {1};
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.search(ints, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //数组右边有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
                continue;
            }
            //数组左边有序
            if (nums[mid] > target && target >= nums[left])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
