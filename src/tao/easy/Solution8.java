package tao.easy;

/**
 * 移除元素
 */
public class Solution8 {
    public static void main(String[] args) {
        Solution8 so = new Solution8();
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[index++] = nums[i];
        }
        return index;
    }
}
